package dk.sdu.mmmi.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();
    
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private int radius;
    private int splitableIndicator = 1;

    public Entity copy(Entity e1) {
        Entity e2 = new Entity();
        e2.setPolygonCoordinates(polygonCoordinates);
        e2.setX(x);
        e2.setY(y);
        e2.setRotation(rotation);
        e2.setRadius(radius);
        e2.setSplitableIndicator(splitableIndicator);

        return e2;
    }

    public String getID() {
        return ID.toString();
    }


    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }
       

    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }

    
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return  radius;
    }

    public void setSplitableIndicator(int splitableIndicator) {
        this.splitableIndicator=splitableIndicator;
    }

    public int getSplitableIndicator() {
        return splitableIndicator;
    }

    public void assemble() {
    }
}
