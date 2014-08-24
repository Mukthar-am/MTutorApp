package com.tutor.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by mukthar.ahmed on 24/08/14.
 */
public class Help extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);

    }
}
