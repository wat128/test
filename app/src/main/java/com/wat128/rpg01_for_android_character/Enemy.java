package com.wat128.rpg01_for_android_character;


public class Enemy extends Battler {

    public Enemy(Status status) {
         super(status);
    }

    public Enemy(Status status, AcquireSkillList acquireSkills) {
        super(status, acquireSkills);
    }
}

