package BiomeMaster.populator.biomes;

import BiomeMaster.util.EnumFacing;
import BiomeMaster.populator.BasicPopulator;
import cn.nukkit.block.BlockDeadBush;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;

public class DeadBushPopulator extends BasicPopulator {
    private final BlockDeadBush block;

    public WorldGenBush(BlockDeadBush blockIn) {
        this.block = blockIn;
    }

    public boolean generate(ChunkManager level, NukkitRandom rand, Vector3 position) {
        for (int i = 0; i < 64; ++i) {
            Vector3 blockpos = position.add(rand.nextBoundedInt(8) - rand.nextBoundedInt(8), rand.nextBoundedInt(4) - rand.nextBoundedInt(4), rand.nextBoundedInt(8) - rand.nextBoundedInt(8));

            if (level.isAirBlock(blockpos) && (!level.provider.getHasNoSky() || pos.getFloorY() < 128) && this.block.canBlockStay(worldIn, blockpos, this.block.getDefaultState())) {
                level.setBlockState(blockpos, this.block.getDefaultState(), 2);
            }
        }

        return true;
    }
}
