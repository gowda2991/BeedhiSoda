package com.example.notifications;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {
    DatabaseHelper db;
    TextView bookName;
    TextView excerptTxt;



    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        bookName = (TextView)view.findViewById(R.id.bookName);
        excerptTxt = view.findViewById(R.id.excerptText);
        Bundle bundle = getArguments();
         String bookNameText = bundle.get("bookName").toString();
         String excerptContent = bundle.get("excerptText").toString();

         bookName.setText(bookNameText);
         excerptTxt.setText(excerptContent);
        return view;
    }

}
