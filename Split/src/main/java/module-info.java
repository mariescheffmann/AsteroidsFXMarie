import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module Split {
    requires Common;
    exports dk.sdu.mmmi.cbse.split;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.split.PlayerControlSystem;
}
