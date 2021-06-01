package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;


public class Frag1 extends Fragment {

    Button buttoncolor;
    ImageView iv ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);

        iv = view.findViewById(R.id.iv);

        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Presidents-Without-Pets.png";
        Picasso.with(getContext()).load(imageUrl).into(iv);

        buttoncolor = view.findViewById(R.id.btnFrag1);
        buttoncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                view.setBackgroundColor(color);
            }
        });




        return view;
    }
}