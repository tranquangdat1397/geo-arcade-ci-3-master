package game.player;

public class PlayerHealth {
    private int health;

    public PlayerHealth(int health) {
        this.health = health;
    }

    public boolean run() {
        if (this.health == 0) {
            return false;
        } else {
            this.health -= 1;
            return true;
        }
    }
}
