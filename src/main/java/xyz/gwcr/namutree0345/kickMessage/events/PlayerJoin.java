package xyz.gwcr.namutree0345.kickMessage.events;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import xyz.gwcr.namutree0345.kickMessage.Main;

import java.util.HashMap;

public class PlayerJoin implements Listener {

    ProxyServer server;

    public PlayerJoin(ProxyServer server) {
        this.server = server;
    }

    @EventHandler
    public void PostLogin(PostLoginEvent event) {
            event.getPlayer().connect(server.getServerInfo("lobby"), new Callback<Boolean>() {
                @Override
                public void done(Boolean aBoolean, Throwable throwable) {
                    if(throwable != null) {
                        System.out.println("[INFO] Caught error");
                        if(Main.message == null) {
                            event.getPlayer().disconnect(new TextComponent("첫번째줄\n두번째줄"));
                        } else {
                            event.getPlayer().disconnect(new TextComponent(Main.message));
                        }
                    }
                }
            });
        
    }

}
