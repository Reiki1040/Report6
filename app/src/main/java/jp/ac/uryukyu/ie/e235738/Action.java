package jp.ac.uryukyu.ie.e235738;

import java.util.Random;


public class Action {
    private int actionID;
    private String actionName;

    public Action(int actionID,String actionName){
        this.actionID = actionID;
        this.actionName = actionName;
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

        try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

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

    public void wakeUp(NurtureChara chara){ //朝に起こして機嫌を決め、機嫌が良ければステータスがランダムに上がる。
        Random RND = new Random();
        double X = RND.nextInt(16);
        System.out.println(chara.getName()+"を起こした!!");

        try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }

        if(X < chara.getLoyalty()){
             System.out.println("今日は"+chara.getName()+"の機嫌が良い!!");
             try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
            Random G = new Random();
            int K = G.nextInt(3);
                switch(K){
                    case 0:

                    double newHP = chara.getHP() + 50;
                chara.setHP(newHP);

                System.out.println(chara.getName()+"のHPが "+chara.getHP()+" になった!!" );

                try{Thread.sleep(1000);
                }catch(InterruptedException e){
                }
                break;

                case 1:

                Random rndPower = new Random();
                double upValue = rndPower.nextInt(5) + 4;
                double newPower = chara.getPower() + upValue;
                chara.setPower(newPower);

                Random rndDefence = new Random();
                double upD = rndDefence.nextInt(5) + 4;
                double newDefence = chara.getDefence() + upD;
                chara.setDefence(newDefence);

                System.out.println(chara.getName()+"の筋力が "+chara.getPower() + " になった!!");
                
                try{Thread.sleep(1000);
                }catch(InterruptedException e){
                }

                System.out.println(chara.getName()+"の丈夫さが "+chara.getDefence()+" になった!!");
                
                try{Thread.sleep(1000);
                }catch(InterruptedException e){
                }
                break;

                case 2:

                Random rndAvoid = new Random();
                double upAvoid = rndAvoid.nextInt(21) + 10;
                double newAvoid = chara.getAvoid() + upAvoid;
                chara.setAvoid(newAvoid);

                Random rndHit = new Random();
                double upHit = rndHit.nextInt(21) + 10;
                double newHit = chara.getHit() + upHit;
                chara.setHit(newHit);
                System.out.println(chara.getName()+"の回避率が "+ chara.getAvoid()+" になった!!");
                try{Thread.sleep(1000);
                }catch(InterruptedException e){
                }
                System.out.println(chara.getName()+"の命中率が "+ chara.getHit()+" になった!!");
                try{Thread.sleep(1000);
                }catch(InterruptedException e){
                }

                break;

                
                }
        }else{
        }
    }

    public void charaAttack(NurtureChara chara,int ID,Boss boss){ //育成キャラの攻撃、攻撃の番号、ボスの順番に引数に渡す。
        switch (ID) {
            case 0: //殴る (威力100,スタミナ消費20)
              if(chara.getStamina()>=20){

              
                if(isHit(chara.getHit(),boss.getAvoid()) == true){
                    Random rn = new Random();
                    double ransuu = rn.nextInt(26) + 85;
                    double D = 100 * chara.getPower() / boss.getDefence() / 5 * ransuu /100;
                    double Damage = Math.floor(D);
                    System.out.println(chara.getName()+" は "+boss.getName()+" を殴った!!");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    double downStamina = 20;
                    double newStamina = chara.getStamina() - downStamina;
                    chara.setStamina(newStamina);
                    System.out.println(Damage+" ダメージ与えた!!");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    
                    System.out.println("スタミナが "+downStamina+" 減少した");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    boss.damaged(Damage);
                 }else{
                    System.out.println("外れた...!");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
            
                 }
              }else{
                System.out.println("スタミナが足りない...");
                try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
              }
                break;
        
            case 1: //タックル。威力180。自分もダメージを20負う。
              if(chara.getStamina() >= 40){
                 if(isHit(chara.getHit(), boss.getAvoid()) == true){
                    Random rN = new Random();
                    double ranSuu = rN.nextInt(26)  + 85;
                    double D = 180 * chara.getPower() / boss.getDefence() / 5 * ranSuu / 100;
                    double Damage = Math.floor(D);
                    System.out.println(chara.getName()+" は "+boss.getName()+" にタックルした!!");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    double downValue = 40;
                    double newStamina = chara.getStamina() - downValue;
                    chara.setStamina(newStamina);
                    System.out.println(Damage+" ダメージ与えた!!");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    System.out.println("スタミナが "+downValue+" 減少した");
                    boss.damaged(Damage);
                    System.out.println(chara.getName()+" は反動により 20 ダメージを受けた");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                    chara.damaged(20);
                   }else{
                     System.out.println("外れた...!");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                }
              }else{
                System.out.println("スタミナが足りない...");
                try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
              }
            
                
                break;
            case 2: //回復する技
                double upValueOfHP = 50;
                double newHP = chara.getHP() + upValueOfHP;
                if(newHP >= chara.getMaxHP()){
                    newHP = chara.getMaxHP();
                }
                chara.setHP(newHP);
                double upValueOfStamina = 50;
                double newStamina = chara.getStamina() + upValueOfStamina;
                if(newStamina >= chara.getMaxStamina()){
                    newStamina = chara.getMaxStamina();
                }
                chara.setStamina(newStamina);
                System.out.println(chara.getName()+" のHPとスタミナが 50 回復した。");
                try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                break;
        }
    }

