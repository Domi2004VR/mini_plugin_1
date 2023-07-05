import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PluginDiBenvenuto extends JavaPlugin implements Listener {

    private Set <UUID> PrimaEntrata;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Il plugin è stato abilitato!");


        PrimaEntrata = new HashSet<>();
    }

    @Override
    public void onDisable() {
        getLogger().info("Il plugin è stato disabilitato!");
    }

    @EventHandler
    public void Entra(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID UUID = player.getUniqueId();

        if (PrimaEntrata.contains(UUID)) {
            // Giocatore già entrato in precedenza
            String nomeGiocatore = player.getName();
            String messaggioBentornato = ChatColor.AQUA + "Bentornato, " + nomeGiocatore + " su Coral MC!";
            player.sendMessage(messaggioBentornato);
        } else {
            // Prima volta che il giocatore entra
            PrimaEntrata.add(UUID);
            String nomeGiocatore = player.getName();
            String messaggioBenvenuto = ChatColor.AQUA + "Benvenuto, " + nomeGiocatore + " su Coral MC!";
            player.sendMessage(messaggioBenvenuto);
        }
    }
}
