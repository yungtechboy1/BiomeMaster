package BiomeMaster.biome.gen;

import cn.nukkit.block.BlockSapling;
import cn.nukkit.level.generator.populator.PopulatorTallGrass;
import cn.nukkit.level.generator.populator.PopulatorTree;
import BiomeMaster.biome.SnowyBiome;
import BiomeMaster.biome.NormalGenerator;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class IcePlainsBiome extends SnowyBiome {

    public IcePlainsBiome() {
        super();
        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(5);

        PopulatorTree trees = new PopulatorTree(BlockSapling.SPRUCE);
        trees.setBaseAmount(1);
        trees.setRandomAmount(1);

        this.addPopulator(tallGrass);
        this.addPopulator(trees);
        this.setElevation(63, 74);
        this.temperature = 0.0f;
        this.rainfall = 0.5f;
    }

    public String getName() {
        return "Ice Plains";
    }
    
    public void initBiome() {
        register(NormalGenerator.ICE_PLAINS, this);
    }
}
