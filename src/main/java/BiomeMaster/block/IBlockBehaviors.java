package BiomeMaster.block;

import cn.nukkit.block.Block;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.level.ChunkManager;

public interface IBlockBehaviors {
    boolean func_189547_a(ChunkManager p_189547_1_, BlockVector3 p_189547_2_, int p_189547_3_, int p_189547_4_);

    void func_189546_a(ChunkManager p_189546_1_, BlockVector3 p_189546_2_, Block p_189546_3_);
}
