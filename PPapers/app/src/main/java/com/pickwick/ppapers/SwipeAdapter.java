package com.pickwick.ppapers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pickwick.ppapers.DTOs.ExcerptDTO;

import java.util.List;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    DatabaseHelper db;
    List<ExcerptDTO> excerptsList;
    public SwipeAdapter(FragmentManager fm, DatabaseHelper db) {
        super(fm);
        //frag = new PageFragment();
        this.db = db;
        this.excerptsList = db.getExcerptsList();
    }

    @Override
    public Fragment getItem(int position) {
        SwipeFragment fragment = new SwipeFragment();
        if(excerptsList.size() <= 0){
            this.excerptsList = db.getExcerptsList();
        }
        Bundle bundle = new Bundle();
        bundle.putString("bookName",excerptsList.get(position).bookName);
        bundle.putString("excerptText",excerptsList.get(position).excerptText );
        bundle.putByteArray("imageBlob",excerptsList.get(position).imageBlob);
        bundle.putString("amazonUri",excerptsList.get(position).amazonUri);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return db.getExcerptsList().size();
    }
}
