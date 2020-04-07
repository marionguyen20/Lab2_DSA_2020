package GEOM;

public class ViewPort {

    private double xMin, xMax;
    private double yMin, yMax;

    //Constructor
    public ViewPort (double xMin, double xMax, double yMin, double yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
    public ViewPort clone () {
        return new ViewPort(this.xMin, this.xMax, this.yMin, this.yMax);
    }
    public void combine (ViewPort vp) {
        this.xMin = Math.min(this.xMin, vp.xMin);
        this.xMax = Math.max(this.xMax, vp.xMax);
        this.yMin = Math.min(this.yMin, vp.yMin);
        this.yMax = Math.max(this.yMax, vp.yMax);
    }
    public void addPoint (Point2D point) {
        this.xMin = Math.min(this.xMin, point.getX());
        this.xMax = Math.max (this.xMax, point.getX());
        this.yMin = Math.min(this.yMin, point.getY());
        this.yMax = Math.max (this.yMax, point.getY());
    }

    //Getter and Setter
    public double getyMin () {return yMin;}
    public void setyMin (double yMin) {this.yMin = yMin;}
    public double getyMax () {return yMax;}
    public void setyMax (double yMax) {this.yMax = yMax;}
    public double getxMin () {return xMin;}
    public void setxMin (double xMin) {this.xMin = xMin;}
    public double getxMax () {return xMax;}
    public void setxMax (double xMax) {this.xMax = xMax;}
}