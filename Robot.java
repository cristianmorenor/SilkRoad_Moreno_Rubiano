import java.awt.Point;

public class Robot {
    private String color;
    private Point position;
    private int actualTenges;

    public Robot(int location, int initialTenges) {
        this.position = new Point(location, 0);
        this.actualTenges = initialTenges;

    }
}
