import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.player.Player;
import dk.sdu.mmmi.cbse.player.PlayerControlSystem;
import dk.sdu.mmmi.cbse.player.PlayerPlugin;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTestClass {

    @Test
    public void playerMoves() {
        World world = new World();
        GameData gameData = new GameData();
        gameData.getKeys().setKey(GameKeys.UP, true);
        new PlayerPlugin().start(gameData, world);
        Entity player = world.getEntities(Player.class).get(0);
        double x = player.getX();
        double y = player.getY();

        new PlayerControlSystem().process(gameData, world);
        boolean xChanged = x!=player.getX();
        boolean yChanged = y!=player.getY();

        assertTrue(xChanged || yChanged);
    }

    @Test
    public void playerUpdateCoordinates() {
        World world = new World();
        GameData gameData = new GameData();
        gameData.getKeys().setKey(GameKeys.UP, true);
        new PlayerPlugin().start(gameData, world);
        Entity player = world.getEntities(Player.class).get(0);
        player.setRotation(45);
        double x = player.getX();
        double y = player.getY();

        PlayerControlSystem playerControlSystem =new PlayerControlSystem();
        for (int i=0; i<10; i++) {
            playerControlSystem.process(gameData, world);
        }

        assertEquals((x+Math.cos(Math.toRadians(45))*10), player.getX(), 0.5f);
        assertEquals((y+Math.sin(Math.toRadians(45))*10), player.getY(), 0.5f);

        player.setRotation(player.getRotation() + 180);
        for (int i=0; i<10; i++) {
            playerControlSystem.process(gameData, world);
        }

        assertEquals(x, player.getX(), 0.5f);
        assertEquals(y, player.getY(), 0.5f);
    }
}
