package game.enemy;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;
import utils.Utils;

public class Enemy extends GameObject {

    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyShoot();
        this.boxCollider = new BoxCollider(40, 40);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.enemyShoot.run(this);
        if (this.position.y >= 600.0f) {
            this.isAlive = false;
        }
    }

    public void getHit() {
        this.isAlive = false;
    }
}
