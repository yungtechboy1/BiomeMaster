package BiomeMaster;

import cn.nukkit.level.generator.biome.Biome;

import BiomeMaster.biomes.generation.OceanBiome;
import BiomeMaster.biomes.generation.PlainBiome;
import BiomeMaster.biomes.generation.DesertBiome;
import BiomeMaster.biomes.generation.ForestBiome;
import BiomeMaster.biomes.generation.TaigaBiome;
import BiomeMaster.biomes.generation.SwampBiome;
import BiomeMaster.biomes.generation.RiverBiome;
import BiomeMaster.biomes.generation.IcePlainsBiome;
import BiomeMaster.biomes.generation.BeachBiome;

/**
 * author: MagicDroidX
 * Nukkit Project
 * Modificated by BiomeMaster-Devs
 */
public abstract class Biomes {


    public static final int OCEAN = 0;
    public static final int PLAINS = 1;
    public static final int DESERT = 2;
    public static final int FOREST = 4;
    public static final int TAIGA = 5;
    public static final int SWAMP = 6;
    public static final int RIVER = 7;
    public static final int ICE_PLAINS = 12;
    public static final int BEACH = 16;
    public static final int BIRCH_FOREST = 27;

    public static final int MAX_BIOMES = 256;

    public static void init() {
        register(OCEAN, new OceanBiome());
        register(PLAINS, new PlainBiome());
        register(DESERT, new DesertBiome());
        register(FOREST, new ForestBiome());
        register(TAIGA, new TaigaBiome());
        register(SWAMP, new SwampBiome());
        register(RIVER, new RiverBiome());
        register(ICE_PLAINS, new IcePlainsBiome());
        register(BIRCH_FOREST, new ForestBiome(ForestBiome.TYPE_BIRCH));
        register(BEACH, new BeachBiome());
    }
}
