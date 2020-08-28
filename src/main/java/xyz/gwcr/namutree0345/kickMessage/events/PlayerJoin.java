package xyz.gwcr.namutree0345.kickMessage.events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.HashMap;

public class PlayerJoin implements Listener {

    ProxyServer server;
    HashMap<ProxiedPlayer, Boolean> isCrashed = new HashMap<ProxiedPlayer, Boolean>();

    public PlayerJoin(ProxyServer server) {
        this.server = server;
    }

    @EventHandler
    public void PostLogin(PostLoginEvent event) {
        try {
            event.getPlayer().connect(server.getServerInfo("lobby"));
            isCrashed.put(event.getPlayer(), true);
            System.out.println("[INFO] Connect to lobby");
        } catch(Exception ex) {
            System.out.println("[INFO] Caught error");
            event.getPlayer().disconnect(new TextComponent("첫번째줄\n두번째줄"));
        }
        
    }

    public void Disconected(PlayerDisconnectEvent event) {

    }

    public void Connected(ServerConnectedEvent event) {
        if(isCrashed.containsKey(event.getPlayer())) {
            isCrashed.remove(event.getPlayer());
            event.getPlayer().disconnect(new TextComponent("1째줄\n2째줄\n"));
        }
    }

}
