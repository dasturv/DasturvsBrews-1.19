package net.dasturv.dasturvbrews.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class TeaMatBlock extends Block {

    public TeaMatBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0, 1, 0.125, 1));

        return shape;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return !(state.isOf(ModBlocks.BLACK_TEA_LEAF_MAT) || state.isOf(ModBlocks.PUERH_TEA_LEAF_MAT));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(10) == 0){
            Block block = state.getBlock();
            if (block == ModBlocks.GREEN_TEA_LEAF_MAT) {
                world.setBlockState(pos, ModBlocks.WHITE_TEA_LEAF_MAT.getDefaultState());
            } else if (block == ModBlocks.WHITE_TEA_LEAF_MAT) {
                world.setBlockState(pos, ModBlocks.OOLONG_TEA_LEAF_MAT.getDefaultState());
            } else if (block == ModBlocks.OOLONG_TEA_LEAF_MAT) {
                world.setBlockState(pos, ModBlocks.BLACK_TEA_LEAF_MAT.getDefaultState());
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return this.canPlaceOnTop(world, blockPos, blockState);
    }

    private boolean canPlaceOnTop(BlockView world, BlockPos pos, BlockState floor) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP);
    }
}
