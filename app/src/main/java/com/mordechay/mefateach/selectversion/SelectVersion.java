package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectVersion extends AppCompatActivity implements View.OnClickListener {

    CardView cdvB0;

    CardView cdvB1;
    CardView cdvB2;
    CardView cdvB3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_version);

        cdvB0 = findViewById(R.id.cardView_b4); //create find view for card view
        cdvB0.setOnClickListener(this); //register card view to event on click listener

        cdvB1 = findViewById(R.id.cardView_b1); //create find view for card view
        cdvB2 = findViewById(R.id.cardView_b2); //create find view for card view
        cdvB3 = findViewById(R.id.cardView_b3); //create find view for card view
        cdvB1.setOnClickListener(this); //register card view to event on click listener
        cdvB2.setOnClickListener(this); //register card view to event on click listener
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
        i.putExtra("valueArray", Constants.VALUE[num]);
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
}