package jp.ac.uryukyu.ie.e235738;

import java.util.Random;


public class Action {
    private int actionID;
    private String actionName;

    public Action(int actionID,String actionName){
        this.actionID = actionID;
        this.actionName = actionName;
    }

    public void timeKeep(int time){ //テキストを時間をおいて表示したいので作成。引数（ミリ秒）の秒数止める。
        try{Thread.sleep(time);
            }catch(InterruptedException e){
        }
    }

    public int getActionID(){
        return actionID;
    }

    public void setActionID(int actionID){
        this.actionID = actionID;
    }

    public String getActionName(){
        return this.actionName;
    }

    public void setActionName(String actionName){
        this.actionName = actionName;
    }


    public double addTired(NurtureChara chara){ //疲労度を0~2追加するメソッド。
        
        Random Rnd = new Random();
        double upTired = Rnd.nextInt(3); //upTired = 0~2の整数。
        double newTired = chara.getTired() + upTired;  //charaのtiredにupTiredを追加。
        chara.setTired(newTired);
        System.out.println(chara.getName() + " の疲労度が "+chara.getTired() + " になった");

        timeKeep(1000);

        return newTired;
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

    public boolean isSuccess(double tired){ //引数に疲労度を入れ、アクションが成功するかを判定するメソッド。
        Random z = new Random();
        double judge = z.nextInt(11);  //judge=０〜１０の整数を生成しする。
            if(judge < tired){ // judge より引数に渡された疲労度tiredのほうが大きかった場合、失敗。
                return false;   //失敗したらfalseを返す。
            }else{
                return true;   //成功したらtrue を返す。
            }
    }

    public void feeding(NurtureChara chara,int upValueOfHP){ //ご飯をあげる処理。(HPが上昇する)
            double newHP = chara.getHP() + upValueOfHP;
            chara.setHP(newHP);
            System.out.println("ご飯をあげた!!!");

            timeKeep(1000);
            
            System.out.println(chara.getName()+"のHPが "+chara.getHP()+" になった!!" );

            timeKeep(1000);
    }

    public void HPUP(NurtureChara chara){ //機嫌が良い時のHP上昇処理。
            double newHP = chara.getHP() + 50;
            chara.setHP(newHP);
            
            System.out.println(chara.getName()+"のHPが "+chara.getHP()+" になった!!" );

            timeKeep(1000);
    }

    public void training(NurtureChara chara,int maxUpValue){ //鍛える処理。筋力、丈夫さ、スタミナの値を上昇させる。

        if(isSuccess(chara.getTired()) == true){

                Random rndPower = new Random();
                double upValueOfPower = rndPower.nextInt(maxUpValue) + 1;//筋力の上昇値を設定。
                double newPower = chara.getPower() + upValueOfPower;
                chara.setPower(newPower);

                Random rndDefence = new Random();
                double upD = rndDefence.nextInt(maxUpValue) + 1; //丈夫さの上昇値を設定。
                double newDefence = chara.getDefence() + upD;
                chara.setDefence(newDefence);

                Random rndStamina = new Random();
                double upStamina = rndStamina.nextInt(maxUpValue) + 3;  //スタミナの上昇値を設定。
                double newStamina = chara.getStamina() + upStamina;
                chara.setStamina(newStamina);

                System.out.println("鍛えた!!");

                timeKeep(1000);

                System.out.println(chara.getName()+"の筋力が "+chara.getPower() + " になった!!");

                timeKeep(1000);

                System.out.println(chara.getName()+"の丈夫さが "+chara.getDefence()+" になった!!");
                
                timeKeep(1000);

                System.out.println(chara.getName() + "のスタミナが "+ chara.getStamina()+" になった!!");
                
                timeKeep(1000);

                addTired(chara);
                
                }else{
                    System.out.println("失敗した...");
                    timeKeep(1000);
            }
    }

    public void UPPowerDefenceStamina(NurtureChara chara){ //機嫌が良い時の筋力、丈夫さ、スタミナ上昇処理。
                Random rndPower = new Random();
                double upValueOfPower = rndPower.nextInt(21) + 5;//筋力の上昇値を設定。
                double newPower = chara.getPower() + upValueOfPower;
                chara.setPower(newPower);

                Random rndDefence = new Random();
                double upD = rndDefence.nextInt(21) + 5; //丈夫さの上昇値を設定。
                double newDefence = chara.getDefence() + upD;
                chara.setDefence(newDefence);

                Random rndStamina = new Random();
                double upStamina = rndStamina.nextInt(26) + 5;  //スタミナの上昇値を設定。
                double newStamina = chara.getStamina() + upStamina;
                chara.setStamina(newStamina);

                System.out.println("鍛えた!!");

                timeKeep(1000);

                System.out.println(chara.getName()+"の筋力が "+chara.getPower() + " になった!!");

                timeKeep(1000);

                System.out.println(chara.getName()+"の丈夫さが "+chara.getDefence()+" になった!!");
                
                timeKeep(1000);

                System.out.println(chara.getName() + "のスタミナが "+ chara.getStamina()+" になった!!");
                
                timeKeep(1000);
    }

    public void study(NurtureChara chara,int maxUpValue){ //勉強させる処理。命中率、回避率の値を上昇させる。
        if(isSuccess(chara.getTired()) == true){
                Random rndAvoid = new Random();
                double upAvoid = rndAvoid.nextInt(maxUpValue) + 8; //回避率の上昇値を設定。
                double newAvoid = chara.getAvoid() + upAvoid;
                chara.setAvoid(newAvoid);

                Random rndHit = new Random();
                double upHit = rndHit.nextInt(maxUpValue) + 8; //命中率の上昇値を設定。
                double newHit = chara.getHit() + upHit;
                chara.setHit(newHit);

                System.out.println("勉強させた!!");

                timeKeep(1000);

                System.out.println(chara.getName()+"の回避率が "+ chara.getAvoid()+" になった!!");

                timeKeep(1000);
                System.out.println(chara.getName()+"の命中率が "+ chara.getHit()+" になった!!");
                
                timeKeep(1000);

                addTired(chara);
            }else{
                System.out.println("失敗した...");
                timeKeep(1000);
            }
    }

    public void UPAvoidHit(NurtureChara chara){ //機嫌が良い時の回避、命中率上昇処理。
                Random rndAvoid = new Random();
                double upAvoid = rndAvoid.nextInt(23) + 8; //回避率の上昇値を設定。
                double newAvoid = chara.getAvoid() + upAvoid;
                chara.setAvoid(newAvoid);

                Random rndHit = new Random();
                double upHit = rndHit.nextInt(23) + 8; //命中率の上昇値を設定。
                double newHit = chara.getHit() + upHit;
                chara.setHit(newHit);

                System.out.println("勉強させた!!");

                timeKeep(1000);

                System.out.println(chara.getName()+"の回避率が "+ chara.getAvoid()+" になった!!");

                timeKeep(1000);
                System.out.println(chara.getName()+"の命中率が "+ chara.getHit()+" になった!!");
                
                timeKeep(1000);
    }

    public void play(NurtureChara chara){ //遊ぶ処理。(忠誠度を上昇させる)
        if(isSuccess(chara.getTired()) == true){
                double newLoyalty = chara.getLoyalty() + 1; //忠誠度を1上昇させる。
                chara.setLoyalty(newLoyalty);
                System.out.println("遊んだ!!");

                timeKeep(1000);

                System.out.println(chara.getName() + "の忠誠度が "+ chara.getLoyalty()+" になった!!");

                timeKeep(1000);

                addTired(chara);
            }else{
                System.out.println("失敗した...");
                timeKeep(1000);
            }
    }

    public void rest(NurtureChara chara){ //休憩させる処理。(疲労度を減少させる。)
        if (chara.getTired() > 0) {
                    Random rnD = new Random();
                    double downTired = rnD.nextInt(4) + 1; //減少する値を設定。
                    double newTired = chara.getTired() - downTired;

                    if(newTired < 0){ //疲労度が0以下になると0に直す。
                        newTired = 0;
                    }
                    chara.setTired(newTired);
                    System.out.println("休憩させた");

                    timeKeep(1000);

                    System.out.println(chara.getName()+"の疲労度が "+chara.getTired()+" になった!!");

                    timeKeep(1000);
                    }else{
                        System.out.println(chara.getName()+"は疲れていないようだ...");

                        timeKeep(1000);
                    }
    }

    public void heal(NurtureChara chara){ //HPとスタミナを回復させる処理。
        double upValueOfHP = 50; //HPの回復する値。
                double newHP = chara.getHP() + upValueOfHP;
                    if(newHP >= chara.getMaxHP()){ //最大HPよりnewHPが大きくならないようにする。
                        newHP = chara.getMaxHP();
                    }

                chara.setHP(newHP);

                double upValueOfStamina = 50; //スタミナの回復する値。
                double newStamina = chara.getStamina() + upValueOfStamina;
                    if(newStamina >= chara.getMaxStamina()){ //スタミナの最大値よりnewStainaが大きくならないようにする。
                        newStamina = chara.getMaxStamina();
                    }
                chara.setStamina(newStamina);
                System.out.println(chara.getName()+" のHPとスタミナが 50 回復した。");
                
                timeKeep(1000);
    }

    public void strike(NurtureChara chara,Boss boss){ //殴る処理。
        if(chara.getStamina()>=20){

              
                if(isHit(chara.getHit(),boss.getAvoid()) == true){
                    Random rn = new Random();
                    double ransuu = rn.nextInt(26) + 85;
                    double D = 100 * chara.getPower() / boss.getDefence() / 5 * ransuu /100;
                    double Damage = Math.floor(D);
                    System.out.println(chara.getName()+" は "+boss.getName()+" を殴った!!");

                    timeKeep(1000);

                    double downStamina = 20;
                    double newStamina = chara.getStamina() - downStamina;
                    chara.setStamina(newStamina);
                    System.out.println(Damage+" ダメージ与えた!!");

                    timeKeep(1000);
                    
                    System.out.println("スタミナが "+downStamina+" 減少した");

                    timeKeep(1000);

                    boss.damaged(Damage);
                 }else{
                    System.out.println("外れた...!");

                    timeKeep(1000);
                 }
              }else{
                System.out.println("スタミナが足りない...");
                timeKeep(1000);
              }
    }

    public void tackle(NurtureChara chara,Boss boss){ //タックルする処理。
        if(chara.getStamina() >= 40){
                 if(isHit(chara.getHit(), boss.getAvoid()) == true){
                    Random rN = new Random();
                    double ranSuu = rN.nextInt(26)  + 85;
                    double D = 180 * chara.getPower() / boss.getDefence() / 5 * ranSuu / 100;
                    double Damage = Math.floor(D);
                    System.out.println(chara.getName()+" は "+boss.getName()+" にタックルした!!");

                    timeKeep(1000);

                    double downValue = 40;
                    double newStamina = chara.getStamina() - downValue;
                    chara.setStamina(newStamina);
                    System.out.println(Damage+" ダメージ与えた!!");

                    timeKeep(1000);

                    System.out.println("スタミナが "+downValue+" 減少した");
                    boss.damaged(Damage);
                    System.out.println(chara.getName()+" は反動により 20 ダメージを受けた");

                    timeKeep(1000);

                    chara.damaged(20);
                   }else{
                     System.out.println("外れた...!");
                     timeKeep(1000);
                }
              }else{
                System.out.println("スタミナが足りない...");
                timeKeep(1000);
              }
    }

    

    public void wakeUp(NurtureChara chara){ //朝に起こして機嫌を決め、機嫌が良ければステータスがランダムに上がる。

        Random RND = new Random();
        double X = RND.nextInt(16); //0~15の値を設定。この値より忠誠度の方が大きい時に機嫌が良い。
        System.out.println(chara.getName()+"を起こした!!");

        timeKeep(1000);

        if(X < chara.getLoyalty()){
             System.out.println("今日は"+chara.getName()+"の機嫌が良い!!");
             timeKeep(1000);
            Random G = new Random();
            int K = G.nextInt(3);
                switch(K){
                    case 0:
                        HPUP(chara);
            timeKeep(1000);
                break;
                    case 1:
                        UPPowerDefenceStamina(chara);
                break;
                    case 2:
                        UPAvoidHit(chara);
                break;

                
                }
        }else{
        }
    }

    

    public void charaAttack(NurtureChara chara,int actID,Boss boss){ //育成キャラの攻撃、攻撃の番号、ボスの順番に引数に渡す。
        switch (actID) {
            case 0: //殴る (威力100,スタミナ消費20)

              strike(chara, boss);

                break;
            case 1: //タックル。威力180。自分もダメージを20負う。スタミナ消費40

              tackle(chara, boss);

                break;
            case 2: //回復する技

                heal(chara); //HPとスタミナを回復させる処理。

                break;
        }
    }

    public void sleep(NurtureChara chara){ //眠らせる処理。疲労度を1だけ減少。

        double sleepTired = chara.getTired() - 1; //育成キャラの現在の疲労度から1ひいたものをsleepTiredとする。
        chara.setTired(sleepTired); //sleepTiredを育成キャラの疲労度に設定。

            if(chara.getTired() <= 0){ //疲労度が0以下になるとき、疲労度を0にする。
                chara.setTired(0);
            }

        System.out.println(chara.getName()+"を眠らせた。");

        timeKeep(1000);

        System.out.println("疲労度が "+chara.getTired()+" になった!!");

        timeKeep(1000);
    }

    
    public void doAction(NurtureChara chara){
        switch(actionID){
            case 0:  //ご飯をあげる処理。(HPをあげる。)

            feeding(chara,10);

            break;

            case 1: //鍛える処理。(筋力、丈夫さ、スタミナをあげる。)
        
            training(chara,3);;
            
            break;
            
            case 2:  //勉強させる処理。(回避率と命中率をあげる。)

            study(chara, 13);
            
            break;

            case 3: // 遊ぶ処理。(忠誠度をあげる。)

            play(chara); //遊ぶ処理。(忠誠度を1上昇させる。)

            break;

            case 4:{ //休憩させる処理(疲労度を減らす)

            rest(chara);
                
            }
            break;
        }
        
    }

}
