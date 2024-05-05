package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.ServiceLoader;

/**
 *
 * @author corfixen
 */
public class Bullet extends Entity {
    private static Bullet bullet;
    private ServiceLoader<Bullet> loader;

    public Bullet() {
        loader = ServiceLoader.load(Bullet.class);
    }

    public static synchronized Bullet getInstance() {
        if (bullet == null) {
            bullet = new Bullet();
        }
        return bullet;
    }
}
