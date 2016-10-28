package BiomeMaster.biome.gen;

import cn.nukkit.block.Block;
import cn.nukkit.level.generator.populator.PopulatorSugarcane;
import cn.nukkit.level.generator.populator.PopulatorTallSugarcane;
import BiomeMaster.biome.WateryBiome;
import BiomeMaster.generator.NormalGenerator;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class OceanBiome extends WateryBiome {

    public OceanBiome() {
        super();

        PopulatorSugarcane sugarcane = new PopulatorSugarcane();
        sugarcane.setBaseAmount(6);
        PopulatorTallSugarcane tallSugarcane = new PopulatorTallSugarcane();
        tallSugarcane.setBaseAmount(60);
        this.addPopulator(sugarcane);
        this.addPopulator(tallSugarcane);
        this.setElevation(46, 58);

        this.temperature = 0.5f;
        this.rainfall = 0.5f;

    }

    @Override
    public Block[] getGroundCover() {
        return super.getGroundCover();
    }

    @Override
    public String getName() {
        return "Ocean";
    }
    
    public void initBiome() {
        register(NormalGenerator.OCEAN, this);
    }
}
