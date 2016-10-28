package BiomeMaster;

import BiomeMaster.biome.*;
import BiomeMaster.generator.NormalGenerator;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class BiomeMaster extends PluginBase {

    private EventListener listener = new EventListener();

    @Override
    public void onLoad() {
        registerGenerator();
        this.getLogger().info(TextFormat.WHITE + "BiomeMaster loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "Biome master enabled!");
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "BiomeMaster disabled!");
    }

    public void registerGenerator() {
        new SavannaBiome().initBiome();
        new JungleBiome().initBiome();
        new RoofedForestMBiome().initBiome();
        new RoofedForestBiome().initBiome();
        new MushroomIsland().initBiome();
        new SwamplandBiome().initBiome();
        
        new BeachBiome().initBiome();
        new DesertBiome().initBiome();
        new ForestBiome().initBiome();
        new IcePlainsBiome().initBiome();
        new OceanBiome().initBiome();
        new PlainBiome().initBiome();
        new RiverBiome().initBiome();
        new TaigaBiome().initBiome();

        Generator.addGenerator(NormalGenerator.class, "normal", Generator.TYPE_INFINITE);
    }
}
