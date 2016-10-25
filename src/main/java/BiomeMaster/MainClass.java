package BiomeMaster;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.level.generator.biome.Biome;

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
        } else {
            if (temperature < 0.25) {
                return Biome.MOUNTAINS;
            } else {
                return Biome.SMALL_MOUNTAINS;
            }
        }
    }
}
