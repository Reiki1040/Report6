package jp.ac.uryukyu.ie.e235738;
import java.util.Random;

//育成キャラ、ボスキャラクラスのスーパークラス。
public class LivingThing {
    private String name;
    private double HP;
    private double power;
    private double defence;
    private double avoid;
    private double hit;
    private double stamina;
    private boolean dead;
    

    public LivingThing(String name,double HP,double power,double defence,double avoid,double hit,double stamina){
        this.name = name;  //名前
        this.HP = HP;  //ヒットポイント
        this.power = power;  //筋力
        this.defence = defence;  //丈夫さ
        this.avoid = avoid;  //回避率
        this.hit = hit;  //命中率
        this.stamina = stamina; //スタミナ
        this.dead = false;  //生存状況。trueなら死んでいる。
    }

    

    public void damaged(double damage){  //引数にダメージを入れ、その分だけHPが減少する。死亡したかも判定する。
        this.HP -= damage;
        if(this.getHP() <= 0){
            this.dead = true;
            System.out.println(this.getName()+" は倒れた。");
        }
    }
    //以下、setter,getterメソッド
    public void setName(String name){
        this.name = name;
    }

    public void setHP(double newHP){
        this.HP = newHP;
    }

    public void setPower(double power){
        this.power = power;
    }

    public void setDefence(double defence){
        this.defence = defence;
    }

    public void setAvoid(double avoid){
        this.avoid = avoid;
    }
    
    public void setStamina(double stamina){
        this.stamina = stamina;
    }

    public double getStamina(){
        return this.stamina;
    }


    public void setHit(double hit){ 
        this.hit = hit;  
    }

    public String getName(){
        return this.name;
    }

    public double getHP(){
        return this.HP;
    }

    public double getPower(){
        return this.power;
    }

    public double getDefence(){
        return this.defence;
    }

    public double getAvoid(){
        return this.avoid;
    }

    public double getHit(){
        return this.hit;
    }

    public void setDead(boolean D){
        this.dead = D;
    }

    public boolean isDead(){
        return this.dead;
    }

}

