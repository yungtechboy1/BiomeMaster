package BiomeMaster;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

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
}
