package BiomeMaster.biome.gen;

import BiomeMaster.generator.NormalGenerator;
import BiomeMaster.populator.trees.JungleBigTreePopulator;
import BiomeMaster.populator.trees.JungleTreePopulator;
import BiomeMaster.populator.biomes.PopulatorFern;
import BiomeMaster.biome.GrassyBiome;
import cn.nukkit.level.generator.populator.PopulatorGrass;

public class JungleBiome extends GrassyBiome {

    public JungleBiome() {
        super();
        JungleTreePopulator trees = new JungleTreePopulator();
        JungleBigTreePopulator bigTrees = new JungleBigTreePopulator();
        trees.setBaseAmount(10);
        bigTrees.setBaseAmount(6);
        //PopulatorTallGrass tallGrass = new PopulatorTallGrass();

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(20);

        PopulatorFern fern = new PopulatorFern();
        fern.setBaseAmount(30);

        this.addPopulator(grass);
        this.addPopulator(fern);
        this.addPopulator(bigTrees);
        this.addPopulator(trees);
        this.setElevation(62, 63);
        this.temperature = 1.2f;
        this.rainfall = 0.9f;
    }

    @Override
    public String getName() {
        return "Jungle";
    }

    public void initBiome() {
        register(NormalGenerator.JUNGLE, this);
    }
}
