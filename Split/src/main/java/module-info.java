import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module Split {
    requires Common;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.split.PlayerControlSystem;
}
