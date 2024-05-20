package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
/**
 * The IPostEntityProcessingService interface serves as a contract ensuring ability
 * to perform actions after processing of all entities
 *
 * @author jcs
 * @version 1.0
 */
public interface IPostEntityProcessingService {

    /**
     * Runs a process that must be performed after processing of all entities.
     *
     * @param gameData
     * @param world
     */
    void process(GameData gameData, World world);
}
