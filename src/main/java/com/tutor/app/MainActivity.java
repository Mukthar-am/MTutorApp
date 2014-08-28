package com.tutor.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tutor.helper.DrawerItemCustomAdapter;
import com.tutor.helper.ObjectDrawerItem;



public class MainActivity extends Activity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    public ActionBarDrawerToggle mDrawerToggle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();

        // To pull all drawer Item Strings from String.xml:
        mNavigationDrawerItemTitles= getResources().
            getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        // Create drawer Item using ObjectDrawerItem.java class:
        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[4];
        drawerItem[0] = new ObjectDrawerItem(R.drawable.ic_maths, "Maths");
        drawerItem[1] = new ObjectDrawerItem(R.drawable.ic_geography, "Geography");
        drawerItem[2] = new ObjectDrawerItem(R.drawable.ic_fun, "Fun/Stories");
        drawerItem[3] = new ObjectDrawerItem(R.drawable.ic_help, "Help");


        DrawerItemCustomAdapter adapter =
            new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);

        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        // Action bar:
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            R.drawable.ic_drawer,
            R.string.drawer_open,
            R.string.drawer_close
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };


        // Setting toggle listner:
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);


    }   // onCreate()



    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Menu options:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.tutor.app.R.menu.main, menu);
        return true;
    }


    // Drawer click item listner:
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }


    // Post Creative:
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    // select an fragment item:
    private void selectItem(int position) {
        // Handle Nav Options
        Intent intent;
        switch (position) {
            case 0:
                startActivity(new Intent(this, MathsGradesActivity.class));
                break;

            case 1:
                startActivity(new Intent(this, GeographyGrades.class));
                break;

            case 2:
                startActivity(new Intent(this, Help.class));
                break;

            case 3:
                startActivity(new Intent(this, Help.class));
                break;

            default:
                break;

        }   // end switch()


    }   // selectItem()


    // #########################################################################################
    /*  // This is the way a fragment should be called from a fragment click:
    // select an fragment item:
    private void selectItem(int position) {
        Fragment fragment = null;

        // Handle Nav Options
        Intent intent;
        switch (position) {
            case 0:
                // This is the way we class a fragment-class:
                fragment = new CreateFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            Log.e("MainActivity", "Fragment NOT NULL...");
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            //getActionBar().setTitle(mNavigationDrawerItemTitles[position]);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment...!!!");
        }

    }   // selectItem()
    */

}   // end class()

