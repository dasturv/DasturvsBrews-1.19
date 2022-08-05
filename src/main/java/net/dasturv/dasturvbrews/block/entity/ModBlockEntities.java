package net.dasturv.dasturvbrews.block.entity;

import net.dasturv.dasturvbrews.DasturvBrews;
import net.dasturv.dasturvbrews.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<KettleBlockEntity> KETTLE;

    public static void registerAllBlockEntities() {
        KETTLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(DasturvBrews.MOD_ID, "kettle"),
                FabricBlockEntityTypeBuilder.create(KettleBlockEntity::new,
                        ModBlocks.CERAMIC_KETTLE).build(null));
    }
}
