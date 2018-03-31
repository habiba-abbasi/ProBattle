package maverick.provbattle.com.probattle.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Habiba Abbasii on 31/03/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    List<Fragment> list;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {

        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