    public void sleep(NurtureChara chara){ //眠らせる処理。疲労度を1だけ減少。
        double sleepTired = chara.getTired() - 1;
        chara.setTired(sleepTired);
        if(chara.getTired() <= 0){
            chara.setTired(0);
        }

        System.out.println(chara.getName()+"を眠らせた。");

        try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }

        System.out.println("疲労度が "+chara.getTired()+" になった!!");

        try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
    }

    
    public void doAction(NurtureChara chara){
        switch(actionID){
            case 0:  //ご飯をあげる処理。(HPをあげる。)
            double newHP = chara.getHP() + 10;
            chara.setHP(newHP);
            System.out.println("ご飯をあげた!!!");

            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

            System.out.println(chara.getName()+"のHPが "+chara.getHP()+" になった!!" );

            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            break;

            case 1: //鍛える処理。(筋力、丈夫さ、スタミナをあげる。)
            if(isSuccess(chara.getTired()) == true){

                Random rndPower = new Random();
             double upValue = rndPower.nextInt(2) + 1;
             double newPower = chara.getPower() + upValue;
             chara.setPower(newPower);

             Random rndDefence = new Random();
             double upD = rndDefence.nextInt(2) + 1;
             double newDefence = chara.getDefence() + upD;
             chara.setDefence(newDefence);

             Random rndStamina = new Random();
             double upStamina = rndStamina.nextInt(6);
             double newStamina = chara.getStamina() + upStamina;
             chara.setStamina(newStamina);

            
            
            
            System.out.println("鍛えた!!");

            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

            System.out.println(chara.getName()+"の筋力が "+chara.getPower() + " になった!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            System.out.println(chara.getName()+"の丈夫さが "+chara.getDefence()+" になった!!");
            
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

            System.out.println(chara.getName() + "のスタミナが "+ chara.getStamina()+" になった!!");
            
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            addTired(chara);

            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            
            }else{
                System.out.println("失敗した...");
                try{Thread.sleep(1000);
             }catch(InterruptedException e){
            }
            }
            break;
            
            case 2:  //勉強させる処理。(回避率と命中率をあげる。)
            if(isSuccess(chara.getTired()) == true){
                Random rndAvoid = new Random();
            double upAvoid = rndAvoid.nextInt(12) + 8;
            double newAvoid = chara.getAvoid() + upAvoid;
            chara.setAvoid(newAvoid);

            Random rndHit = new Random();
            double upHit = rndHit.nextInt(12) + 8;
            double newHit = chara.getHit() + upHit;
            chara.setHit(newHit);
            System.out.println("勉強させた!!");

            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

            System.out.println(chara.getName()+"の回避率が "+ chara.getAvoid()+" になった!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            System.out.println(chara.getName()+"の命中率が "+ chara.getHit()+" になった!!");
            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            addTired(chara);
            }else{
                System.out.println("失敗した...");
                try{Thread.sleep(1000);
             }catch(InterruptedException e){
            }
            }
            
            break;
            case 3: // 遊ぶ処理。(忠誠度をあげる。)
            if(isSuccess(chara.getTired()) == true){
                double newLoyalty = chara.getLoyalty() + 1;
                chara.setLoyalty(newLoyalty);
                System.out.println("遊んだ!!");
                try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
             System.out.println(chara.getName() + "の忠誠度が "+ chara.getLoyalty()+" になった!!");
             try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
             addTired(chara);

            }else{
                System.out.println("失敗した...");
                try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
            }
            break;

            case 4:{ //休憩させる処理(疲労度を減らす)
                if (chara.getTired() > 0) {
                    Random rnD = new Random();
                double downTired = rnD.nextInt(3) + 1;
                double newTired = chara.getTired() - downTired;
                if(newTired < 0){
                    newTired = 0;
                }
                chara.setTired(newTired);
                System.out.println("休憩させた");
                try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                System.out.println(chara.getName()+"の疲労度が "+chara.getTired()+" になった!!");
                try{Thread.sleep(1000);
             }catch(InterruptedException e){
             }
                }else{
                    System.out.println(chara.getName()+"は疲れていないようだ...");
                    try{Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                }
                
            }
            break;
        }
        
    }


}
