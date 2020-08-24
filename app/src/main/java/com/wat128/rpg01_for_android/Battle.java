package com.wat128.rpg01_for_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Battle extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle);

        Button btnAttack = findViewById(R.id.attack);
        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnEscape = findViewById(R.id.escape);
        btnEscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();

        final int enemyId = intent.getIntExtra("Enemy_Data", 0);
        Enemy enemy = EnemyFactory.create(enemyId);
        Log.d("debug", "Enemy ID : " + String.valueOf(enemyId));

        ImageView enemyImage = findViewById(R.id.enemyImage);
        enemyImage.setImageResource(enemy.getImageId());

    }
}
