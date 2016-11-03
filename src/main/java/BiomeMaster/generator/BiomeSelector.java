package BiomeMaster.generator;

import cn.nukkit.level.generator.biome.Biome;
import cn.nukkit.level.generator.noise.Simplex;
import cn.nukkit.math.NukkitRandom;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CreeperFace on 26. 10. 2016.
 */
public class BiomeSelector {
    private final Biome fallback;
    private final Simplex temperature;
    private final Simplex rainfall;

    private final Map<Integer, Biome> biomes = new HashMap<>();

    private int[] map = new int[64 * 64];

    public BiomeSelector(NukkitRandom random, Biome fallback) {
        this.fallback = fallback;
        this.temperature = new Simplex(random, 2F, 1F / 8F, 1F / 1024F);
        this.rainfall = new Simplex(random, 2F, 1F / 8F, 1F / 1024F);
    }

    public int lookup(double temperature, double rainfall) {
        if (rainfall < 0.25) {
            if (temperature < 0.9) {
                return NormalGenerator.SWAMP;
            } else {
                return NormalGenerator.SAVANNA;
            }
        } else if (rainfall < 0.60) {
            if (temperature < 0.25) {
                return NormalGenerator.ICE_PLAINS;
            } else if (temperature < 0.75) {
                return NormalGenerator.PLAINS;
            } else {
                return NormalGenerator.DESERT;
            }
        } else if (temperature < 0.9) {
            if (rainfall < 1.0) {
                return NormalGenerator.MUSHROOM_ISLAND;
            }
        } else if (rainfall < 0.80) {
            if (temperature < 0.25) {
                return NormalGenerator.TAIGA;
            } else if (temperature < 0.75) {
                return NormalGenerator.FOREST;
            } else {
                return NormalGenerator.BIRCH_FOREST;
            }
        } else {
            if (temperature < 0.25) {
                return Biome.MOUNTAINS;
            } else if (temperature < 0.5) {
                return NormalGenerator.ROOFED_FOREST_M;
            } else if (temperature < 0.8) {
                return NormalGenerator.ROOFED_FOREST;
            } else if (temperature < 1.3) {
                return NormalGenerator.JUNGLE;
            } else {
                return Biome.SMALL_MOUNTAINS;
            }
        }
    }
    
    public void recalculate() {
        this.map = new int[64 * 64];
        for(int i = 0; i < 64; ++i) {
            for(int j = 0; j < 64; ++j) {
                this.map[i + (j << 6)] = this.lookup(i / 63d, j / 63d);
            }
        }
    }

    public void addBiome(Biome biome) {
        this.biomes.put(Integer.valueOf(biome.getId()), biome);
    }

    public double getTemperature(double x, double z) {
        return (this.temperature.noise2D(x, z, true) + 1) / 2;
    }

    public double getRainfall(double x, double z) {
        return (this.rainfall.noise2D(x, z, true) + 1) / 2;
    }

    public Biome pickBiome(double x, double z) {
        int temperature = (int) (this.getTemperature(x, z) * 63);
        int rainfall = (int) (this.getRainfall(x, z) * 63);
        
        //System.out.println("temperature: "+temperature+"     rainfall: "+rainfall);

        int biomeId = this.map[temperature + (rainfall << 6)];
        return this.biomes.containsKey(biomeId) ? this.biomes.get(biomeId) : this.fallback;
    }
}
