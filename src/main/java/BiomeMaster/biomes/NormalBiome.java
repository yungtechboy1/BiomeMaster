package BiomeMaster.biomes;

import BiomeMaster.Biome;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class NormalBiome extends Biome {
    @Override
    public int getColor() {
        return this.grassColor;
    }
}
