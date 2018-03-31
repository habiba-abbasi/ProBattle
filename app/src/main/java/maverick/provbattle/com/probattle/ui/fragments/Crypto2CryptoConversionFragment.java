package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
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

            if(binding.enteredCrypto.getSelectedItemPosition()!=binding.calculatedCrypto.getSelectedItemPosition()){

                if(binding.enteredAmount.length()>0){

                }
                else{
                    Toast.makeText(getContext(), "Enter amount", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getContext(), "Select different crypto currency to convert", Toast.LENGTH_SHORT).show();
            }
        }
        if(view==binding.menuIcon){
            mListener.onCrypto2CryptoFragmentInteraction(OnFragmentInteractionListener.MENU);
        }
    }



     private double BTCtoETH(double amount){

        amount=amount/398.969;
        return amount;
    }  private double BTCtoXRP(double amount){

        amount=amount / 0.007389;
        return amount;
    }  private double BTCtoBCH(double amount){

        amount=amount/0.101123;
        return amount;
    }  private double BTCtoLTC(double amount){

        amount=amount/0.0173081;
        return amount;
    }
    private double ETHtoBTC(double amount){

        amount=amount*0.0572;
        return amount;
    }

    private double XRPtoBTc(double amount){

        amount=amount*0.00007389;
        return amount;
    }

   private double BCHtoBTc(double amount){
       amount=amount*0.101123;
       return amount;
   }

   private double LTCtoBTc(double amount){
       amount=amount*0.173081;
       return amount;
   }









    public interface OnFragmentInteractionListener {
        int MENU=0;
        // TODO: Update argument type and name
        void onCrypto2CryptoFragmentInteraction(int i);
    }
}
