package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;
    private static double length = 2;

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        int splitableIndicator = 5;
        double t1 = length * splitableIndicator;
        double t2 = Math.sin(Math.toRadians(45))*t1*2+t1;

        Entity asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(
                -t1,t2,
                t1,t2,
                t2,t1,
                t2,-t1,
                t1,-t2,
                -t1,-t2,
                -t2,-t1,
                -t2,t1
        );
        System.out.println("her ??");
        asteroid.setX(50);
        asteroid.setY(50);
        asteroid.setRotation(100);
        asteroid.setRadius(10);
        asteroid.setSplitableIndicator(splitableIndicator);
        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

    public static double getLength() {
        return length;
    }

}
