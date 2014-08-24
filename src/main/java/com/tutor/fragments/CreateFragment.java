package com.tutor.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tutor.app.R;

/**
 * Created by mukthar.ahmed on 23/08/14.
 */
public class CreateFragment extends Fragment {
    ListView listView ;

    public CreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.maths_grades, container, false);
        return rootView;
    }

}
