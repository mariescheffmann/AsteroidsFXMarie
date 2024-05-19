package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.ServiceLoader;

/**
 *
 * @author Emil
 */
public class Enemy extends Entity {
    private static Enemy enemy;
    private ServiceLoader<Enemy> loader;
    private int frameCounter = 0;
    private int changeDirectionInterval = 100;
    private long lastShot;
    private long shotInterval = 2000;

    private Enemy() {
        loader = ServiceLoader.load(Enemy.class);
    }

    public static synchronized Enemy getInstance() {
        if (enemy == null) {
            enemy = new Enemy();
        }
        return enemy;
    }

    public int getFrameCounter() {
        return frameCounter;
    }

    public void setFrameCounter(int arg) {
        frameCounter = arg;
    }

    public int getChangeDirectionInterval() {
        return changeDirectionInterval;
    }

    public boolean isReadyToShoot() {
        if (System.currentTimeMillis() - lastShot > shotInterval) {
            lastShot = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }
    }
}