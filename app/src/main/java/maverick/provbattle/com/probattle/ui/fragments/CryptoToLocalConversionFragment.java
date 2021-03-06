package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentCryptoToLocalConversionBinding;
import maverick.provbattle.com.probattle.databinding.FragmentLocalToCryptoConversionBinding;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CryptoToLocalConversionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CryptoToLocalConversionFragment extends Fragment implements View.OnClickListener {
    List<String> cryptoNames;
    FragmentCryptoToLocalConversionBinding binding;
    private OnFragmentInteractionListener mListener;

    public CryptoToLocalConversionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_crypto_to_local_conversion, container, false);
        cryptoNames = new ArrayList<>();
        cryptoNames.add("BTC");
        cryptoNames.add("XRP");
        cryptoNames.add("BCH");
        cryptoNames.add("LTC");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                cryptoNames
        );
        binding.convertButtonCryptoToLocal.setOnClickListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.enteredCryptoSpinner.setAdapter(adapter);
        return binding.getRoot();
    }

    private void setupLitener() {

        binding.convertButtonCryptoToLocal.setOnClickListener(this);
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

        if (view == binding.convertButtonCryptoToLocal) {

            if (binding.enteredAmountCrypto.length() > 0) {
                double amount = Double.parseDouble(binding.enteredAmountCrypto.getText().toString());

                switch (binding.enteredCryptoSpinner.getSelectedItemPosition()) {
                    case 0:
                        binding.calculatedAmount.setText(String.valueOf(BTCtoPKR(amount)));
                    case 1:
//                  binding.calculatedAmount.setText(String.valueOf(BtCoPKR(amount)));
                    case 2:
                        binding.calculatedAmount.setText(String.valueOf(BTCtoPKR(amount)));
                    case 3:


                }

            }
         else {
            Toast.makeText(getContext(), "Enter amount", Toast.LENGTH_SHORT).show();
        }
    }

}


    private double BTCtoPKR(double amount) {

        amount = amount * 794742.81;

        return amount;

    }


public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
}
}
