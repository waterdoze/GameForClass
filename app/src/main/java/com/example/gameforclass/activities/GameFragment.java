package com.example.gameforclass.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gameforclass.TowerDefensePog;


public class GameFragment extends Fragment {


    private static final String TAG = "Testing";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TowerDefensePog TDP = new TowerDefensePog(this.getActivity());




        return TDP;

    }

}