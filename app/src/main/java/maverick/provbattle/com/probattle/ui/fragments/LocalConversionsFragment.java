package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentConversionsBinding;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LocalConversionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class LocalConversionsFragment extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
FragmentConversionsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_conversions, container, false);

        setupListener();
        return binding.getRoot();
    }



    private void setupListener(){

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
            mListener.onLocalConversionsFragmentInteraction(OnFragmentInteractionListener.MENU);
        }
    }


    public interface OnFragmentInteractionListener {
        int MENU=0;
        // TODO: Update argument type and name
        void onLocalConversionsFragmentInteraction(int i);
    }
}
