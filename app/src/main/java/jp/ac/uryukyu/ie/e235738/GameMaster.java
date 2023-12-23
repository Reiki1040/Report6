package jp.ac.uryukyu.ie.e235738;

import java.util.Scanner;

public class GameMaster {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("プログラミング2課題6で制作した育成ゲームです。");

        try{ Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        
        System.out.println("育成するキャラクターの名前を入力してください。");
         
        String name = scanner.nextLine();

       //育成するキャラを生成し、アクションも生成。
        NurtureChara chara = new NurtureChara(name, 100, 10, 10, 100, 100, 10, 0);
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

        for (int day = 1; day < 11;day ++){
            System.out.println(day+" 日目、朝");
            try{Thread.sleep(600);
        }catch(InterruptedException e){
        }

        try{ Thread.sleep(1500);
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

        }

    }
}
