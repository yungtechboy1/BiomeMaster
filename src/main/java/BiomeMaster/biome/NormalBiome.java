package BiomeMaster.biome;

import BiomeMaster.generator.NormalGenerator;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class NormalGenerator extends Biome {
    @Override
    public int getColor() {
        return this.grassColor;
    }
}
