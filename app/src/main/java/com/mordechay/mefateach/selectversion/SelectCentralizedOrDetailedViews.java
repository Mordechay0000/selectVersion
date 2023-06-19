package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.mordechay.mefateach.selectversion.activities.CentralizedActivity;
import com.mordechay.mefateach.selectversion.activities.SelectVersion;

public class SelectCentralizedOrDetailedViews extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_centralized_or_detailed_views);

        final MaterialCardView mtcDetail = findViewById(R.id.start_card_detailed_view);
        final MaterialCardView mtcCentralize = findViewById(R.id.start_card_centralized_view);
        mtcDetail.setOnClickListener(this);
        mtcCentralize.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, v.getId() == R.id.start_card_detailed_view ? SelectVersion.class : CentralizedActivity.class));
    }
}