
import java.awt.Point;

public class Store {
    private int initialTenges;
    private int actualTenges;
    private Point position;
    private String color;
    private boolean isEmpty;

    public Store(int location, int initialTenges){
        this.location = new Point(location, 0);
        this.initialTenges = initialTenges;
    }

}
