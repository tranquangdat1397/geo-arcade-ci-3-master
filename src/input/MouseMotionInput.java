package input;

import core.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionInput implements MouseMotionListener {

    public static MouseMotionInput instance = new MouseMotionInput();

    public Vector2D position;

    private MouseMotionInput() {
        this.position = new Vector2D();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.set(e.getX(), e.getY());
        if(this.position.x>360) {
            this.position.x=360;
        }
        if(this.position.x<20){
            this.position.x=20;
        }
        if(this.position.y > 540){
            this.position.y = 540;
        }
        if (this.position.y < 0){
            this.position.y = 0;
        }
    }
}
