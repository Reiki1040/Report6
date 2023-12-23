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


    public double addTired(NurtureChara chara){
        Random Rnd = new Random();
        double upTired = Rnd.nextInt(3);
        double newTired = chara.getTired() + upTired;
        chara.setTired(newTired);
        System.out.println(chara.getName() + " の疲労度が "+chara.getTired() + " になった");
        try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

        return newTired;
    }

    public boolean isSuccess(double tired){ //引数に疲労度を入れ、アクションが成功するかを判定するメソッド。
        Random z = new Random();
        double judge = z.nextInt(11);
        if(judge < tired){
            return false;   //失敗したらfalseを返す。
        }else{
            return true;   //成功したらtrue を返す。
        }
    }

    
    public void doAction(NurtureChara chara){
        switch(actionID){
            case 0:  //ご飯をあげる処理。
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

            case 1: //鍛える処理。
            if(isSuccess(chara.getTired()) == true){

                Random rndPower = new Random();
            double upValue = rndPower.nextInt(2) + 1;
            double newPower = chara.getPower() + upValue;
            chara.setPower(newPower);
            
            
            
            System.out.println("鍛えた!!");

            try{Thread.sleep(1000);
            }catch(InterruptedException e){
            }

            System.out.println(chara.getName()+"の筋力が "+chara.getPower() + " になった!!");
            
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
            
            case 2:  //勉強させる処理。
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
            case 3: //

        }
        
    }


}
