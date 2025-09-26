public class SpiralPath {
    private int length;          
    private int unitPx;          
    private int originX;         
    private int originY;         
    private int thickness; 
     private boolean visible;
    private boolean spiralEnabled;
     private final List<Rectangle> segments;
}

public Path(int length, int unitPx, int originX, int originY, int thickness) {}




    public void makeVisible() {
        if (visible) return;
        visible = true;
        redraw();
    }

    
    public void makeInvisible() {
        if (!visible) return;
        erase();
        visible = false;
    }

    public boolean isVisible() { r
        
        return visible;
    }
    




      public void redraw() {
        if (!visible) return;
        clearSegments();
        if (spiralEnabled) {
            drawSpiral();
        } else {
            drawStraight();
        }
    }


