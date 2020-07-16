package com.example.crusher2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.crusher2.fragment.ItemFragment;
import com.example.crusher2.fragment.ItemFragment2;
import com.example.crusher2.fragment.Main2Activity;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tb_tablayout)
    TabLayout tbTablayout;
    @BindView(R.id.vp_viewpager)
    ViewPager vpViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        ButterKnife.bind (this);

        tbTablayout.setupWithViewPager (vpViewpager);
        vpViewpager.setAdapter (new FragmentPagerAdapter (getSupportFragmentManager ()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new ItemFragment ();
                    case 1:
                        return new ItemFragment2 ();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "笑话";
                    case 1:
                        return "天气";
                }
                return null;
            }
        });
    }


    public void getData(View view) {
        Intent intent = new Intent (MainActivity.this, Main2Activity.class);
        startActivity (intent);
    }
}