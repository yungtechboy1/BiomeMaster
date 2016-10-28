package BiomeMaster.biome;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockSand;
import cn.nukkit.block.BlockSandstone;
import cn.nukkit.level.generator.populator.PopulatorTallGrass;
import BiomeMaster.biome.SandyBiome;
import BiomeMaster.biome.NormalGenerator;

/**
 * Author: PeratX, NycuRO
 * Nukkit Project
 */
public class BeachBiome extends SandyBiome {
    public BeachBiome() {
        super();

        this.setElevation(47, 68);
        this.temperature = 0.8f;
        this.rainfall = 0.4f;
        
        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(3);

        this.addPopulator(tallGrass);
        this.removePopulator(PopulatorCactus);
        this.removePopulator(PopulatorDeadBush);

        this.setGroundCover(new Block[]{
                new BlockSand(),
                new BlockSand(),
                new BlockSand(),
                new BlockSand(),
                new BlockSandstone(),
                new BlockSandstone(),
                new BlockSandstone(),
                new BlockSandstone(),
                new BlockSandstone(),
                new BlockSandstone()
        });
    }

    @Override
    public String getName() {
        return "Beach";
    }
    
    @Override
    public int getColor() {
        return 0xfade85;
    }
    
    public void initBiome() {
        register(NormalGenerator.BEACH, this);
    }
}
