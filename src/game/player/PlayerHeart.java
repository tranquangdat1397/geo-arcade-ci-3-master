package game.player;

import core.GameObject;
import renderer.ImageRenderer;

public class PlayerHeart extends GameObject{

    public PlayerHeart() {
        this.renderer = new ImageRenderer("resources/ui/heart.png");
    }
}
