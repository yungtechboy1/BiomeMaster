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

    private int[] map = new int[4096];

    public BiomeSelector(NukkitRandom random, Biome fallback) {
        this.fallback = fallback;
        this.temperature = new Simplex(random, 2.0f, 0.125f, 9.765625E-4f);
        this.rainfall = new Simplex(random, 2.0f, 0.125f, 9.765625E-4f);
    }

    public int lookup(double temperature, double rainfall) {
        if (temperature <= 0.8f) {
            if (rainfall <= 0.4f) {
                return NormalGenerator.PLAINS;
            } else if (rainfall <= 0.9f) {
                return NormalGenerator.SWAMP;
            }
        } else if (temperature <= 1.2f) {
            if (rainfall <= 0.9f) {
                return NormalGenerator.JUNGLE;
            } else {
                if (rainfall == 0.0f) {
                    return NormalGenerator.SAVANNA;
                }
            }
        } else if (temperature <= 0.05f) {
            if (rainfall <= 0.8f) {
                return NormalGenerator.TAIGA;
            }
        } else if (temperature <= 0.6f) {
            if (rainfall <= 0.6f) {
                return NormalGenerator.BIRCH_FOREST;
            }
        } else if (temperature <= 0.7f) {
            if (rainfall <= 0.8f) {
                return NormalGenerator.FOREST;
            } else {
                return NormalGenerator.ROOFED_FOREST;
            }
        } else if (temperature <= 0.9f) {
            if (rainfall <= 1.0f) {
                return NormalGenerator.MUSHROOM_ISLAND;
            }
        } else if (temperature <= 0.15f) { // problem ,i'm not sure.
            if (rainfall <= 0.5f) {
                return NormalGenerator.ICE_PLAINS;
            }
        } else if (temperature <= 2.0f) {
            if (rainfall <= 0.0f) {
                return NormalGenerator.DESERT;
            }
        } else {
            if (temperature <= 0.7f) {
                if (rainfall <= 0.8f) {
                    return NormalGenerator.ROOFED_FOREST_M;
                }
            } else {
                if (temperature <= 0.5f) {
                    if (rainfall <= 0.5f) {
                        return NormalGenerator.RIVER;
                    }
                }
            }
        }
    }

    public void recalculate() {
        this.map = new int[4096];
        for(int i = 0; i < 64; ++i) {
            for(int j = 0; j < 64; ++j) {
                this.map[i + (j << 6)] = this.lookup((double)i / 63.0f, (double)j / 63.0f);
            }
        }
    }

    public void addBiome(Biome biome) {
        this.biomes.put(Integer.valueOf(biome.getId()), biome);
    }

    public double getTemperature(double x, double z) {
        return (this.temperature.noise2D(x, z, true) + 1.0f) / 2.0f;
    }

    public double getRainfall(double x, double z) {
        return (this.rainfall.noise2D(x, z, true) + 1.0f) / 2.0f;
    }

    public Biome pickBiome(double x, double z) {
        int temperature = (int)(this.getTemperature(x, z) * 63.0f);
        int rainfall = (int)(this.getRainfall(x, z) * 63.0f);

        //System.out.println("temperature: "+temperature+"     rainfall: "+rainfall);

        int biomeId = this.map[temperature + (rainfall << 6)];
        return this.biomes.containsKey(Integer.valueOf(biomeId))?(Biome)this.biomes.get(Integer.valueOf(biomeId)):this.fallback;
    }
}
