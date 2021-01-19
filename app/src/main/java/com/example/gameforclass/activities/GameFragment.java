package com.example.gameforclass.activities;

import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gameforclass.TowerDefensePog;


public class GameFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_game, container, false);

        Point point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(point);
        return new TowerDefensePog(this.getActivity(), point.x, point.y);

    }

}