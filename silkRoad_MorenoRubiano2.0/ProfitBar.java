
public class ProfitBar {
    
    private static final float PERCENTAJE_W_BAR = (float) 0.7;
    private Rectangle profitBar;
    private Rectangle currentProfitBar;
    private int current;
    private int max;
    private int pX;
    private int pY;
    private int widthProfitBar;
    private int heightProfitBar = 15;

    private int widthCurrentProfitBar;
    private int heightCurrentProfitBar = 15;

    public ProfitBar(int canvasW, int canvasH, int max) {

        this.pY=  canvasH - 25 ;
        this.pX = (int) ((canvasW * (1 - PERCENTAJE_W_BAR)))/2;

        this.widthProfitBar = (int) (canvasW * PERCENTAJE_W_BAR);
        this.widthCurrentProfitBar = 0; 

        this.profitBar = new Rectangle(this.widthProfitBar, this.heightProfitBar, this.pX, this.pY, "green");
        this.currentProfitBar = new Rectangle(this.widthCurrentProfitBar, this.heightCurrentProfitBar, this.pX, this.pY, "blue");
        this.profitBar.makeVisible();
        this.currentProfitBar.makeVisible();
        this.current = 0;
        this.max = max;        

    }


    public void reset(){
    this.current = 0;
    }

    public int getCurrent(){
        return this.current;
    }

    
}
