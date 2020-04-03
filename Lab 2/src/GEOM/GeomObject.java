package GEOM;

import java.awt.*;

public abstract class GeomObject {
    protected Color edgeColor;
    protected Color faceColor;
    protected int line_weight = 1;

    public GeomObject () {
        faceColor = new Color(20, 200, 20);
        edgeColor = new Color(150,20,20);
    }
    public abstract void draw (Graphics g, SpaceMapping mapper);
}
