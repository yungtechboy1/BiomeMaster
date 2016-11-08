package BiomeMaster.biome.gen;

import cn.nukkit.block.*;
import cn.nukkit.level.generator.populator.PopulatorGrass;
import cn.nukkit.level.generator.populator.PopulatorTallGrass;
import cn.nukkit.level.generator.populator.PopulatorTree;
import BiomeMaster.biome.SnowyBiome;
import BiomeMaster.generator.NormalGenerator;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class TaigaBiome extends SnowyBiome {

    public TaigaBiome() {
        super();

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(6);
        this.addPopulator(grass);

        PopulatorTree trees = new PopulatorTree(BlockSapling.SPRUCE);
        trees.setBaseAmount(5);
        this.addPopulator(trees);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(1);

        this.addPopulator(tallGrass);

        this.setElevation(63, 81);

        this.temperature = 0.05f;
        this.rainfall = 0.8f;
        
        this.setGroundCover(new Block[]{
                new BlockGrass(),
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt()
        });
    }

    @Override
    public String getName() {
        return "Taiga";
    }
    
    public void initBiome() {
        register(NormalGenerator.TAIGA, this);
    }
}
