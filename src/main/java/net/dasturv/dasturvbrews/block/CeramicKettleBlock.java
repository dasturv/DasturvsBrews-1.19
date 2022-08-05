package net.dasturv.dasturvbrews.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CeramicKettleBlock extends KettleBlock{
    public CeramicKettleBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape makeShape(BlockState state){
        VoxelShape shape = VoxelShapes.empty();

        //North
        if (state.get(FACING) == Direction.NORTH) {
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.25, 0.75, 0.4375, 0.75));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.3125, 0.6875, 0.5, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5, 0.4375, 0.5625, 0.5625, 0.5625));
        }

        //West
        if (state.get(FACING) == Direction.WEST) {
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.25, 0.75, 0.4375, 0.75));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.3125, 0.6875, 0.5, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5, 0.4375, 0.5625, 0.5625, 0.5625));
        }

        //South
        if (state.get(FACING) == Direction.SOUTH) {
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.25, 0.75, 0.4375, 0.75));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.3125, 0.6875, 0.5, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5, 0.4375, 0.5625, 0.5625, 0.5625));
        }

        //East
        if (state.get(FACING) == Direction.EAST) {
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.25, 0.75, 0.4375, 0.75));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.4375, 0.3125, 0.6875, 0.5, 0.6875));
            shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5, 0.4375, 0.5625, 0.5625, 0.5625));
        }

        return shape;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape(state);
    }
}
