package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.mordechay.mefateach.selectversion.data.Constants;


public class is_app_or_fuction extends AppCompatActivity implements View.OnClickListener {
    int id;
    int[] valueArray;
    int value;
    ImageView img;
    TextView txt;
    TextView txtProp;
    RadioButton rdbYes;
    RadioButton rdbNo;
    RadioButton rdbLater;
    Button next;
    Button back;
    Intent i;
    boolean[] isBlockedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_app_or_fuction);

        img = findViewById(R.id.imageView);
        txt = findViewById(R.id.textView5);
        txtProp = findViewById(R.id.textView4);
        rdbYes = findViewById(R.id.radioButton);
        rdbNo = findViewById(R.id.radioButton2);
        rdbLater = findViewById(R.id.radioButton3);
        next = findViewById(R.id.button2);
        back = findViewById(R.id.button4);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

        next();
    }

    public void getValue() {
        Bundle extras  = getIntent().getExtras();
        id = extras.getInt("id");
        valueArray = extras.getIntArray("valueArray");
        isBlockedArray = extras.getBooleanArray("isBlockedArray");
        Log.d("tag", valueArray.toString());
        value = valueArray[id];

        Log.i("id", String.valueOf(id));
        Log.i("value", String.valueOf(value));
        Log.i("valueArray", String.valueOf(valueArray));
        Log.i("isBlockedArray", String.valueOf(isBlockedArray));
    }

    public void next() {
        getValue();
        img.setImageResource(Constants.IMAGE[id]);
        txt.setText(Constants.TITLE[id]);
        txtProp.setText(Constants.SUB_TITLE[id]);
        if (valueArray[id] == 1) {
            rdbYes.setChecked(true);
        } else if (valueArray[id] == 2) {
            rdbNo.setChecked(true);
        }
        if (isBlockedArray[id]) {
            rdbYes.setEnabled(false);
            rdbNo.setEnabled(false);
            rdbLater.setEnabled(false);
            next.setText("דילוג");
        }
    }

    @Override
    public void onClick(View view) {
        if (view == next) {
            if (rdbYes.isChecked()) {
                valueArray[id] = 1;
                intent();
            } else if (rdbNo.isChecked()) {
                valueArray[id] = 2;
                intent();
            } else if (rdbLater.isChecked()) {
                valueArray[id] = 3;
                intent();
            } else {
                Toast.makeText(this, "לא בחרת כלום.", Toast.LENGTH_LONG).show();
            }

            Log.e("id", String.valueOf(id));
            Log.e("length", String.valueOf(valueArray.length));
        } else if (view == back) {
            this.onBackPressed();
        }
    }


    public void intent() {
        if (id == valueArray.length - 8) {
            i = new Intent(this, selectApp.class);
        } else {
            i = new Intent(this, is_app_or_fuction.class);
            if (valueArray[id] == 2) {
                if (id == 0 || id == 2) {
                    valueArray[id + 1] = 2;
                    isBlockedArray[id + 1] = true;
                    Log.d("IsBlock", String.valueOf(isBlockedArray[id + 1]));
                }
            }else{
                valueArray[id + 1] = 0;
                isBlockedArray[id + 1] = false;
            }
            i.putExtra("id", id + 1);
        }
        i.putExtra("valueArray", valueArray);
        i.putExtra("isBlockedArray", isBlockedArray);
        startActivity(i);
    }
}