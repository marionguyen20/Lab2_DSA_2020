package GEOM;

import java.awt.*;
import java.util.Random;

public class Point2D extends GeomObject {
    public static int POINT_HALF_SIZE = 2;

    private double x;
    private double y;

    // Create a point by passing the coordinates of the point
    public Point2D (double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Create a point by copying the coordinates from an old Point
    public  Point2D ( Point2D a) {
        this.x = a.x;
        this.y = a.y;
    }

    public  Point2D () {
        this.x = 0;
        this.y = 0;
    }

    public Point2D clone () {
        return new Point2D(this.x, this.y);
    }


    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graphics2D g2 = (Graphics2D) g;
        Point2D point = mapper.logic2Device(this.getX(), this.getY());

        int x = (int) point.getX() - POINT_HALF_SIZE;
        int y = (int) point.getY() - POINT_HALF_SIZE;

        g2.setColor(this.faceColor);
        g2.fillRect(x,y,2*POINT_HALF_SIZE,2*POINT_HALF_SIZE);
    }

    //Create method Generate N points use Array of Object
    public static Point2D[] generate(int N, double min, double max){
        Random generator = new Random();
        Point2D[] list = new Point2D[N];
        for(int idx=0; idx < N; idx++){
            double x = min + generator.nextDouble()*(max - min);
            double y = min + generator.nextDouble()*(max - min);
            list[idx] = new Point2D(x,y);
        }
        return list;
    }

    public static Point2D[] linear (int N, double a, double b, double xMin, double xMax) {
        Point2D[] list = new Point2D[N];
        double step = (xMax - xMin) / (N-1);
        double x = xMin;
        for (int idx = 0; idx < N; idx ++) {
            double y = a*x + b;
            list[idx] = new Point2D(x,y);
            x += step;
        }
        return list;
    }

    //Compute AB distance
    public static double distanceAB (Point2D a, Point2D b) {
        double xa = a.getX();
        double ya = a.getY();
        double xb = b.getX();
        double yb = b.getY();
        double distance = Math.sqrt(Math.pow((xa-xb),2) + Math.pow((ya - yb),2));
        return distance;
    }

    //Compute to a point specified
    public double PointDistance (Point2D o) {
        double xo = o.getX();
        double yo = o.getY();
        double pointdistance = Math.sqrt(Math.pow((xo-this.x),2) + Math.pow((yo - this.y),2));
        return pointdistance;
    }

    //Override toString method
    @Override
    public String toString (){
        return String.format("P(%6.2f, %6.2f)", this.x, this.y);
    }

    //Getter and Setter
    public double getX() {
        return this.x;
    }
    public void setX (double x) {
        this.x = x;
    }
    public double getY() {
        return  this.y;
    }
    public void setY (double y) {
        this.y = y;
    }
}