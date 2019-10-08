package com.example.notifications;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.notifications.DTOs.ExcerptDTO;

public class SwipeAdapter extends FragmentStatePagerAdapter {
    //PageFragment frag;
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
        //frag = new PageFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = new PageFragment();

        Bundle bundle = new Bundle();
        bundle.putString("bookName","Book "+position);
        bundle.putString("excerptText", "Excerpt "+position);
        //bundle.putString("bookName",frag.db.getExcerptsList().get(position).bookName);
        //bundle.putString("excerptText",frag.db.getExcerptsList().get(position).excerptText );
        //frag.db.getExcerptsList();
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public int getCount() {
        //return frag.db.getExcerptsList().size();
        return 10;
    }
}
