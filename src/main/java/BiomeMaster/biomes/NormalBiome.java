package BiomeMaster.biomes;

import BiomeMaster.Biomes;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class NormalBiome extends Biomes {
    @Override
    public int getColor() {
        return this.grassColor;
    }
}
