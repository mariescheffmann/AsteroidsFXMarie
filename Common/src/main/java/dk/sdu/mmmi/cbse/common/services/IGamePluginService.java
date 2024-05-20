package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * The IGamePluginService interface serves as a contract ensuring ability to
 * control the lifecycle of entities
 *
 * @author jcs
 * @version 1.0
 */
public interface IGamePluginService {

    /**
     * Starts the lifecycle of the entity
     *
     * @param gameData
     * @param world
     */
    void start(GameData gameData, World world);

    /**
     * Ends the lifecycle of the entity
     *
     * @param gameData
     * @param world
     */
    void stop(GameData gameData, World world);
}
