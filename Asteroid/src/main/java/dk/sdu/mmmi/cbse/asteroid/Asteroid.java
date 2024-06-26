package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Emil
 */
public class Asteroid extends Entity {
    @Override
    public Entity copy(Entity e1) {
        System.out.println("i am here");
        Entity e2 = new Asteroid();
        e2.setPolygonCoordinates(e1.getPolygonCoordinates());
        e2.setSplitableIndicator(e1.getSplitableIndicator() - 1);

        return e2;
    }

    @Override
    public void setSplitableIndicator(int splitableIndicator) {
        super.setSplitableIndicator(splitableIndicator);
        updatePolygonCoordinates();
    }

    public void updatePolygonCoordinates() {
        double t1 = AsteroidPlugin.getLength() * getSplitableIndicator();
        double t2 = Math.sin(Math.toRadians(45))*t1*2+t1;

        setPolygonCoordinates(
                -t1,t2,
                t1,t2,
                t2,t1,
                t2,-t1,
                t1,-t2,
                -t1,-t2,
                -t2,-t1,
                -t2,t1
        );

        setRadius((int)(t1*2.7));
    }

    @Override
    public void updateScore() {
        String endpointUrl = "http://localhost:8080/score?point=1";

        try {
            URL url = new URL(endpointUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.getResponseCode();
            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Score system not available");
        }
    }
}