package jp.ac.uryukyu.ie.e235738;
import java.util.ArrayList;

public class NurtureChara extends LivingThing{
    private double loyalty;
    private double tired;
    

    NurtureChara(String name,double HP,double power,double defence,double avoid,double hit,double loyalty,double tired){
        super(name,HP,power,defence,avoid,hit);
        this.loyalty = loyalty;
        this.tired = tired;
    }

    public void greetBadCondition(){
        System.out.println(this.getName()+"  「イライラする...」"); //起こされた時の台詞
    }

    public void greetGoodCondition(){
        System.out.println(this.getName()+"  「おはようございます!!」");  //起こされた時の台詞
    }

    
}
