import core.GameObjectManager;
import core.Vector2D;
import game.background.Background;
import game.circlesquare.CircleSquare;
import game.enemy.EnemySqawner;
import game.player.Player;
import game.square.MatrixSquare;
import game.square.SquareSqawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;


    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        this.setupSquare();
        this.setupEnemy();
//        GameObject.add(new CircleSquare());
//        GameObject.add(new MatrixSquare());
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupBackground() {
        GameObjectManager.instance.recycle(Background.class);
    }

    private void setupPlayer() {
        GameObjectManager.instance.recycle(Player.class);
    }

    private void setupSquare() {
        GameObjectManager.instance.recycle(SquareSqawner.class);
    }

    private void setupEnemy() {
        GameObjectManager.instance.recycle(EnemySqawner.class);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
    }
}
