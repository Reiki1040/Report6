package jp.ac.uryukyu.ie.e235738;

import java.util.ArrayList;

public class Boss extends LivingThing{

    ArrayList<Action> attacks;

    public Boss(String name,double HP,double power,double defence,double avoid,double hit,double stamina){
        super(name, HP, power, defence, avoid, hit,stamina);
        this.attacks = new ArrayList<>();
    }

    public void addAttack(Attack attack){
        this.attacks.add(attack);
    }

    public void showStatus(){
        System.out.println(this.getName()+"のステータス");
        System.out.println("HP "+this.getHP()+"、筋力 "+this.getPower()+"、丈夫さ "+this.getDefence()+"、回避率 "+this.getAvoid()+"、命中率 "+this.getHit());
    }
    

    public void attack(int select,NurtureChara chara,Boss boss){
        switch (select) {  
            case 0://体当たり。威力100

            double D = 100 * boss.getPower() / chara.getDefence() / 5;
            double Damage = Math.floor(D);
            System.out.println(boss.getName()+ " の体当たり!!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            System.out.println(chara.getName()+" に "+Damage+" のダメージ!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            chara.damaged(Damage);

                break;
            case 1://ホウデン。威力200。自称ダメージ20。

            double selfDamage = 20;
            double F = 200 * boss.getPower() / chara.getDefence() / 5;
            double ff = Math.floor(F);
            System.out.println(boss.getName()+ " のホウデン!!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            System.out.println(chara.getName()+" に "+ff+" のダメージ!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            chara.damaged(ff);

            System.out.println(boss.getName()+" は自傷ダメージ "+selfDamage+" を受けた");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            boss.damaged(selfDamage);
                break;
            case 2://ジューデン。HP回復メソッド。
            System.out.println(boss.getName() + " のジューデン!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            double upValueOfHP = 50;
            double newHP = boss.getHP() + upValueOfHP;
            boss.setHP(newHP);
            System.out.println(boss.getName()+" のHPが "+upValueOfHP+" 回復した");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
                break;
            case 3://かげぶんしん。回避率UP。
            System.out.println(boss.getName() + " のかげぶんしん!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            double upValueOfAvoid = 20;
            double newAvoid = boss.getAvoid() + upValueOfAvoid;
            boss.setAvoid(newAvoid);
            System.out.println(boss.getName() + " の回避率が "+upValueOfAvoid+" 上昇した");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
                break;
            case 4://なまける。(何もしない)
            System.out.println(boss.getName() + " は怠けている");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
                break;
        }
    }


}
