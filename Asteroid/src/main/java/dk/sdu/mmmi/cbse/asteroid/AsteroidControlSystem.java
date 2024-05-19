package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX);
            asteroid.setY(asteroid.getY() + changeY);

            if (asteroid.getX() < 0) {
                asteroid.setRotation(180 - asteroid.getRotation());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setRotation(540 - asteroid.getRotation());
            }

            if (asteroid.getY() < 0) {
                asteroid.setRotation(360 - asteroid.getRotation());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setRotation(360 - asteroid.getRotation());
            }

        }
    }
}
