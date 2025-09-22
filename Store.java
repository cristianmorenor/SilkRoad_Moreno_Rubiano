
import java.awt.Point;

public class Store {
    private int initialTenges;
    private int tenges;
    private int actualTenges;
    private Point position;
    private String color;
    private boolean isEmpty;
    private Point location;


    public Point getPosition() {
        return position;
    }
    public Store(int location, int initialTenges){
        this.location = new Point(location, 0);
        this.initialTenges = initialTenges;
    }

    public void resupply() {
        this.tenges = this.initialTenges;
    }


    
}

