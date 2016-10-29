package BiomeMaster.biome.gen;

import BiomeMaster.generator.NormalGenerator;
import BiomeMaster.populator.mushroom.MushroomPopulator;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockDirt;
import cn.nukkit.block.BlockMycelium;
import BiomeMaster.biome.CaveBiome;
import BiomeMaster.biome.NormalBiome;

public class MushroomIsland extends NormalBiome implements CaveBiome {

    public MushroomIsland() {
        this.setGroundCover(new Block[]{new BlockMycelium(), new BlockDirt(), new BlockDirt(), new BlockDirt(), new BlockDirt()});

        MushroomPopulator mushroomPopulator = new MushroomPopulator();
        mushroomPopulator.setBaseAmount(1);

        addPopulator(mushroomPopulator);
        setElevation(60, 70);
        temperature = 0.9;
        rainfall = 1;
    }

    @Override
    public String getName() {
        return "Mushroom Island";
    }

    @Override
    public int getSurfaceBlock() {
        return Block.MYCELIUM;
    }

    @Override
    public int getGroundBlock() {
        return Block.DIRT;
    }

    @Override
    public int getStoneBlock() {
        return Block.STONE;
    }

    public void initBiome() {
        register(NormalGenerator.MUSHROOM_ISLAND, this);
    }
}
