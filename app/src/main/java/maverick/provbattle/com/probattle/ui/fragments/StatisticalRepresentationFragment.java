package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentStatisticalRepresentationBinding;
import maverick.provbattle.com.probattle.ui.SharedPreferenceManager;
import maverick.provbattle.com.probattle.ui.model.CryptoModel;


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
    String spinnerValueChange="",spinnerValueNames;
    List<CryptoModel> list;
    List<String> cryptoNames;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_statistical_representation, container, false);
        change = new ArrayList<>();
        cryptoNames= new ArrayList<>();
        change.add("1 hour change");
        change.add("24 hours change");
        change.add("7 days change");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                change
        );
        list=SharedPreferenceManager.getDetails(getActivity());
        for(CryptoModel model: list){
            cryptoNames.add(model.getName());
        }
        ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_item,
                cryptoNames
        );
        binding.changeSpinner.setAdapter(adapter);
        binding.changeSpinnerCryptoName.setAdapter(nameAdapter);
        binding.graph.setVisibility(View.INVISIBLE);

        binding.changeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValueChange=change.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        binding.changeSpinnerCryptoName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValueNames=cryptoNames.get(position);
                setValueOnGraph();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

//        binding.graph.addSeries(series);
        setupListener();
        return binding.getRoot();
    }


    private void setupListener() {
    }

    public void setValueOnGraph(){
        binding.graph.removeAllSeries();
        System.out.println("logg setOngraphChange");
        double percentChange;

        CryptoModel value=null;
        for(CryptoModel model: list){
            if(spinnerValueNames.equals(model.getName())){
                value=model;
                break;
            }
        }

        if(value==null){
            return;
        }
        System.out.println("logg spinner value change="+spinnerValueChange);
        if(spinnerValueChange.equals("1 hour change")){
            double sum=Double.parseDouble(value.getPrice_usd());
            percentChange=Double.parseDouble(value.getPercent_change_1h());
            double value1,value2,value3,value4;
                sum+=percentChange*Double.parseDouble(value.getPrice_usd());
                value1=sum;
                sum+=percentChange*Double.parseDouble(value.getPrice_usd());
                value2=sum;
                sum+=percentChange*Double.parseDouble(value.getPrice_usd());
                value3=sum;
                sum+=percentChange*Double.parseDouble(value.getPrice_usd());
                value4=sum;
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, value1),
                new DataPoint(1, value2),
                new DataPoint(2, value3),
                new DataPoint(3, value4),
        });
            binding.graph.setVisibility(View.VISIBLE);
            binding.graph.addSeries(series);
        }
        else if(spinnerValueChange.equals("24 hours change")){
            double sum=Double.parseDouble(value.getPrice_usd());
            percentChange=Double.parseDouble(value.getPercent_change_1h());
            double value1,value2,value3,value4;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value1=sum;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value2=sum;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value3=sum;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value4=sum;
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, value1),
                    new DataPoint(1, value2),
                    new DataPoint(2, value3),
                    new DataPoint(3, value4),
            });
            binding.graph.setVisibility(View.VISIBLE);
            binding.graph.addSeries(series);
        }
        else if(spinnerValueChange.equals("7 days change")){
            double sum=Double.parseDouble(value.getPrice_usd());
            percentChange=Double.parseDouble(value.getPercent_change_1h());
            double value1,value2,value3,value4;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value1=sum;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value2=sum;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value3=sum;
            sum+=percentChange*Double.parseDouble(value.getPrice_usd());
            value4=sum;
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, value1),
                    new DataPoint(1, value2),
                    new DataPoint(2, value3),
                    new DataPoint(3, value4),
            });
            binding.graph.setVisibility(View.VISIBLE);
            binding.graph.addSeries(series);
        }
        else{
            Toast.makeText(getActivity(),"Please select change.",Toast.LENGTH_SHORT).show();
        }

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
