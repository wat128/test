package com.wat128.rpg01_for_android_character;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.wat128.rpg01_for_android.R;

enum SkillId {
    Fire,
    PowerUp,
    Heal
}

public abstract class Skill {
    String _name;
    SkillId _id;
    float _power;
    int _mp;
    Type _type;
    TargetStatus _target;
    int _anime;

    public Skill(String name, SkillId id, float power, int mp, Type type, TargetStatus target, final int anime) {
        _name = name;
        _id = id;
        _power = power;
        _mp = mp;
        _type = type;
        _target = target;
        _anime = anime;
    }
    public String getName()                 { return _name; }
    public float getPower()                 { return _power; }
    public int getMp()                      { return _mp;}
    public Type getType()                   { return _type; }
    public TargetStatus getTargetStatus()   { return _target; }

    public void performAnimation(final ImageView target) {

        Glide.with(target.getContext())
                .load(_anime)
                .placeholder(R.drawable.hero_down)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        ((GifDrawable)resource).setLoopCount(1);
                        return false;
                    }
                })
                .into(target);
    }
}

/*　2020/09/18

    スキル追加時の必要手順
    1. Skillクラスを継承する（例：Fire）
    2. SkillIdに新規スキル名のIDを追加
    3. SkillFactoryに新規スキルを追加

    ※ スキルアニメーションは透過したGIFを使用し、最後のフレームは透過状態とすること
    （透過方法：http://www007.upp.so-net.ne.jp/nekoteya/dgi_kouza/gifanime.htm）
 */
class Fire extends Skill {
    public Fire() {
        super("火炎", SkillId.Fire, 10f, 3, Type.S_Attack, TargetStatus.Mind, R.raw.skill_fire);
    }
}

class PowerUp extends Skill {
    public PowerUp() {
        super("パワーアップ", SkillId.PowerUp, 1.3f, 4, Type.S_Support, TargetStatus.Atk, R.raw.skill_powerup);
    }
}

class Heal extends Skill {
    public Heal() {
        super("ヒール", SkillId.Heal, 30f, 5, Type.S_Recovery, TargetStatus.None, R.raw.skill_heal);
    }
}