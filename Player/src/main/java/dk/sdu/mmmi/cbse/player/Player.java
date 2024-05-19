package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.ServiceLoader;

/**
 *
 * @author Emil
 */
public class Player extends Entity {
    private static Player player;
    private ServiceLoader<Player> loader;

    private Player() {
        loader = ServiceLoader.load(Player.class);
    }

    public static synchronized Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }
}
