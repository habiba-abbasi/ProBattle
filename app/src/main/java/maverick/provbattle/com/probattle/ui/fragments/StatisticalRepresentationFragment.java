package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

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
    List<String> change;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_statistical_representation, container, false);
        change= new ArrayList<>();
        change.add("1 hour change");
        change.add("24 hours change");
        change.add("7 days change");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                change
        );
        binding.changeSpinner.setAdapter(adapter);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });

        binding.graph.addSeries(series);
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
            mListener.onStatisticalRepresentationFragmentInteraction(OnFragmentInteractionListener.MENU);
        }
    }


    public interface OnFragmentInteractionListener {
        int MENU=0;
        // TODO: Update argument type and name
        void onStatisticalRepresentationFragmentInteraction(int i);
    }
}
