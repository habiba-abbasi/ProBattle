package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentCrypto2CryptoConversionBinding;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Crypto2CryptoConversionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Crypto2CryptoConversionFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    FragmentCrypto2CryptoConversionBinding binding;
    List<String> cryptoNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_crypto2_crypto_conversion, container, false);
        cryptoNames = new ArrayList<>();
        cryptoNames.add("BTC");
        cryptoNames.add("ETH");
        cryptoNames.add("XRP");
        cryptoNames.add("BCH");
        cryptoNames.add("LTC");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                cryptoNames
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.enteredCrypto.setAdapter(adapter);
        binding.calculatedCrypto.setAdapter(adapter);
                setupListener();

        return binding.getRoot();
    }


    private void setupListener() {
        binding.convertButton.setOnClickListener(this);
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
        if(view==binding.convertButton){
             convert();
        }
        if(view==binding.menuIcon){
            mListener.onCrypto2CryptoFragmentInteraction(OnFragmentInteractionListener.MENU);
        }
    }

    public void convert(){
        binding.calculatedAmount.setText(binding.enteredAmount.getText().toString());
    }


    public interface OnFragmentInteractionListener {
        int MENU=0;
        // TODO: Update argument type and name
        void onCrypto2CryptoFragmentInteraction(int i);
    }
}
