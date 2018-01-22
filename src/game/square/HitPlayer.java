package game.square;

import core.GameObjectManager;
import game.player.Player;

public class HitPlayer {
    public void run(Square square) {
        Player player = GameObjectManager.instance.checkCollider(square.getBoxCollider(), Player.class);
        if (player != null) {
            System.out.println("hit");
//            player.getHit();
            square.getHit();
        }
    }
}
