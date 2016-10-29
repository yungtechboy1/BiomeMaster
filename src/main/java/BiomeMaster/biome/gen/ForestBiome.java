package BiomeMaster.biome.gen;

import cn.nukkit.block.BlockSapling;
import cn.nukkit.level.generator.populator.PopulatorGrass;
import cn.nukkit.level.generator.populator.PopulatorTallGrass;
import cn.nukkit.level.generator.populator.PopulatorTree;
import BiomeMaster.biome.GrassyBiome;
import BiomeMaster.generator.NormalGenerator;
/**
 * author: MagicDroidX
 * Nukkit Project
 */

public class ForestBiome extends GrassyBiome {
    public ForestBiome() {
        super();

        PopulatorTree trees = new PopulatorTree(BlockSapling.OAK);
        trees.setBaseAmount(5);
        this.addPopulator(trees);

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(30);
        this.addPopulator(grass);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(3);

        this.addPopulator(tallGrass);
        
        this.setElevation(63, 81);
        
        this.temperature = 0.7f;
        this.rainfall = 0.8f;
    }

    @Override
    public String getName() {
        return "Forest";
    }

    public void initBiome() {
        register(NormalGenerator.FOREST, this);
    }
}
