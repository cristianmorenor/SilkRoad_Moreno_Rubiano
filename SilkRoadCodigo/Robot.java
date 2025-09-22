import java.awt.Point;
import java.util.ArrayList;

public class Robot {
    private String color;
    private Point position;
    private Point initialPosition;
    private int actualTenges;
    private int initialTenges;

    public Robot(int location, int initialTenges) {
        this.position = new Point(location, 0);
        this.actualTenges = initialTenges;
        this.initialTenges= initialTenges;
        this.initialPosition = new Point(location, 0);

    }

    public Point getPosition() {
        return position;
    }

   public boolean isAtLocation(int location) {
    return this.position.x == location;
    }

    /**
     * Retorna los robots a su posicion inicial y reestablece la cantidad de tenges inicial.
     * 
     */
    public void returnToInitialPosition() {
        this.position.x = this.initialPosition.x;
        this.position.y = this.initialPosition.y;
        this.actualTenges = this.initialTenges;
    }

    /**
     * Mueve el robot a una nueva posicion 
     * @param newPosition la nueva coordenada en x de la posicion 
     */
    public void moveTo(int newPosition) {
        this.position.x = newPosition;
    }
    


}
