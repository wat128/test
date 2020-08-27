package com.wat128.rpg01_for_android_scene;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wat128.rpg01_for_android.R;
import com.wat128.rpg01_for_android_character.*;

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

        Player player = Player.getInstance();

        TextView hpView = findViewById(R.id.hp_val);
        hpView.setText(String.valueOf(player.getHp()));

        TextView mpView = findViewById(R.id.mp_val);
        mpView.setText(String.valueOf(player.getMp()));

        TextView lvView = findViewById(R.id.level_val);
        lvView.setText(String.valueOf(player.getLv()));

        final int enemyId = intent.getIntExtra("Enemy_Data", 0);
        Enemy enemy = EnemyFactory.create(enemyId);
        Log.d("debug", "Enemy ID : " + String.valueOf(enemyId));

        ImageView enemyImage = findViewById(R.id.enemyImage);
        enemyImage.setImageResource(enemy.getImageId());

        TextView msgBoxView = findViewById(R.id.msg_box);
        msgBoxView.setText("モンスターがあらわれた");
    }
}