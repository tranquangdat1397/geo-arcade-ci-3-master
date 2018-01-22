package game.player;

import core.GameObjectManager;

import java.util.Vector;

public class PlayerHealth {
    private int health;
    Vector<PlayerHeart> playerHearts = new Vector<>();

    public PlayerHealth(int health) {
        this.health = health;

        for (int i=0; i<health; i++) {
            PlayerHeart playerHeart = GameObjectManager.instance.recycle(PlayerHeart.class);
            playerHeart.position.set((40*i)+10, 540);
            this.playerHearts.add(playerHeart);
        }
    }

    public boolean run() {
        if (this.health == 0) {
            return false;
        } else {
            this.health -= 1;
            playerHearts.elementAt(health).isAlive = false;
            return true;
        }
    }
}
