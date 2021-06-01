package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;
import java.util.Random;


public class Frag2 extends Fragment implements RssReader.RssCallback {

    Button buttoncolor;
    TextView tvFrag2;
    private RssReader rssReader = new RssReader(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        tvFrag2 = view.findViewById(R.id.tvFrag2);
        buttoncolor = view.findViewById(R.id.btnFrag2);
        rssReader.loadFeeds("https://www.channelnewsasia.com/rssfeeds/8395986");
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

    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        Random rnd = new Random();
        int number= rnd.nextInt(rssList.get(0).getChannel().getItems().size());
        String description = rssList.get(0).getChannel().getItems().get(number).getDescription();
        String title = rssList.get(0).getChannel().getItems().get(number).getTitle();
        tvFrag2.setText(title + "\n" + description);
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        Toast.makeText(getContext(), "Unable to retrieve RSS!", Toast.LENGTH_SHORT).show();
    }
}