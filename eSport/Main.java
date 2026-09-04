package org.eSport;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RankingSystem rk = new RankingSystem();

        Player p1 =new Player(1, "Вася", 1500);
        Player p2 =new Player(2, "петя", 1600);
        Player p3 =new Player(3, "Эльвира", 1220);
        Player p4 =new Player(4, "skdj", 22220);
        Player p5 =new Player(5, "Катя", 1700);
        Player p6 =new Player(6, "Витя", 2000);
        Player p7 =new Player(7, "Илья", 1900);
        Player p8 =new Player(8, "Юра", 1800);

        rk.addPlayer(p1);
        rk.addPlayer(p2);
        rk.addPlayer(p5);
        rk.addPlayer(p6);
        rk.addPlayer(p7);
        rk.addPlayer(p8);
        rk.showTopPlayers(4);

        try {
            rk.updatePlayerRating(4, 1000);
        } catch(UserNotRegisteredException e){
            System.out.println(e.getMessage());
        }

        try {
            rk.updatePlayerRating(3, 1000);
        } catch(UserNotRegisteredException e){
            System.out.println(e.getMessage());
        }

        try {
            rk.updatePlayerRating(5, 1810);
        } catch(UserNotRegisteredException e){
            System.out.println(e.getMessage());
        }

        rk.showTopPlayers(4);

        try {
            rk.getPlayerRank(4);
        } catch(UserNotRegisteredException e){
            System.out.println(e.getMessage());
        }

        try {
            rk.getPlayerRank(7);
        } catch(UserNotRegisteredException e){
            System.out.println(e.getMessage());
        }


    }
}