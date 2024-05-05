import dk.sdu.mmmi.cbse.collision.Collision;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with Collision;
}

