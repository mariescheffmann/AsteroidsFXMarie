package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * The IEntityProcessingService interface serves as a contract ensuring ability to
 * process entities.
 *
 * @author jcs
 * @version 1.0
 */
public interface IEntityProcessingService {

    /**
     * Processes the entity before the frame is updated.
     *
     * @param gameData
     * @param world
     * @throws
     */
    void process(GameData gameData, World world);
}
