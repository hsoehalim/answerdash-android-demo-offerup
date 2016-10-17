package com.answerdash.android.demo.offerup;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Nullable
    private DrawerLayout drawerLayout;

    @Nullable
    private NavigationView sideDrawer;

    @Nullable
    private ActionBarDrawerToggle drawerToggle;

    @Nullable
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = setupDrawerToggle();

        sideDrawer = (NavigationView) findViewById(R.id.sideDrawer);
        setupSideDrawer();

        if (drawerLayout != null) {
            drawerLayout.addDrawerListener(drawerToggle);
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

        if (drawerToggle == null) {
            return;
        }

        drawerToggle.syncState();
        if (savedInstanceState == null) {
            setupInitialEntry();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        if (drawerToggle == null) {
            return;
        }

        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return drawerToggle != null && drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {

        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void setupSideDrawer() {

        if (sideDrawer == null) {
            return;
        }
        sideDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectSideDrawerEntry(menuItem);
                        return true;
                    }
                });
    }

    private void setupInitialEntry() {

        if (sideDrawer == null) {
            return;
        }

        if (getFragmentManager().findFragmentById(R.id.fragmentContainer) == null) {
            sideDrawer.getMenu().performIdentifierAction(R.id.drawer_popularity, 0);
        }
    }


    private void selectSideDrawerEntry(MenuItem menuItem) {

        Fragment fragment = null;
        Intent intent = null;

        switch (menuItem.getItemId()) {
            case R.id.drawer_popularity:
                fragment = new PopularFragment();
                break;
            case R.id.drawer_funiture:
                fragment = new FurnitureFragment();
                break;
            case R.id.drawer_futton:
                fragment = new FutonFragment();
                break;
            default:
                fragment = new PopularFragment();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
            menuItem.setChecked(true);

        } else {
            startActivity(intent);
        }

        if (drawerLayout != null) {
            drawerLayout.closeDrawers();
        }
    }

}
