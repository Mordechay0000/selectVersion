package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;


public class is_app_or_fuction extends AppCompatActivity implements View.OnClickListener {
    Bundle extras;
    int id;
    int[] valueArray;
    int value;
    int[] image;
    String[] text;
    String[] textProp;
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

        extras = getIntent().getExtras();
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

        valueArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        isBlockedArray = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false};
        image = new int[]{R.drawable.ic_launcher_browser, R.drawable.ic_launcher_kosher_play, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_gallery3d};
        text = new String[]{"אינטרנט", "כשר פליי", "שירותי גוגל פליי", "חנות גוגל פליי", "התקנת אפליקציות", "חיבור למחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
        textProp = new String[]{"גישה לאינטרנט ע\"י נתונים ניידים/wifi", "אפליקציית כשר פליי", "שירותי גוגל פלי", "חנות גוגל פלי", "אפשרות להתקין אפליקציות ממקור חיצוני", "חיבור המכשיר להעברת מדיה מהמחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
        next();
    }

    public void getValue() {
        id = extras.getInt("id");
        valueArray = extras.getIntArray("valueArray");
        isBlockedArray = extras.getBooleanArray("isBlockedArray");
        value = valueArray[id];

        Log.i("id", String.valueOf(id));
        Log.i("value", String.valueOf(value));
        Log.i("valueArray", String.valueOf(valueArray));
        Log.i("isBlockedArray", String.valueOf(isBlockedArray));
    }

    public void next() {
        getValue();
        img.setImageResource(image[id]);
        txt.setText(text[id]);
        txtProp.setText(textProp[id]);
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
        Log.e("aaaaaaaaaaaaa", String.valueOf(valueArray[id]));
        if (id == valueArray.length - 8) {
            i = new Intent(this, select_app.class);
        } else {
            i = new Intent(this, is_app_or_fuction.class);
            if (valueArray[id] == 2) {
                if (id == 0 || id == 2) {
                    valueArray[id + 1] = 2;
                    isBlockedArray[id + 1] = true;
                    Log.e("IsBlock", String.valueOf(isBlockedArray[id + 1]));
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