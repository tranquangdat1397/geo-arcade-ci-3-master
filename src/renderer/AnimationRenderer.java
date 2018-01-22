package renderer;

import core.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimationRenderer implements Renderer {

    private boolean isRepeat;
    private List<BufferedImage> list;
    private int index;

    public AnimationRenderer(boolean isRepeat, String... urls) {
        this.isRepeat = isRepeat;
        this.list = new ArrayList<>();
        Arrays.asList(urls).stream().forEach(url -> {
            list.add(Utils.loadImage(url));
        });
        this.index = 0;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        if (this.isRepeat) {
            BufferedImage image = this.list.get(this.index);
            graphics.drawImage(image, (int) position.x - image.getWidth() / 2, (int) position.y - image.getHeight() / 2, null);
            if (this.index == this.list.size() - 1) {
                this.index = 0;
            } else {
                this.index += 1;
            }
        } else {
            if (this.index <= this.list.size() - 1) {
                BufferedImage image = this.list.get(this.index);
                graphics.drawImage(image, (int) position.x - image.getWidth() / 2, (int) position.y - image.getHeight() / 2, null);
                this.index += 1;
            }
        }
    }
}
