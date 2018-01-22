package game.player;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import game.player.bullet.BulletPlayer;

public class PlayerShoot {
    private FrameCounter frameCounter = new FrameCounter(20);

    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(0.0f, 5.0f);
            this.frameCounter.reset();
        }
    }
}
