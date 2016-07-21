package com.concussionconnect.concussionproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;

import java.util.HashMap;

/**
 * Created by annamcabee on 4/19/16.
 */
public class Page2 extends ActionBarActivity {
    static float score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.rate);
        System.out.println(ratingbar.getRating());
    }

    public void next(View view) {
        RatingBar ratingbar1 = (RatingBar) findViewById(R.id.rate);
        RatingBar ratingbar2 = (RatingBar) findViewById(R.id.rate2);
        RatingBar ratingbar3 = (RatingBar) findViewById(R.id.rate3);
        RatingBar ratingbar4 = (RatingBar) findViewById(R.id.rate4);
        RatingBar ratingbar5 = (RatingBar) findViewById(R.id.rate5);
        HashMap<String, Integer> map = new HashMap<>();
        score = ratingbar1.getRating() + ratingbar2.getRating() + ratingbar3.getRating()
                + ratingbar4.getRating() + ratingbar5.getRating();
        System.out.println();
        System.out.println(score);
        System.out.println();
        Intent intent = new Intent(this, Page3.class);
        Bundle bundle = new Bundle();
        bundle.putFloat("Score", score);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
