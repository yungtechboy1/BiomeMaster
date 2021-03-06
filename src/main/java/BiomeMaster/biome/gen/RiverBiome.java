package BiomeMaster.biome.gen;

import cn.nukkit.level.generator.populator.PopulatorGrass;
import cn.nukkit.level.generator.populator.PopulatorSugarcane;
import cn.nukkit.level.generator.populator.PopulatorTallGrass;
import cn.nukkit.level.generator.populator.PopulatorTallSugarcane;
import BiomeMaster.biome.WateryBiome;
import BiomeMaster.generator.NormalGenerator;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class RiverBiome extends WateryBiome {

    public RiverBiome() {
        super();

        PopulatorSugarcane sugarcane = new PopulatorSugarcane();
        sugarcane.setBaseAmount(6);
        PopulatorTallSugarcane tallSugarcane = new PopulatorTallSugarcane();
        tallSugarcane.setBaseAmount(60);

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(30);
        this.addPopulator(grass);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(5);

        this.addPopulator(tallGrass);
        this.addPopulator(sugarcane);
        this.addPopulator(tallSugarcane);

        this.setElevation(58, 62);

        this.temperature = 0.5f;
        this.rainfall = 0.5f;
    }

    @Override
    public String getName() {
        return "River";
    }
    
    public void initBiome() {
        register(NormalGenerator.RIVER, this);
    }
}
