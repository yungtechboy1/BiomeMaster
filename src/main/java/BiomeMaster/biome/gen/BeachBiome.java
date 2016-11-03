package BiomeMaster.biome.gen;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockSand;
import cn.nukkit.block.BlockSandstone;
import cn.nukkit.level.generator.populator.PopulatorTallGrass;
import BiomeMaster.biome.SandyBiome;
import BiomeMaster.generator.NormalGenerator;

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
    }

    @Override
    public String getName() {
        return "Beach";
    }
    
        @Override
    public int getSurfaceBlock() {
        return Block.DESERT;
    }

    @Override
    public int getGroundBlock() {
        return Block.SAND_STONE;
    }
    
    @Override
    public int getColor() {
        return 0xfade85;
    }
    
    public void initBiome() {
        register(NormalGenerator.BEACH, this);
    }
}
