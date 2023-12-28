package jp.ac.uryukyu.ie.e235738;

import java.util.ArrayList;
import java.util.Random;

public class Boss extends LivingThing{

    public Boss(String name,double HP,double power,double defence,double avoid,double hit,double stamina){
        super(name, HP, power, defence, avoid, hit,stamina);
        this.attacks = new ArrayList<>();
        this.setMaxHP(HP);
    }

    public void timekeeper(int time){
        try{Thread.sleep(time);
            }catch(InterruptedException e){
            }
    }

    public void addAttack(Action attack){
        this.attacks.add(attack);
    }

    public boolean isHit(double attakCharaHit,double targetsVoid){ //第一引数に攻撃するキャラの命中率、第二引数に攻撃されたキャラの回避率を渡すと、攻撃がヒットしたかどうかを判定してくれるメソッド。
        Random A = new Random();
        int isHiT = A.nextInt(256);
        double qHIT = 255 * attakCharaHit / targetsVoid;
        if(isHiT < qHIT){
            return true;  //当たればtrueを返す。
        }else{
            return false;
        }

    }

    public void showStatus(){
        System.out.println(this.getName()+"のステータス");
        System.out.println("HP "+this.getHP()+"、筋力 "+this.getPower()+"、丈夫さ "+this.getDefence()+"、回避率 "+this.getAvoid()+"、命中率 "+this.getHit());
    }

    public double getMaxHP(){
        return this.maxHP;
    }

    public void setMaxHP(double newMaxHP){
        this.maxHP = newMaxHP;
    }
    

    public void attack(int select,NurtureChara chara,Boss boss){
        switch (select) {  
            case 0://体当たり。威力100
                    if(isHit(boss.getHit(),chara.getAvoid()) == true){
                        double D = 100 * boss.getPower() / chara.getDefence() / 5;
                    double Damage = Math.floor(D);
                    System.out.println(boss.getName()+ " の体当たり!!!");
                    timekeeper(1000);
                    System.out.println(chara.getName()+" に "+Damage+" のダメージ!!");
                    timekeeper(1000);
                    chara.damaged(Damage);
                    }else{
                        System.out.println(chara.getName() + "は避けた!!");
                    }
                break;
            case 1://ホウデン。威力200。自称ダメージ20。
                    if(isHit(boss.getHit(),chara.getAvoid()) == true){
                        double selfDamage = 20;
                    double F = 200 * boss.getPower() / chara.getDefence() / 5;
                    double ff = Math.floor(F);
                    System.out.println(boss.getName()+ " のホウデン!!!");
                    timekeeper(1000);
                    System.out.println(chara.getName()+" に "+ff+" のダメージ!!");
                    timekeeper(1000);
                    chara.damaged(ff);
                    System.out.println(boss.getName()+" は自傷ダメージ "+selfDamage+" を受けた");
                    timekeeper(1000);
                    boss.damaged(selfDamage);
                    }else{
                        System.out.println(chara.getName() + "は避けた!!");
                    }
            
                break;
            case 2://ジューデン。HP回復メソッド。
                    System.out.println(boss.getName() + " のジューデン!!");
                    timekeeper(1000);
                    double upValueOfHP = 50;
                    double newHP = boss.getHP() + upValueOfHP;
                        if(newHP >= boss.getMaxHP()){ //最大HPより回復できないようにする。
                            newHP = boss.getMaxHP();
                        }
                    boss.setHP(newHP);
                    System.out.println(boss.getName()+" のHPが "+upValueOfHP+" 回復した");
                    timekeeper(1000);
                        break;
                    case 3://かげぶんしん。回避率UP。
                    System.out.println(boss.getName() + " のかげぶんしん!!");
                    timekeeper(1000);
                    double upValueOfAvoid = 20;  //upValueOfAvoid = 回避率の上昇する値。
                    double newAvoid = boss.getAvoid() + upValueOfAvoid;
                    boss.setAvoid(newAvoid);
                    System.out.println(boss.getName() + " の回避率が "+upValueOfAvoid+" 上昇した");
                    timekeeper(1000);
                break;
            case 4://なまける。(何もしない)
                    System.out.println(boss.getName() + " は怠けている");
                    timekeeper(1000);
                        break;
        }
    }


}
