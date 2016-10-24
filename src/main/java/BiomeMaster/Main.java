package BiomeMaster;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;

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
