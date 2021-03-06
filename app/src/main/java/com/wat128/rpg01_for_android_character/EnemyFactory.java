package com.wat128.rpg01_for_android_character;

import android.util.Log;

public class EnemyFactory {

    public static Enemy create(final BattlerList enemyId) {

        final Enemy enemy;

        switch(enemyId) {
            case SLIME:
                enemy = new Enemy(new SlimeStatus());
                break;
            case NINE_TAILED_FOX:
                enemy = new Enemy(new NineTailedFoxStatus(), new NineTailedFoxSkillList());
                break;
            default:
                Log.d("debug", "EnemyFactory Failed");
                enemy = new Enemy(new SlimeStatus());
                break;
        }

        return enemy;
    }
}
