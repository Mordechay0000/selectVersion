package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent i;

    CardView cdvB0;

    CardView cdvB1;
    CardView cdvB2;
    CardView cdvB3;

    int[] valueArrayB0;

    int[] valueArrayB1;
    int[] valueArrayB2;
    int[] valueArrayB3;

    boolean[] isBlockedArrayB0;

    boolean[] isBlockedArrayB1;
    boolean[] isBlockedArrayB2;
    boolean[] isBlockedArrayB3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueArrayB0 = new int[]{0, 0, 0, 0, 0, 0/* no graphi */, 0, 0, 0, 0, 0, 0/* no graphi */, 0};

        valueArrayB1 = new int[]{2, 2, 2, 2, 2, 1/* no graphi */, 1, 2, 2, 2, 2, 2/* no graphi */, 2};
        valueArrayB2 = new int[]{2, 2, 2, 2, 2, 1/* no graphi */, 1, 1, 1, 1, 1, 2/* no graphi */, 2};
        valueArrayB3 = new int[]{2, 2, 2, 2, 2, 1/* no graphi */, 1, 1, 1, 1, 1, 1/* no graphi */, 2};

        isBlockedArrayB0 = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false};

        isBlockedArrayB1 = new boolean[]{false,true,false,true,false,false,false,true,false,false,false,false,false};
        isBlockedArrayB2 = new boolean[]{false,true,false,true,false,false,false,false,false,false,false,false,false};
        isBlockedArrayB3 = new boolean[]{false,true,false,true,false,false,false,false,false,false,false,false,false};


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
        if(view == cdvB0) { //if click card view b4
            intent(valueArrayB0,isBlockedArrayB0,false);
        }
        else if(view == cdvB1) { //if click card view b1
            intent(valueArrayB1,isBlockedArrayB1,true);
        }
        else if(view == cdvB2) { //if click card view b2
            intent(valueArrayB2,isBlockedArrayB2,true);
        }
        else if(view == cdvB3) { //if click card view b3
            intent(valueArrayB3,isBlockedArrayB3,true);
        }
    }


    /*
    method for open intent 'is_app_or_function'
    and put extra id (=0) and put value getting
     */
    public void intent(int[] value, boolean[] isBlocked,boolean skipScreen){
        if(!skipScreen){
            i = new Intent(MainActivity.this, is_app_or_fuction.class); //set intent to open another activity is_app_or_function
        /**
         * transfer info the version to activity
         */
        i.putExtra("id", 0);
        i.putExtra("isBlockedArray", isBlocked);
        }else{
            i = new Intent(MainActivity.this, select_app.class); //set intent to open another activity view result
            i.putExtra("isBlockedArray", isBlocked);
        }
        i.putExtra("valueArray", value);
        startActivity(i);
    }
}