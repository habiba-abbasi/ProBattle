package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentStatisticalRepresentationBinding;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatisticalRepresentationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class StatisticalRepresentationFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
FragmentStatisticalRepresentationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_statistical_representation, container, false);

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
        void onStatisticalRepresentationFragmentInteraction(int i);
    }
}
