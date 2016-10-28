package BiomeMaster.biome.gen;

import BiomeMaster.generator.NormalGenerator;
import BiomeMaster.populator.JungleBigTreePopulator;
import BiomeMaster.populator.JungleTreePopulator;
import BiomeMaster.populator.PopulatorFern;
import cn.nukkit.level.generator.biome.GrassyBiome;
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
        this.temperature = 1.2D;
        this.rainfall = 0.9D;
    }

    @Override
    public String getName() {
        return "Jungle";
    }

    public void initBiome() {
        register(NormalGenerator.JUNGLE, this);
    }
}
