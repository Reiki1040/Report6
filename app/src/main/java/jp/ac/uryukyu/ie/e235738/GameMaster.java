package jp.ac.uryukyu.ie.e235738;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameMaster { 

     ArrayList<String> time; //朝昼夜をいれる。

    public void timeKeep(int time){ //テキストを時間をおいて表示したいので作成。引数（ミリ秒）の秒数止める。
        try{Thread.sleep(time);
            }catch(InterruptedException e){
        }
    }

    public void battle(NurtureChara chara,Boss boss){  //第一引数のキャラと第二引数のキャラを戦わせるメソッド。
        while(chara.isDead() != true && boss.isDead() != true){
            chara.showStatus();
            boss.showStatus();

            System.out.println("行いたい行動の番号を指定してください。");
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

    public void nurturing(NurtureChara chara,GameMaster Game){ 
        int i = 0;
        int dayLimit = 11;
        for (int day = 1; day < dayLimit;day ++){  //第一引数のキャラを育成するメソッド。
                for(i = 0; i < 3; i++){
                    System.out.println("---- "+day+ " 日目---- "+ time.get(i));
                    Game.timeKeep(700);

                    if(time.get(i) == "朝"){chara.actions.get(0).wakeUp(chara); //朝だったら起こす。
                    }

                    chara.showStatus();
                    
                    Game.timeKeep(800);

                    System.out.println("行いたい行動の番号を指定してください。"); 
                    Game.timeKeep(1000);
                    chara.showActions();

                    Scanner actionScanner = new Scanner(System.in);
                    String actSelect = actionScanner.nextLine();
                    
                    try{int actSelecter = Integer.parseInt(actSelect);
                        chara.actions.get(actSelecter).doAction(chara);
                    }catch(NumberFormatException e){
                        System.out.println("数字を入力してください。");
                    }

                        if(time.get(i) == "夜"){
                            chara.actions.get(0).sleep(chara); //夜だったら眠らせる。
                        }
                    }
                
        }
    }

    GameMaster(ArrayList time){
        this.time = time;
    }

    public static void main(String[] args) {

        ArrayList<String> time = new ArrayList<>();
        time.add("朝");
        time.add("昼");
        time.add("夜");
        GameMaster Game = new GameMaster(time);

        ArrayList<LivingThing> order = new ArrayList<>(); //戦闘時の順番を決めるためのリスト。
        Scanner scanner = new Scanner(System.in);

        System.out.println("プログラミング2課題6で制作した育成ゲームです。");
        
        Game.timeKeep(1000);
    
        System.out.println("育成するキャラクターの名前を入力してください。");
         
        String name = scanner.nextLine();

       //育成するキャラを生成し、アクションも生成。
        NurtureChara chara = new NurtureChara(name,100,10,10,100,100,100,0,0);
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
        Action punch = new Action(0, "殴る");
        Action tackle = new Action(1, "タックル");
        Action resthp = new Action(2, "休憩");
        chara.addAttack(punch);
        chara.addAttack(tackle);
        chara.addAttack(resthp);


        Game.timeKeep(1000);
        
        System.out.println(chara.getName()+" が産まれました!!");  
        
        Game.timeKeep(1000);

        chara.showStatus();     //この時点でキャラクターの作成が完了。

        Game.timeKeep(1000);

        System.out.println("このゲームのルールを説明します。");

        Game.timeKeep(1000);

        System.out.println("朝、昼、夜にプレイヤーは選択肢から行動を１つ選び、選ばれた行動によってステータスが変動します。");

        Game.timeKeep(2000);

        System.out.println("1日に3回行動を行い、10日過ごした後にボスとの戦闘が始まります。");

        Game.timeKeep(2000);

        System.out.println("ステータスを調整していき、11日目にボスを打ち倒すことが目的です。");

        Game.timeKeep(2000);

        System.out.println("ゲームスタート!!!");

        Game.timeKeep(1000);   

        Game.nurturing(chara, Game);   //育成 

        System.out.println("-------11日目-------");

        Game.timeKeep(1000);

        Boss boss = new Boss("デンチウ", 220, 50, 50, 140, 150, 5000); //ボス生成。
        boss.setMaxHP(220);
        order.add(chara);
        order.add(boss);

        System.out.println(boss.getName() + " が現れた!!!");

        Game.timeKeep(1000);
     
        System.out.println("----戦闘開始----");

        Game.timeKeep(1500);

        Game.battle(chara, boss);  //戦闘

        }
        } 

    

