import java.util.HashMap;
import java.util.ArrayList;

public class SilkRoad {
    private final int length;  
    private Rectangle road;
    private ArrayList<Store> stores;
    private final SpiralPath path;
    private ArrayList<Robot> robots;
    private HashMap<Robot, Store> solutionAbstraction;
    private int maxPossibleProfit;
    private int currentProfit;
    private int maxPossibleProfi;
    private boolean isVisible;

    /** constructor ciclo 1 */
    public SilkRoad(int lenght){
        this.stores = new ArrayList<>();
        this.robots = new ArrayList<>();
        this.path = new SpiralPath(length);
        this.maxPossibleProfit = lenght * 100;
        this.currentProfit = 0;
        this.progress = new ProgressBar();
    }
    /** constructor ciclo 2 */
    public SilkRoad(int[][] days){
        this.stores = new ArrayList<>();
        this.robots = new ArrayList<>();
        this.solutionAbstraction = new HashMap<>();
        this.maxPossibleProft = days.length * 100;
        this.currentProfit = 0;
    }

    public void makeVisible() {
        visible = true;
        path.makeVisible();
        for (Store s : stores) s.makeVisible();
        for (Robot r : robots) r.makeVisible();
        progress.makeVisible();
        
        updateProgress();
    }
     public void makeInvisible() {
        visible = false;
        for (Robot r : robots) r.makeInvisible();
        for (Store s : stores) s.makeInvisible();
        path.makeInvisible();
        progress.makeInvisible();
    }
    /**
     * El metodo placeStore lo que hace es crear una nueva tienda con la posicion y los tenges iniciales
     * que se le pasan por parametro y luego agregar esta tienda al array de tiendas.
    */
    public void placeStore(int location,int tenges){
        Store store = new Store(location, tenges);
        this.stores.add(store);

    }

    /**
    // * El metodo removeStore lo que hace es tomar para cada tienda
    // * dentro del array de tiendas y verificar si la posicion en x de la tienda
    // * es igual a la posicion que se quiere eliminar.(esto porque location esta como un point-> el .x es una propiedad de esta clase)
    // * y si lo es, elimina la tienda del array de tiendas y sale del ciclo.
    // * @param location la posicion en x de la tienda que se quiere eliminar
    // */
    public void removeStore(int location){
        for (Store store : this.stores) {
            if (store.getPosition().x == location) {
                this.stores.remove(store);
                break;
            }
        }

    }
    /**
     * El metodo placeRobot lo que hace es crear un nuevo robot con la posicion y los tenges iniciales
     * que se le pasan por parametro y luego agregar este robot al array de robots.
     */
    public void placeRobot(int location, int tenges){
        Robot robot = new Robot(location, tenges);
        this.robots.add(robot);
    }

    /**
     * El metodo removeRobot lo que hace es tomar para cada robot
     * dentro del array de robots y verificar si la posicion en x del robot
     * es igual a la posicion que se quiere eliminar.(esto porque location esta como un point-> el .x es una propiedad de esta clase)
     * y si lo es, elimina el robot del array de robots y sale del ciclo.
     * @param location la posicion en x del robot que se quiere eliminar
     */
    public void removeRobot(int location){
        for (Robot robot : this.robots) {
            if (robot.getPosition().x == location) {
                this.robots.remove(robot);
                break;
            }
        }

    }
    public void resetRoad() {
        resetRobots();
        resupplyStores();    
    }

     public String getInfo() {
        return "SilkRoad{length=" + length + ", stores=" + stores.size() + ", robots=" + robots.size() + "}";
    }


    private Robot findRobotAtLocation(int location) {
    for (Robot robot : this.robots) {
        if (robot.isAtLocation(location)) {
            return robot;
        }
    }
    return null;
    }

    public void moveRobot(int location, int meters) {
        if (meters <= 0) {
            return;
        }

        Robot robot = findRobotAtLocation(location);
        if (robot == null) {
            return;
        }
    
        int newPosition = location + meters;
        robot.moveTo(newPosition);
    }
    
    public void resupplyStores() {
        for (Store store : this.stores) {
            store.resupply();
        }

        if (isVisible()) {
            updateStoresVisual();
        }
    }

    public void returnRobots() {
    for (Robot robot : this.robots) {
        robot.returnToInitialPosition();
    }
    
    if (isVisible()) {
        updateRobotsVisual();
    }
}
    public int getProfit() { 
        return currentProfit; 
    
    }
    private void updateProgress() {
        int max = maxPossible();
        double ratio = (max == 0) ? 1.0 : (double) currentProfit / (currentProfit + max);
        // La barra muestra lo ya obtenido sobre (obtenido + disponible) → 1 cuando no queda nada por obtener
        progress.setRatio(ratio);
        if (visible && !progress.isVisible()) progress.makeVisible();
    }


    public void finish() {
        makeInvisible();
        stores.clear();
        robots.clear();
    }

}


