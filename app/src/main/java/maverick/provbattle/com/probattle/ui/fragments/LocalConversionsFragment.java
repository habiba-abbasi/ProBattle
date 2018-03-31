package maverick.provbattle.com.probattle.ui.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.FragmentConversionsBinding;
import maverick.provbattle.com.probattle.ui.adapters.ViewPagerAdapter;


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




        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("To Local"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("To Crypto "));

        List<Fragment> list=new ArrayList();
        list.add(new CryptoToLocalConversionFragment());
        list.add(new LocalToCryptoConversionFragment());


        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager(),list);
        binding.viewPager.setAdapter(viewPagerAdapter);


        //it is causing the tabs title in tab layout to look as seleceted whenever tab changes
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));



        //whenever tab is clicked or slided it passes an event
        //especially used to catch event when tab is selected by clicking on tab title rather thn sliding
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
//                /.makeText(MainActivity.this, "on tab selected listener is non", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


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
