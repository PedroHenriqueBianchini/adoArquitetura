package View;

import Model.nucleo.Nucleo;

public class GameView {

    public void showStatus(Nucleo gm) {
        System.out.println("=== Game Status ===");
        System.out.println("Players:");
        gm.getPlayers().forEach(p -> System.out.println(" - " + p));

        System.out.println("Enemies:");
        gm.getEnemies().forEach(e -> System.out.println(" - " + e));

        System.out.println("===================\n");
    }

    public void showAttack(String msg) {
        System.out.println(msg);
    }
}
