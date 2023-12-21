package jp.ac.uryukyu.ie.e235738;


public class NurtureChara extends LivingThing{
    private double loyalty;
    private double tired;
    

    NurtureChara(String name,double HP,double power,double defence,double avoid,double hit,double loyalty,double tired){
        super(name,HP,power,defence,avoid,hit);
        this.loyalty = loyalty; //忠誠度
        this.tired = tired;  //疲労度
    }

    public void setLoyalty(double loyalty){
        this.loyalty = loyalty;
    }

    public void setTired(double tired){
        this.tired = tired;
    }

    public double getLoyalty(){
        return this.loyalty;
    }

    public double getTired(){
        return this.tired;
    }

    public void greetBadCondition(){
        System.out.println(this.getName()+"  「イライラする...」"); //起こされた時の台詞
    }

    public void greetGoodCondition(){
        System.out.println(this.getName()+"  「おはようございます!!」");  //起こされた時の台詞
    }

    public void showStatus(){  //ステータスを表示するメソッド。
        System.out.println(this.getName()+"のステータス");
        System.out.println("HP "+this.getHP()+"、筋力 "+this.getPower()+"、丈夫さ "+this.getDefence()+"、回避率 "+this.getAvoid()+"、命中率 "+this.getHit()+"、忠誠度 "+this.getLoyalty()+"、疲労度 "+this.getTired());
    }

}
