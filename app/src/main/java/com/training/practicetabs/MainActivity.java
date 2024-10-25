package com.training.practicetabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.training.practicetabs.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    //My Fragments
    ListenFragment listenFragment = new ListenFragment();
    ReadFragment readFragment = new ReadFragment();
    WriteFragment writeFragment = new WriteFragment();

    //ArrayList to add fragment and be easy to access them
    ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list.add(readFragment);
        list.add(writeFragment);
        list.add(listenFragment);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this,list);
        binding.pager.setAdapter(myPagerAdapter);

        binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "You selected this before", Toast.LENGTH_SHORT).show();
            }
        });
        /*Also we can use this code
        new TabLayoutMediator(binding.tabs, binding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                list.get(position);
            }
        }).attach();*/
    }
}