package maverick.provbattle.com.probattle.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import maverick.provbattle.com.probattle.ui.fragments.Crypto2CryptoConversionFragment;
import maverick.provbattle.com.probattle.ui.fragments.CryptoDetailsFragment;
import maverick.provbattle.com.probattle.ui.fragments.LocalConversionsFragment;
import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.ui.fragments.StatisticalRepresentationFragment;
import maverick.provbattle.com.probattle.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity implements View.OnClickListener ,
        Crypto2CryptoConversionFragment.OnFragmentInteractionListener,
        CryptoDetailsFragment.OnFragmentInteractionListener,
        LocalConversionsFragment.OnFragmentInteractionListener,
        StatisticalRepresentationFragment.OnFragmentInteractionListener {

    ActivityStartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_start);
        setupListeners();

    }
    private void setupListeners(){
        binding.menuIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(binding.menuIcon==view){
            binding.drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {

        if(binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onCryptoDetailsFragmentInteraction(int i) {

    }

    @Override
    public void onCrypto2CryptoFragmentInteraction(int i) {

    }

    @Override
    public void onStatisticalRepresentationFragmentInteraction(int i) {

    }

    @Override
    public void onLocalConversionsFragmentInteraction(int i) {

    }
}
