package com.supperapper.vathna.uidesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        final TextView tvResult = findViewById(R.id.tv_result);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> counties = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item);
        counties.add("America");
        counties.add("Cambodia");
        counties.add("Thia");
        counties.add("Vietnam");
        counties.add("China");

        spinner.setAdapter(counties);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvResult.setText(rating + "");
            }
        });
    }
}
