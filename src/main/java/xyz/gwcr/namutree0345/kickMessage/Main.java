package xyz.gwcr.namutree0345.kickMessage;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import xyz.gwcr.namutree0345.kickMessage.events.PlayerJoin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main extends Plugin {

    public static String message = "";
    @Override
    public void onEnable() {
        if(!this.getDataFolder().exists()) getDataFolder().mkdir();

        File file = new File(getDataFolder(), "config.yml");
        try {
            Files.copy(getResourceAsStream("config.yml"), file.toPath());

            Configuration conf = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            message = conf.getString("kick_message");
        } catch (IOException e) {
            e.printStackTrace();
        }

        getProxy().getServerInfo("Server");
        getProxy().getPluginManager().registerListener(this, new PlayerJoin(getProxy()));
        getLogger().info("KickMessage is enabled");
    }
}
