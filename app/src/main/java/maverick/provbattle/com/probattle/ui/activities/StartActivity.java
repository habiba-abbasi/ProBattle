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

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,new CryptoDetailsFragment())
                .commit();

    }
    private void setupListeners(){
        binding.menuIcon.setOnClickListener(this);
        binding.cryptoDetails.setOnClickListener(this);
        binding.cryptoToCrypto.setOnClickListener(this);
        binding.statistics.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(binding.menuIcon==view){
            binding.drawer.openDrawer(GravityCompat.START);
        }
        else if (binding.cryptoToCrypto==view){
            binding.drawer.closeDrawer(GravityCompat.START);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,new Crypto2CryptoConversionFragment())
                    .commit();
        }
        else if(binding.statistics==view){
            binding.drawer.closeDrawer(GravityCompat.START);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,new StatisticalRepresentationFragment())
                    .commit();
        }
        else if(binding.cryptoDetails==view){
            binding.drawer.closeDrawer(GravityCompat.START);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,new CryptoDetailsFragment())
                    .commit();
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

        switch(i){
            case CryptoDetailsFragment.OnFragmentInteractionListener.MENU:
                binding.drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onCrypto2CryptoFragmentInteraction(int i) {

        switch(i){
            case Crypto2CryptoConversionFragment.OnFragmentInteractionListener.MENU:
                binding.drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onStatisticalRepresentationFragmentInteraction(int i) {

        switch(i){
            case StatisticalRepresentationFragment.OnFragmentInteractionListener.MENU:
                binding.drawer.openDrawer(GravityCompat.START);
        }

    }

    @Override
    public void onLocalConversionsFragmentInteraction(int i) {

        switch(i){
            case LocalConversionsFragment.OnFragmentInteractionListener.MENU:
                binding.drawer.openDrawer(GravityCompat.START);
        }
    }
}
