package com.attozoic.muzejirade.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attozoic.muzejirade.R;

/**
 * Created by Nebojsa on 05/17/17.
 */

public class AboutFragment extends BaseFragment {

    private static AboutFragment instance;

    public static Fragment getInstance() {
        if (instance == null) {
            instance = new AboutFragment();
        }

        return instance;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        return view;
    }
}
