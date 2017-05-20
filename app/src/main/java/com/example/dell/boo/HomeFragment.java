package com.example.dell.boo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SUMIT_THAKUR on 06/05/17.
 */

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.vpSwipe);
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(int position) {
                if(position==0){
                    return new ItemFragment();
                }else{
                    return new ItemFragment();
                }
            }
            };
        viewPager.setAdapter(fragmentStatePagerAdapter);

        return view;
    }
}
