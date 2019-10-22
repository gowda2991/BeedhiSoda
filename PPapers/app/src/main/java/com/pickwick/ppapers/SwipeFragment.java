package com.pickwick.ppapers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class SwipeFragment extends Fragment {

    TextView bookName;
    TextView excerpt;

    public SwipeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.individual_excerpt_card, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);

        bookName = view.findViewById(R.id.book_name);
        excerpt  = view.findViewById(R.id.excerpt_content);
        Bundle bundle = getArguments();
        String bookNameText = bundle.get("bookName").toString();
        String excerptContent = bundle.get("excerptText").toString();

        bookName.setText(bookNameText);
        excerpt.setText(excerptContent);

        return view;
    }
}
