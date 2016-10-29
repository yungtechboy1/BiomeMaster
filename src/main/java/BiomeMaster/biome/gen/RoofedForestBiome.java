package BiomeMaster.biome.gen;

import BiomeMaster.generator.NormalGenerator;
import BiomeMaster.populator.trees.DarkOakTreePopulator;
import BiomeMaster.populator.mushroom.MushroomPopulator;
import BiomeMaster.biome.GrassyBiome;
import cn.nukkit.level.generator.populator.PopulatorFlower;
import cn.nukkit.level.generator.populator.PopulatorGrass;

public class RoofedForestBiome extends GrassyBiome {

    public RoofedForestBiome() {
        super();
        DarkOakTreePopulator tree = new DarkOakTreePopulator();
        tree.setBaseAmount(30);

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(10);

        PopulatorFlower flower = new PopulatorFlower();
        flower.setBaseAmount(2);

        MushroomPopulator mushroom = new MushroomPopulator();
        mushroom.setBaseAmount(0);
        mushroom.setRandomAmount(1);

        this.addPopulator(mushroom);
        this.addPopulator(grass);
        this.addPopulator(tree);
        this.addPopulator(flower);

        this.setElevation(62, 68);
        this.temperature = 0.7;
        this.rainfall = 0.8;
    }

    @Override
    public String getName() {
        return "Roofed Forest";
    }

    public void initBiome() {
        register(NormalGenerator.ROOFED_FOREST, this);
    }
}
