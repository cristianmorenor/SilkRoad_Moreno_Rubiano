import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;



public class SilkRoad {


    private final Map<Integer, Store> stores;
    private final ArrayList<Robot> robots;
    private final HashMap<Robot, Store> solutionAbstraction;
    private final ProfitBar profitBar;


    /** constructor ciclo 1 */
    public SilkRoad(int lenght){
        this.stores = new TreeMap<>(); 
        this.robots = new ArrayList<>();
        this.solutionAbstraction = new HashMap<>();
        this.profitBar = new ProfitBar(300, 300, lenght*100);
        
    }
    /** constructor ciclo 2 */
    public SilkRoad(int[][] days){
        this.stores = new TreeMap<>();
        this.robots = new ArrayList<>();
        this.solutionAbstraction = new HashMap<>();
        this.profitBar = new ProfitBar(300, 300, days[0].length*100);

        
    } 
    /**
     * El metodo placeStore lo que hace es crear una nueva tienda con la posicion y los tenges iniciales
     * que se le pasan por parametro y luego agregar esta tienda al array de tiendas.
    */
    public void placeStore(int location,int tenges){
        Store store = new Store(location, tenges);
        this.stores.put(location, store);

    }

    /**
    // * El metodo removeStore lo que hace es tomar para cada tienda
    // * dentro del array de tiendas y verificar si la posicion en x de la tienda
    // * es igual a la posicion que se quiere eliminar.(esto porque location esta como un point-> el .x es una propiedad de esta clase)
    // * y si lo es, elimina la tienda del array de tiendas y sale del ciclo.
    // * @param location la posicion en x de la tienda que se quiere eliminar
    // */
    public void removeStore(int location){
        this.stores.remove(location);
    }
    /**
     * El metodo placeRobot lo que hace es crear un nuevo robot con la posicion y los tenges iniciales
     * que se le pasan por parametro y luego agregar este robot al array de robots.
     */
    public void placeRobot(int location, int tenges){
        Robot robot = new Robot(location);
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
        Robot robot = findRobotAtLocation(location);
        if (robot != null) {
            this.robots.remove(robot);
        }

    }


    /**
     * El metodo findRobotAtLocation busca un robot en la posicion especificada.
     * Si hay un robot en esa posiciion en especifico, lo retorna, si no hay ninguno, retorna null.
     * @param location posicion en la que quiero buscar el robot
     */
    private Robot findRobotAtLocation(int location) {
        for (Robot robot : this.robots) {
            if (robot.getPosition() == location) {
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
        for (Store store : this.stores.values()) {
            store.resupply();
        }
    }

    public void returnRobots() {
    for (Robot robot : this.robots) {
        robot.goInitialPosition();
    }
    }

    public void reboot(){
        for (Robot robot : this.robots) {
            robot.goInitialPosition();
            robot.pickTenges(0);
        }
        this.solutionAbstraction.clear();
        this.profitBar.reset();
        
    }
    public int profitBar(){
        return this.profitBar.getCurrent();

    }

    public int totalProfit(){
        int total = 0;
        for (Robot robot : this.robots) {
            total += robot.getProfit();
        }
        return total;
    }

    public void updateProFitBar(int currentProfit,int maxPossibleProfit){

        int newCurrent = this.profitBar.getCurrent() + currentProfit;
        if (newCurrent <= maxPossibleProfit) {
            this.profitBar.reset();
            for (int i = 0; i < newCurrent; i++) {
                this.profitBar.getCurrent();
            }
        } else {
            this.profitBar.reset();
            for (int i = 0; i < maxPossibleProfit; i++) {
                this.profitBar.getCurrent();
            }
        }
    }

}



