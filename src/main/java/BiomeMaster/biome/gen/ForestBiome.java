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
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BIRCH = 1;

    public final int type;

    public ForestBiome() {
        this(TYPE_NORMAL);
    }

    public ForestBiome(int type) {
        super();

        this.type = type;

        PopulatorTree trees = new PopulatorTree(type == TYPE_BIRCH ? BlockSapling.BIRCH : BlockSapling.OAK);
        trees.setBaseAmount(5);
        this.addPopulator(trees);

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(30);
        this.addPopulator(grass);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(3);

        this.addPopulator(tallGrass);

        this.setElevation(63, 81);

        if (type == TYPE_BIRCH) {
            this.temperature = 0.6f;
            this.rainfall = 0.6f;
            
            public void initBiome() {
                register(NormalGenerator.BIRCH_FOREST, this);
            }
        } else {
            this.temperature = 0.7f;
            this.rainfall = 0.8f;
            
            public void initBiome() {
                register(NormalGenerator.FOREST, this);
            }
        }
    }

    @Override
    public String getName() {
        return this.type == TYPE_BIRCH ? "Birch Forest" : "Forest";
    }
}
