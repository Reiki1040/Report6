package jp.ac.uryukyu.ie.e235738;

import java.util.Scanner;



public class GameMaster {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("プログラミング2課題6で制作した育成ゲームです。");

        try{ Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        
        System.out.println("名前を入力してください。");
         
        String name = scanner.nextLine();
       
        NurtureChara chara = new NurtureChara(name, 100, 10, 10, 100, 100, 10, 0);

        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        
        System.out.println(chara.getName()+" が産まれました!!");
        try{Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        chara.showStatus();

        
    }
}
