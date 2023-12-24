package jp.ac.uryukyu.ie.e235738;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameMaster {

    public static void main(String[] args) {
        
        ArrayList<LivingThing> order = new ArrayList<>(); //戦闘時の順番を決めるためのリスト。
        Scanner scanner = new Scanner(System.in);

        System.out.println("プログラミング2課題6で制作した育成ゲームです。");

        try{ Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        
        System.out.println("育成するキャラクターの名前を入力してください。");
         
        String name = scanner.nextLine();

       //育成するキャラを生成し、アクションも生成。
        NurtureChara chara = new NurtureChara(name, 100, 10, 10, 100, 100,100,0, 0);
        Action  feeding = new Action(0, "ご飯をあげる");
        Action training = new Action(1,"鍛える");
        Action study = new Action(2, "勉強させる");
        Action play = new Action(3,"遊ぶ");
        Action rest = new Action(4, "休憩");

        //生成したアクションを選択肢に追加。
        chara.addAction(feeding);
        chara.addAction(training);
        chara.addAction(study);
        chara.addAction(play);
        chara.addAction(rest);

        //攻撃を生成,攻撃の選択肢に追加
        Attack punch = new Attack(0, "殴る");
        Attack tackle = new Attack(1, "タックル");
        Attack resthp = new Attack(2, "休憩");
        chara.addAttack(punch);
        chara.addAttack(tackle);
        chara.addAttack(resthp);


        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        
        System.out.println(chara.getName()+" が産まれました!!");

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }

        chara.showStatus();     //この時点でキャラクターの作成が完了。

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }

        System.out.println("このゲームのルールを説明します。");

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }

        System.out.println("朝、昼、夜にプレイヤーは選択肢から行動を１つ選び、選ばれた行動によってステータスが変動します。");

        try{Thread.sleep(2000);
        }catch(InterruptedException e){
        }

        System.out.println("1日に3回行動を行い、10日過ごした後にボスとの戦闘が始まります。");

        try{Thread.sleep(2000);
        }catch(InterruptedException e){
        }

        System.out.println("ステータスを調整していき、11日目にボスを打ち倒すことが目的です。");

        try{Thread.sleep(2000);
        }catch(InterruptedException e){
        }

        System.out.println("ゲームスタート!!!");

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }           
/* 
        for (int day = 1; day < 11;day ++){
            System.out.println("---- "+day+ " 日目---- 朝");
            try{ Thread.sleep(1000);
            }catch(InterruptedException e){
            }

            chara.actions.get(0).wakeUp(chara);
            chara.showStatus();
            
        try{ Thread.sleep(1000);
        }catch(InterruptedException e){
        }

        System.out.println("行いたい行動の番号を指定してください。(半角入力)"); 
        try{ Thread.sleep(500);
        }catch(InterruptedException e){
        }
        chara.showActions();

        Scanner actionScanner = new Scanner(System.in);
        String actSelect = actionScanner.nextLine();
        int actSelecter = Integer.parseInt(actSelect);

        chara.actions.get(actSelecter).doAction(chara);

        //昼のアクション。
        System.out.println("---- "+day + "日目---- 昼");
        System.out.println("行いたい行動の番号を指定してください。(半角入力)"); 
        try{ Thread.sleep(500);
        }catch(InterruptedException e){
        }
        chara.showStatus();
        chara.showActions();

        Scanner actionScanner2 = new Scanner(System.in);
        String actSelect2 = actionScanner2.nextLine();
        int actSelecter2 = Integer.parseInt(actSelect2);

        chara.actions.get(actSelecter2).doAction(chara);

        //夜のアクション。
        System.out.println("---- " + day + "日目---- 夜");
        System.out.println("行いたい行動の番号を指定してください。(半角入力)"); 
        try{ Thread.sleep(500);
        }catch(InterruptedException e){
        }
        chara.showStatus();
        chara.showActions();

        Scanner actionScanner3 = new Scanner(System.in);
        String actSelect3 = actionScanner3.nextLine();
        int actSelecter3 = Integer.parseInt(actSelect3);

        chara.actions.get(actSelecter3).doAction(chara);

        chara.actions.get(0).sleep(chara);

        }

        //戦闘パート
        System.out.println("育成お疲れ様でした。");
        try{ Thread.sleep(1000);
            }catch(InterruptedException e){
        }       */


        System.out.println("-------11日目-------");

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        } 

        Boss boss = new Boss("デンチウ", 300, 100, 100, 150, 150, 5000);

        order.add(chara);
        order.add(boss);

        System.out.println(boss.getName() + " が現れた!!!");

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        } 
     
        System.out.println("----戦闘開始----");

        while(chara.isDead() != true && boss.isDead() != true){
            chara.showStatus();
            boss.showStatus();
            
            System.out.println("行いたい行動の番号を指定してください。(半角入力)");
            try{ Thread.sleep(500);
            }catch(InterruptedException e){
            }
            chara.showAttacks();
            
            Scanner attackScanner = new Scanner(System.in);
            String attackSelect = attackScanner.nextLine();
            int attackSelecter = Integer.parseInt(attackSelect);

            chara.attacks.get(attackSelecter).charaAttack(chara,attackSelecter,boss);
            if(boss.isDead()==true){
                System.out.println("クリア!!!");
            }else{
                Random RANDOM = new Random();
            int bossAttack = RANDOM.nextInt(5);
            boss.attack(bossAttack,chara,boss);
                if(chara.isDead()==true){
                    System.out.println("ゲームオーバー");
                }
            }

            
            
        }



        

    }
}
