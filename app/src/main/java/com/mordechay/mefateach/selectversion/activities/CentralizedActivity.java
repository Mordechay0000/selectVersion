package com.mordechay.mefateach.selectversion.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mordechay.mefateach.selectversion.R;
import com.mordechay.mefateach.selectversion.data.Constants;
import com.mordechay.mefateach.selectversion.data.DataTransfer;

public class CentralizedActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private final int[] IMAGE;
    private final String[] TITLE;
    private final String[] SUB_TITLE;


    private SwitchMaterial[] swiArray;

    public CentralizedActivity() {

        //initialize image field
        switch (DataTransfer.device) {
            case QIN_F21_PRO:
            case QIN_F22:
            case QIN_F22_PRO:
                IMAGE = Constants.IMAGE_QIN;
                TITLE = Constants.TITLE_QIN;
                SUB_TITLE = Constants.SUB_TITLE_QIN;
                break;
            case XINGYU_S500:
                IMAGE = Constants.IMAGE_XINGYU_S500;
                TITLE = Constants.TITLE_XINGYU_S500;
                SUB_TITLE = Constants.SUB_TITLE_XINGYU_S500;
                break;
            case GOOGLE_SDK_GPHONE64_ARM64:
                IMAGE = Constants.IMAGE_XINGYU_S500;
                TITLE = Constants.TITLE_XINGYU_S500;
                SUB_TITLE = Constants.SUB_TITLE_XINGYU_S500;
                break;
            default:
            case NOT_IDENTIFIED:
                IMAGE = null;
                TITLE = null;
                SUB_TITLE = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeUI();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.centralized_btn_next) {
            int[] valueArr = getFromSwitch();
            Intent intent = new Intent();
            intent.putExtra("valueArray", valueArr);
            intent.setClass(this, ViewResult.class);
            startActivity(intent);
        }
    }

    private int[] getFromSwitch() {
        int[] valueArr = new int[swiArray.length];
        for (int i = 0; i < swiArray.length; i++) {
            valueArr[i] = swiArray[i].isEnabled() ? swiArray[i].isChecked() ? Constants.SWITCH_ON : Constants.SWITCH_OFF : swiArray[i].isChecked() ? Constants.SWITCH_DISABLE_ON : Constants.SWITCH_DISABLE_OFF;
        }
        return valueArr;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == swiArray[Constants.INTERNET]) {
            {
                SwitchMaterial switchMaterial = swiArray[Constants.KOSHER_PLAY];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiArray[Constants.GOOGLE_PLAY_SERVICES];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
            {
                SwitchMaterial switchMaterial = swiArray[Constants.GOOGLE_PLAY];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        } else if (buttonView == swiArray[Constants.SYSTEM_APP_VIDEO]) {
            {
                SwitchMaterial switchMaterial = swiArray[Constants.SYSTEM_APP_GALLERY];
                if (switchMaterial != null && !switchMaterial.isChecked()) {
                    switchMaterial.setChecked(false);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        } else if (buttonView == swiArray[Constants.SYSTEM_APP_GALLERY]) {
            {
                SwitchMaterial switchMaterial = swiArray[Constants.SYSTEM_APP_VIDEO];
                if (switchMaterial != null) {
                    switchMaterial.setChecked(isChecked);
                    switchMaterial.setEnabled(!isChecked);
                }
            }
        }
    }


    private void initializeUI() {
        Bundle extras = getIntent().getExtras();
        int[] valueArray = null;
        if (extras != null) {
            valueArray = extras.getIntArray("valueArray");
        }


        /*

        Button btnNext = findViewById(R.id.centralized_btn_next);
        btnNext.setOnClickListener(this);

        // Create the first horizontal LinearLayout
        LinearLayout firstRow = new LinearLayout(this);
        firstRow.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // ImageView for the first item
        ImageView firstImageView = new ImageView(this);
        firstImageView.setLayoutParams(new LinearLayout.LayoutParams(
                dpToPx(60), dpToPx(55)
        ));
        firstImageView.setImageResource(R.drawable.ic_launcher_duoqin_music);
        firstRow.addView(firstImageView);

        // Switch for the first item
        Switch firstSwitch = new Switch(this);
        firstSwitch.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT, 1
        ));
        firstSwitch.setText("נגן");
        firstSwitch.setTextSize(13);
        firstSwitch.setTypeface(null, Typeface.BOLD);
        firstRow.addView(firstSwitch);

        // ImageView for the second item
        ImageView secondImageView = new ImageView(this);
        secondImageView.setLayoutParams(new LinearLayout.LayoutParams(
                dpToPx(60), dpToPx(55)
        ));
        secondImageView.setImageResource(R.drawable.ic_launcher_pulsar);
        firstRow.addView(secondImageView);

        // Switch for the second item
        MaterialSwitch secondSwitch = new MaterialSwitch(this);
        secondSwitch.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT, 1
        ));
        secondSwitch.setText("וידאו");
        secondSwitch.setTextColor(Color.parseColor("#FF0303"));
        secondSwitch.setTextSize(13);
        secondSwitch.setTypeface(null, Typeface.BOLD);
        firstRow.addView(secondSwitch);
*/

        ScrollView scrollView = new ScrollView(this);

        LinearLayout rootLayout = Components.Utilities.createLinearLayout(this, LinearLayout.VERTICAL);

        TextView textView = new TextView(this);

        textView.setLayoutParams(Components.Utilities.createLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        textView.setText(R.string.function_removed);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setGravity(Gravity.CENTER);
        rootLayout.addView(textView);

        LinearLayout linearLayout = Components.Utilities.createLinearLayout(this, LinearLayout.VERTICAL);

        MaterialCardView cardView = new MaterialCardView(this);
        cardView.setLayoutParams(Components.Utilities.createLayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                dpToPx(30), dpToPx(10), dpToPx(30), dpToPx(10), 0, 0
        ));
        cardView.setRadius(dpToPx(5));
        cardView.setCardElevation(dpToPx(5));
        cardView.setMaxCardElevation(dpToPx(5));
        cardView.setContentPadding(dpToPx(5), dpToPx(5), dpToPx(5), dpToPx(0));

        LinearLayout linearLayout1 = Components.Utilities.createLinearLayout(this, LinearLayout.VERTICAL);
        cardView.addView(linearLayout1);

        swiArray = new SwitchMaterial[TITLE.length];
        for (int i = 0; i < swiArray.length; i ++){
            if (IMAGE[i] == 0){
                // Create a new MaterialCardView
                MaterialCardView cardView1 = new MaterialCardView(this);
                cardView1.setLayoutParams(Components.Utilities.createLayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dpToPx(30), dpToPx(10), dpToPx(30), dpToPx(10), 0, 0
                ));
                cardView1.setRadius(dpToPx(5));
                cardView1.setCardElevation(dpToPx(5));
                cardView1.setMaxCardElevation(dpToPx(5));
                cardView1.setContentPadding(dpToPx(5), dpToPx(5), dpToPx(5), dpToPx(5));
                rootLayout.addView(cardView1);

                // Create the SwitchMaterial
                swiArray[i] = new SwitchMaterial(this);
                swiArray[i].setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                swiArray[i].setGravity(Gravity.CENTER);
                swiArray[i].setText(TITLE[i]);
                swiArray[i].setOnCheckedChangeListener(this);

                cardView1.addView(swiArray[i]);
            } else{
                LinearLayout linearLayout2 = Components.Utilities.createLinearLayout(this, LinearLayout.HORIZONTAL, Components.Utilities.createLayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        0,3,0,dpToPx(5) , dpToPx(5), dpToPx(5)));
                linearLayout1.addView(linearLayout2);

                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(Components.Utilities.createLayoutParams(dpToPx(60), dpToPx(55)));
                imageView.setImageResource(IMAGE[i]);
                linearLayout2.addView(imageView);

                swiArray[i] = new SwitchMaterial(this);
                swiArray[i].setLayoutParams(Components.Utilities.createLayoutParams(dpToPx(0), LinearLayout.LayoutParams.MATCH_PARENT, 1, Gravity.CENTER));
                swiArray[i].setGravity(Gravity.CENTER);
                swiArray[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                swiArray[i].setTypeface(null, Typeface.BOLD);
                swiArray[i].setText(TITLE[i]);
                swiArray[i].setOnCheckedChangeListener(this);
                linearLayout2.addView(swiArray[i]);

                if (++i >= swiArray.length) break;

                ImageView imageView1 = new ImageView(this);
                imageView1.setLayoutParams(Components.Utilities.createLayoutParams(dpToPx(60), dpToPx(55)));
                imageView1.setImageResource(IMAGE[i]);
                linearLayout2.addView(imageView1);

                swiArray[i] = new SwitchMaterial(this);
                swiArray[i].setLayoutParams(Components.Utilities.createLayoutParams(dpToPx(0), LinearLayout.LayoutParams.MATCH_PARENT, 1, Gravity.CENTER));
                swiArray[i].setGravity(Gravity.CENTER);
                swiArray[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                swiArray[i].setTypeface(null, Typeface.BOLD);
                swiArray[i].setText(TITLE[i]);
                swiArray[i].setOnCheckedChangeListener(this);
                linearLayout2.addView(swiArray[i]);

            }

            if (valueArray == null || valueArray[i] == Constants.INDEFINITE || valueArray[i] == Constants.SWITCH_OFF) {
                swiArray[i].setEnabled(true);
                swiArray[i].setChecked(false);
            } else if (valueArray[i] == Constants.SWITCH_ON) {
                swiArray[i].setEnabled(true);
                swiArray[i].setChecked(true);
            } else if (valueArray[i] == Constants.SWITCH_DISABLE_OFF) {
                swiArray[i].setEnabled(false);
                swiArray[i].setChecked(false);
            } else if (valueArray[i] == Constants.SWITCH_DISABLE_ON) {
                swiArray[i].setEnabled(false);
                swiArray[i].setChecked(true);
            }
        }

        rootLayout.addView(linearLayout);
        rootLayout.addView(cardView);

        int buttonStyle = androidx.appcompat.R.style.Widget_AppCompat_Button_Colored;
        Button button = new Button( new ContextThemeWrapper(this, buttonStyle), null, buttonStyle);
        button.setId(R.id.centralized_btn_next);
        button.setOnClickListener(this);
        button.setLayoutParams(Components.Utilities.createLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM));
        button.setGravity(Gravity.CENTER);
        button.setText(R.string.next);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
        }else {
            int color = ContextCompat.getColor(this, R.color.purple_500);
            Drawable background = DrawableCompat.wrap(button.getBackground());
            DrawableCompat.setTint(background, color);
            button.setBackground(background);
        }
        rootLayout.addView(button);

        scrollView.addView(rootLayout);
        setContentView(scrollView);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    static class Components{
        static class ImageSwitch{
            public static LinearLayout createImageSwitch(Context context){
                LinearLayout linearLayout = Utilities.createLinearLayout(context, LinearLayout.HORIZONTAL);

                return linearLayout;
            }
        }




        static class Utilities {
            @NonNull
            public static LinearLayout.LayoutParams createLayoutParams(int sizeWidth, int sizeHeight, int marginLeft, int marginTop, int marginRight, int marginBottom, int marginStart, int marginEnd){
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(sizeWidth , sizeHeight);
                if (marginLeft != 0 || marginTop != 0 || marginRight != 0 || marginBottom !=0)
                    layoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
                if (marginStart != 0)
                    layoutParams.setMarginStart(marginStart);
                if (marginEnd != 0)
                    layoutParams.setMarginEnd(marginEnd);
                return layoutParams;
            }
            @NonNull
            public static LinearLayout.LayoutParams createLayoutParams(int sizeWidth, int sizeHeight){
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(sizeWidth, sizeHeight);
                return layoutParams;
            }
            @NonNull
            public static LinearLayout.LayoutParams createLayoutParams(int sizeWidth, int sizeHeight, int gravity){
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(sizeWidth, sizeHeight);
                layoutParams.gravity = gravity;
                return layoutParams;
            }
            @NonNull
            public static LinearLayout.LayoutParams createLayoutParams(int sizeWidth, int sizeHeight, int weight, int gravity){
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(sizeWidth, sizeHeight, weight);
                layoutParams.gravity = gravity;
                return layoutParams;
            }
            @NonNull
            public static LinearLayout createLinearLayout(Context cnt, int ori){
                LinearLayout linearLayout = new LinearLayout(cnt);
                linearLayout.setLayoutParams(createLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                linearLayout.setOrientation(ori);
                return linearLayout;
            }

            @NonNull
            public static LinearLayout createLinearLayout(Context cnt, int ori, LinearLayout.LayoutParams layoutParams){
                LinearLayout linearLayout = new LinearLayout(cnt);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOrientation(ori);
                return linearLayout;
            }

        }
    }

}