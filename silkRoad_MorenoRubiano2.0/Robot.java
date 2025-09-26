public class Robot {
    
    private int actualTenges;
    private String color;
    private boolean isVisible;
    private final int initialLocation;
    private int position;  
    private int location; 
      
    
    public Robot(int location) {
        this.initialLocation = location;
        this.color = "grey";
        this.actualTenges = 0;
        this.isVisible = false;
    }

    public void makeInvisible() {
        this.isVisible = false;
    }

    public int getProfit() {
        return actualTenges;
    }

    public void goInitialPosition() {
        this.position = this.initialLocation;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveTo(int newPosition) {
        this.position = newPosition;
    }

    public void makeVisible() {
        this.isVisible = true;
    }
    
    public boolean isAtLocation(int location) {
        return this.location == location;
    }
    
    public void pickTenges(int actualTenges) {
        this.actualTenges = actualTenges;
    }

    public boolean isVisible() {
        return isVisible;
    }
    
     public void setVisible(boolean visible) {
        this.isVisible = visible;
    }
    public int getInitialLocation() {
        return initialLocation;
    }
}
