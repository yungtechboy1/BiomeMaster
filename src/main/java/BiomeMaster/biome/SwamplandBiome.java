package BiomeMaster.biome;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockFlower;
import cn.nukkit.block.BlockSapling;
import cn.nukkit.level.generator.populator.PopulatorFlower;
import cn.nukkit.level.generator.populator.PopulatorLilyPad;
import BiomeMaster.populator.SwampTreePopulator;
import cn.nukkit.level.generator.biome.GrassyBiome;
import BiomeMaster.generator.NormalGenerator;

public class SwamplandBiome extends GrassyBiome {

    public SwamplandBiome() {
        super();

        PopulatorLilyPad lilypad = new PopulatorLilyPad();
        lilypad.setBaseAmount(4);

        SwampTreePopulator trees = new SwampTreePopulator();
        trees.setBaseAmount(2);

        PopulatorFlower flower = new PopulatorFlower();
        flower.setBaseAmount(2);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_BLUE_ORCHID);

        this.addPopulator(trees);
        this.addPopulator(flower);
        this.addPopulator(lilypad);

        this.setElevation(62, 63);

        this.temperature = 0.8f;
        this.rainfall = 0.9f;
    }

    @Override
    public String getName() {
        return "Swamp";
    }

    @Override
    public int getColor() { // When this temperature goes below -0.1, a lush green color is used, 0x4C763C, otherwise it is set to a sickly brown, 0x6A7039. In addition, the color of the water in swamplands is always multiplied by a greenish tinge, 0xE0FFAE.
        return 0xE0FFAE;
    }
    
    public void initBiome() {
        register(NormalGenerator.SWAMP, this);
    }
}
