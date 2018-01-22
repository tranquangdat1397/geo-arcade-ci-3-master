package game.square;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;

import java.util.Random;

public class SquareSqawner extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    public SquareSqawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(20);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Square square = GameObjectManager.instance.recycle(Square.class);
            square.position.set(random.nextInt(400), 0.0f);
            square.velocity.set(0.0f, random.nextInt(6) + 3);
            this.frameCounter.reset();
        }
    }
}
