package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

/**
 *
 * @author Phillip O
 */
public class Collision implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            for (Entity collisionDetection : world.getEntities()) {
                if (entity == collisionDetection) {
                    continue;
                }

                if (collides(entity, collisionDetection)) {
                    world.collides(entity, collisionDetection);
                }
            }
        }
    }

    public boolean collides(Entity entity, Entity entity2) {
        float dx = (float) entity.getX() - (float) entity2.getX();
        float dy = (float) entity.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if ((distance + 1) < (entity.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;
    }


}
