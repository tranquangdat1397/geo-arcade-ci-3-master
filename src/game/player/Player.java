package game.player;

import core.GameObject;
import input.MouseMotionInput;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import utils.Utils;

public class Player extends GameObject implements PhysicBody {

    private PlayerShoot playerShoot;
    private PlayerHealth playerHealth;
    private BoxCollider boxCollider;
    private ImageRenderer imageRenderer;
    private AnimationRenderer animationRenderer;

    public Player() {
        this.imageRenderer = new ImageRenderer("resources/player/straight.png");
        this.animationRenderer = new AnimationRenderer(false,
                "resources/player/straight.png",
                "resources/player/straight_white.png",
                "resources/player/straight.png",
                "resources/player/straight_white.png"
        );
        this.renderer = this.imageRenderer;
        this.playerShoot = new PlayerShoot();
//        this.playerHealth = new PlayerHealth(5);
        this.boxCollider = new BoxCollider(40, 40);
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position);
        this.boxCollider.position.set(this.position);
        this.playerShoot.run(this);
    }

//    public void getHit() {
//        this.isAlive = this.playerHealth.run();
//        if (this.isAlive) {
//            this.renderer = this.animationRenderer;
//        }
//    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
