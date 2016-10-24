package BiomeMaster;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.level.generator.biome.Biome;

import cn.nukkit.level.generator.noise.Simplex;
import cn.nukkit.math.NukkitRandom;

import java.util.HashMap;
import java.util.Map;

public class MainClass extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "BiomeMaster loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "Biome master enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "BiomeMaster disabled!");
    }
    
    public int lookup(double temperature, double rainfall) {
        if (rainfall < 0.25) {
            return Biome.SWAMP;
        } else if (rainfall < 0.60) {
            if (temperature < 0.25) {
                return Biome.ICE_PLAINS;
            } else if (temperature < 0.75) {
                return Biome.PLAINS;
            } else {
                return Biome.DESERT;
            }
        } else if (rainfall < 0.80) {
            if (temperature < 0.25) {
                return Biome.TAIGA;
            } else if (temperature < 0.75) {
                return Biome.FOREST;
            } else {
                return Biome.BIRCH_FOREST;
            }
        } else {
            if (temperature < 0.25) {
                return Biome.MOUNTAINS;
            } else {
                return Biome.SMALL_MOUNTAINS;
            }
        }
    }

    public void recalculate() {
        this.map = new int[64 * 64];
        for (int i = 0; i < 64; ++i) {
            for (int j = 0; j < 64; ++j) {
                this.map[i + (j << 6)] = this.lookup(i / 63d, j / 63d);
            }
        }
    }
}
