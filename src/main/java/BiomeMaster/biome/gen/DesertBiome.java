package BiomeMaster.biome.gen;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockSand;
import cn.nukkit.block.BlockSandstone;
import BiomeMaster.biome.SandyBiome;
import BiomeMaster.generator.NormalGenerator;
import cn.nukkit.level.generator.populator.PopulatorCactus;
import cn.nukkit.level.generator.populator.PopulatorDeadBush;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class DesertBiome extends SandyBiome {
    public DesertBiome() {
        super();
        
        PopulatorCactus cactus = new PopulatorCactus();
        cactus.setRandomAmount(10);

        PopulatorDeadBush deadbush = new PopulatorDeadBush();
        deadbush.setRandomAmount(2);

        this.addPopulator(cactus);
        this.addPopulator(deadbush);
        
        this.setElevation(63, 69);
        
        this.temperature = 2.0f;
        this.rainfall = 0.0f;
    }

    @Override
    public String getName() {
        return "Desert";
    }
    
    @Override
    public int getSurfaceBlock() {
        return Block.SAND;
    }

    @Override
    public int getGroundBlock() {
        return Block.SAND;
    }

    @Override
    public int getStoneBlock() {
        return Block.SANDSTONE;
    }

    public void initBiome() {
        register(NormalGenerator.DESERT, this);
    }
}
