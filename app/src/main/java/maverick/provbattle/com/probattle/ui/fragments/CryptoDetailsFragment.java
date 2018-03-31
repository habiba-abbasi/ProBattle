package maverick.provbattle.com.probattle.ui.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentCryptoDetailsBinding;
import maverick.provbattle.com.probattle.ui.SharedPreferenceManager;
import maverick.provbattle.com.probattle.ui.adapters.CryptoAdapter;
import maverick.provbattle.com.probattle.ui.model.Crypto;
import maverick.provbattle.com.probattle.ui.model.CryptoModel;
import maverick.provbattle.com.probattle.ui.rest.ApiClient;
import maverick.provbattle.com.probattle.ui.rest.ApiInterface;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CryptoDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CryptoDetailsFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    FragmentCryptoDetailsBinding binding;
    List<CryptoModel> list;
    ApiInterface apiInterface;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_crypto_details, container, false);

        list = new ArrayList<>();
        progressDialog=new ProgressDialog(getContext());
        final CryptoAdapter cryptoAdapter = new CryptoAdapter(list);
        binding.recyclerView.setAdapter(cryptoAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        //end point /api/users?
        Call<List<CryptoModel>> call = apiInterface.getCryptoList(10);
        progressDialog.setMessage("Fetching ");
        progressDialog.show();

        call.enqueue(new Callback<List<CryptoModel>>() {
            @Override
            public void onResponse(Call<List<CryptoModel>> call, Response<List<CryptoModel>> response) {

                progressDialog.dismiss();
                //succesfuull
                if (response.isSuccessful()) {
                    list = response.body();
                    binding.recyclerView.setAdapter(new CryptoAdapter(list));

                    cryptoAdapter.notifyDataSetChanged();

                    //settingitems in shared
                    SharedPreferenceManager.putDetailsInShared(getContext(),new Gson().toJson(list));





                }
                //error
                else {
                    System.out.println("Helloo " + response.errorBody().toString());
                    Toast.makeText(getContext(), "Error " + response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CryptoModel>> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println("Hello " + t.getMessage());
            }
        });


        setupListener();

        return binding.getRoot();
    }


    private void setupListener() {

        binding.menuIcon.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        if(view==binding.menuIcon){
            mListener.onCryptoDetailsFragmentInteraction(OnFragmentInteractionListener.MENU);
        }
    }


    public interface OnFragmentInteractionListener {
        int MENU=0;
        // TODO: Update argument type and name
        void onCryptoDetailsFragmentInteraction(int i);
    }
}
