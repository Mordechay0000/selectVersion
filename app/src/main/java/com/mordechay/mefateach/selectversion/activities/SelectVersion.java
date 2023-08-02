package com.mordechay.mefateach.selectversion.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.mordechay.mefateach.selectversion.R;
import com.mordechay.mefateach.selectversion.data.Constants;

public class SelectVersion extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    ColorStateList originalColor;
    MaterialCardView cdvB0;

    MaterialCardView cdvB1;
    MaterialCardView cdvB2;
    MaterialCardView cdvB3;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_version);

        cdvB0 = findViewById(R.id.cardView_b4); //create find view for card view
        cdvB0.setOnTouchListener(this);
        cdvB0.setOnClickListener(this); //register card view to event on click listener

        cdvB1 = findViewById(R.id.cardView_b1); //create find view for card view
        cdvB2 = findViewById(R.id.cardView_b2); //create find view for card view
        cdvB3 = findViewById(R.id.cardView_b3); //create find view for card view
        cdvB1.setOnTouchListener(this);
        cdvB1.setOnClickListener(this); //register card view to event on click listener
        cdvB2.setOnTouchListener(this);
        cdvB2.setOnClickListener(this); //register card view to event on click listener
        cdvB3.setOnTouchListener(this);
        cdvB3.setOnClickListener(this); //register card view to event on click listener

    }

    @Override
    public void onClick(View view) {  //then click card view
        if (view == cdvB0) { //if click card view b4
            intent(0, false);
        } else if (view == cdvB1) { //if click card view b1
            intent(1, true);
        } else if (view == cdvB2) { //if click card view b2
            intent(2, true);
        } else if (view == cdvB3) { //if click card view b3
            intent(3, true);
        }
    }


    /*
    method for open intent 'is_app_or_function'
    and put extra id (=0) and put the received value
     */
    public void intent(int num, boolean skipScreen) {
        Intent i = new Intent();
        i.putExtra("valueArray", Constants.valuesArray[num]);
        /*if (!skipScreen) {
            i.setClass(SelectVersion.this, is_app_or_fuction.class);
            i.putExtra("id", 0);
        } else {
            i.setClass(SelectVersion.this, selectApp.class); //set intent to open another activity view result
        }
         */
        i.setClass(SelectVersion.this, CentralizedActivity.class); //set intent to open another activity view result
        startActivity(i);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        MaterialCardView materialCardView = (MaterialCardView) v;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                originalColor = materialCardView.getCardBackgroundColor();
                materialCardView.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                materialCardView.setCardBackgroundColor(originalColor);
                break;
        }
        return false;
    }
}