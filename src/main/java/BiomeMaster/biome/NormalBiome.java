package BiomeMaster.biome;

import BiomeMaster.generator.NormalGenerator;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class NormalBiome extends NormalGenerator {
    @Override
    public int getColor() {
        return this.grassColor;
    }
}
