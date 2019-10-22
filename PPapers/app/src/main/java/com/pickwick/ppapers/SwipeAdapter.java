package com.pickwick.ppapers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    DatabaseHelper db;
    public SwipeAdapter(FragmentManager fm, DatabaseHelper db) {
        super(fm);
        //frag = new PageFragment();
        this.db = db;
    }

    @Override
    public Fragment getItem(int position) {
        SwipeFragment fragment = new SwipeFragment();

        Bundle bundle = new Bundle();
        bundle.putString("bookName",db.getExcerptsList().get(position).bookName);
        bundle.putString("excerptText",db.getExcerptsList().get(position).excerptText );

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return db.getExcerptsList().size();
    }
}
