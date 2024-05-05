package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = 1.5 * Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = 1.5 * Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX);
            bullet.setY(bullet.getY() + changeY);

            if (bullet.getX() < 0) {
                world.removeEntity(bullet.getID());
            }

            if (bullet.getX() > gameData.getDisplayWidth()) {
                world.removeEntity(bullet.getID());
            }

            if (bullet.getY() < 0) {
                world.removeEntity(bullet.getID());
            }

            if (bullet.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(bullet.getID());
            }
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity bullet = new Bullet();
        this.setShape(bullet);
        double x = Math.cos(Math.toRadians(shooter.getRotation())) * shooter.getRadius();
        double y = Math.sin(Math.toRadians(shooter.getRotation())) * shooter.getRadius();
        bullet.setX(shooter.getX() + x);
        bullet.setY(shooter.getY() + y);

        bullet.setRotation(shooter.getRotation());
        bullet.setRadius(2);
        return bullet;
    }

    private void setShape(Entity entity) {
        entity.setPolygonCoordinates(0,-1,1,0,-1,1);
    }

}
