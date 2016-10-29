package BiomeMaster.biome.gen;

import BiomeMaster.generator.NormalGenerator;
import BiomeMaster.populator.trees.DarkOakTreePopulator;
import BiomeMaster.populator.mushroom.MushroomPopulator;
import BiomeMaster.biome.GrassyBiome;
import cn.nukkit.level.generator.populator.PopulatorFlower;
import cn.nukkit.level.generator.populator.PopulatorGrass;

public class RoofedForestMBiome extends GrassyBiome {

    public RoofedForestMBiome() {
        super();
        DarkOakTreePopulator tree = new DarkOakTreePopulator();
        tree.setBaseAmount(20);

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(10);

        PopulatorFlower flower = new PopulatorFlower();
        flower.setBaseAmount(2);

        MushroomPopulator mushroom = new MushroomPopulator();
        mushroom.setBaseAmount(1);
        mushroom.setRandomAmount(1);

        this.addPopulator(grass);
        this.addPopulator(tree);
        this.addPopulator(flower);
        this.addPopulator(mushroom);

        this.setElevation(63, 127);
        this.temperature = 0.7f;
        this.rainfall = 0.8f;
    }

    @Override
    public String getName() {
        return "Roofed ForestM";
    }

    public void initBiome() {
        register(NormalGenerator.ROOFED_FOREST_M, this);
    }
}
