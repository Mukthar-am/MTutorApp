package com.tutor.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tutor.app.R;

/**
 * Created by mukthar.ahmed on 23/08/14.
 */
public class HelpFragment extends Fragment {

    public HelpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.help_layout, container, false);
        return rootView;
    }

}   // HelpFragment()
