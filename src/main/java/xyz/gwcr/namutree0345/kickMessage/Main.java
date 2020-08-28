package xyz.gwcr.namutree0345.kickMessage;

import net.md_5.bungee.api.plugin.Plugin;
import xyz.gwcr.namutree0345.kickMessage.events.PlayerJoin;

public class Main extends Plugin {
    @Override
    public void onEnable() {
        getProxy().getServerInfo("Server");
        getProxy().getPluginManager().registerListener(this, new PlayerJoin(getProxy()));
        getLogger().info("KickMessage is enabled");
    }
}
