public class Store {
    private int location;
    private String color;
    private boolean isVisible;
    private boolean isEmpty;
    private int initialTenges;
    private int actualTenges;
    private final int initialLocation;

    public Store(int location,int initialTenges) {
        this.location = location;
        this.color = "blue";
        this.isVisible = false;
        this.isEmpty = (initialTenges <= 0);
        this.initialTenges = initialTenges;
        this.actualTenges = this.initialTenges;
        this.initialLocation = location;
        this.isVisible = false;
    }

    public void resupply() {
        this.actualTenges = this.initialTenges;
        this.isEmpty = (this.actualTenges == 0);
    }

    public int emptyStore(){
        int temp = this.actualTenges;
        this.actualTenges = 0;
        this.isEmpty = (this.actualTenges == 0);
        return temp;
    }

    public void makeVisible() {
        this.isVisible = true;
    }

    public int set(int location, int initialTenges) {
        this.location = location;
        this.initialTenges = Math.max(0, initialTenges);
        this.actualTenges = this.initialTenges;
        this.isEmpty = (this.actualTenges == 0);
        return this.actualTenges;
    }

    public void makeInvisible() {
        this.isVisible = false;
    }

    public boolean isEmpty() {
        return (this.actualTenges == 0);
    }

}
