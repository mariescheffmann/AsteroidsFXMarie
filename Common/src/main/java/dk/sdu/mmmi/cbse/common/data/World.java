package dk.sdu.mmmi.cbse.common.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author jcs
 */
public class World {

    private final Map<String, Entity> entityMap = new ConcurrentHashMap<>();

    public String addEntity(Entity entity) {
        entityMap.put(entity.getID(), entity);
        return entity.getID();
    }

    public void removeEntity(String entityID) {
        entityMap.remove(entityID);
    }

    public void removeEntity(Entity entity) {
        if (entity.getLives() > 1) {
            entity.setLives(entity.getLives() - 1);
            return;
        }

        int splitableIndicator = entity.getSplitableIndicator();
        entityMap.remove(entity.getID());
        entity.updateScore();

        if (splitableIndicator != 1) {
            Entity entity1 = entity.copy(entity);
            entity1.setRotation(entity.getRotation() + 90);
            double changeX = Math.cos(Math.toRadians(entity1.getRotation())) * entity1.getRadius();
            double changeY = Math.sin(Math.toRadians(entity1.getRotation())) * entity1.getRadius();
            entity1.setX(entity.getX() + changeX);
            entity1.setY(entity.getY() + changeY);

            Entity entity2 = entity.copy(entity);
            entity2.setRotation(entity.getRotation() - 90);
            changeX = Math.cos(Math.toRadians(entity2.getRotation())) * entity2.getRadius();
            changeY = Math.sin(Math.toRadians(entity2.getRotation())) * entity2.getRadius();
            entity2.setX(entity.getX() + changeX);
            entity2.setY(entity.getY() + changeY);

            addEntity(entity1);
            addEntity(entity2);
        }
    }

    public Collection<Entity> getEntities() {
        return entityMap.values();
    }

    public <E extends Entity> List<Entity> getEntities(Class<E>... entityTypes) {
        List<Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes) {
                if (entityType.equals(e.getClass())) {
                    r.add(e);
                }
            }
        }
        return r;
    }

    public Entity getEntity(String ID) {
        return entityMap.get(ID);
    }

    public void collides (Entity e1, Entity e2) {
        System.out.println(e1.getClass());
        System.out.println(e2.getClass());

        removeEntity(e1);
        removeEntity(e2);
    }

}
