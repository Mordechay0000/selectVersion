package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewResult extends AppCompatActivity implements View.OnClickListener {

    Bundle extras;
    int[] valueArray;
    Intent i;
    TextView[] textViewsArray;
    Button btnNext;
    Button btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);

        extras = getIntent().getExtras();
        valueArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
        valueArray = extras.getIntArray("valueArray");

        Log.i("valueArray", String.valueOf(valueArray));

        textViewsArray = new TextView[]{
                findViewById(R.id.textView6),
                findViewById(R.id.textView9),
                findViewById(R.id.textView10),
                findViewById(R.id.textView11),
                findViewById(R.id.textView12),
                findViewById(R.id.textView13),
                findViewById(R.id.textView14),
                findViewById(R.id.textView20),
                findViewById(R.id.textView15),
                findViewById(R.id.textView16),
                findViewById(R.id.textView17),
                findViewById(R.id.textView18),
                findViewById(R.id.textView19)
        };

        btnNext = findViewById(R.id.button12);
        btnBack = findViewById(R.id.button14);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);


        String text1 = "פתוח";
        String text2 = "חסום";
        String text3 = "לבחירה מאוחר יותר";
        String textElse = "שגיאה/לא מוגדר";


        for (int i = 0; i <= valueArray.length - 1; i++) {
            if(valueArray[i] == Constants.SWITCH_DISABLE_OFF && valueArray[i] == Constants.SWITCH_DISABLE_ON){
                textViewsArray[i].setTextColor(Color.GRAY);
            }
            Log.e("valuStop", String.valueOf(valueArray[i]));
            String valueText;
            if(valueArray[i] == 1){
                valueText = text1;
            }else if(valueArray[i] == 2){
                valueText = text2;
            }else if(valueArray[i] == 3){
                valueText = text3;
            }else{
                valueText = textElse;
            }
            textViewsArray[i].setText(textViewsArray[i].getText() + valueText);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == btnNext){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            alertDialog.setTitle("שים לב!");
            alertDialog.setMessage("האם אתה בטוח?");

            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ביטול", new
                            DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {} });

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "אישור", new
                    DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    i = new Intent(ViewResult.this, apply_version.class);
                                    i.putExtra("valueArray", valueArray);
                                    startActivity(i);
                                }});
alertDialog.show();
        }else if (view == btnBack){
            this.onBackPressed();
        }
    }
}