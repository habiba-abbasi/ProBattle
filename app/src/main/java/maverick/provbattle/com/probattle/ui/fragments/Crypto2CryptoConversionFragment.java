package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentCrypto2CryptoConversionBinding;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Crypto2CryptoConversionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Crypto2CryptoConversionFragment extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    FragmentCrypto2CryptoConversionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_crypto2_crypto_conversion, container, false);

         setupListener();
         return binding.getRoot();
    }



    private void setupListener(){

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

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCrypto2CryptoFragmentInteraction(int i);
    }
}
