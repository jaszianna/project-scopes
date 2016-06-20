package projectscopes;

import javafx.scene.paint.Color;

/**
 *
 * @author Tomasz Najbar
 */
public class Player {
    // Id.
    private int id = 0;

    // Size.
    private int size = 0;

    // Speed.
    private double speed = 0.0;

    // Color.
    private Color color;

    // Position.
    private double x = 0.0;
    private double y = 0.0;

    // Direction.
    private double direction = 0.0;
    private double factor = 0.0;
    private double vectorX = 0.0;
    private double vectorY = 0.0;

    /**
     * Creates Player instance.
     *
     * @param id Player identifier.
     * @param x Initial position on X axis.
     * @param y Initial position on Y axis.
     * @param factor Defines direction.
     * @param size Initial size.
     * @param speed Initial speed.
     */
    public Player(final int id, final double x, final double y, final double factor, final int size, final double speed, final Color color) {
        this.id = id;

        this.x = x;
        this.y = y;

        // Calculate initial direction.
        this.factor = factor;
        vectorX = Math.sin(factor);
        vectorY = Math.cos(factor);

        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public final int getId() { return id; }

    public final double getX() {return x; }

    public final double getY() {
        return y;
    }

    public final int getSize() { return size; }

    public final Color getColor() {
        return color;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public final double getDirection() { return factor; }

    /**
     * Calculates new position.
     */
    public void move() {
        if (direction <= -0.000001 || direction >= -0.000001) {
            factor += direction;
            vectorX = Math.sin(factor);
            vectorY = Math.cos(factor);
        }

        x += vectorX * speed;
        y += vectorY * speed;
    }
}
