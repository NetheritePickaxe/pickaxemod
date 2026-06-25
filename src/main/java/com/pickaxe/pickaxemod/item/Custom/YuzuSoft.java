package com.pickaxe.pickaxemod.item.Custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class YuzuSoft extends Item {

    protected static final int[] STEAM_APP_IDS = {
            1144400,
            2458530,
            1277930,
            1829980
    };

    protected static final String OFFICIAL_WEB = "https://www.yuzu-soft.com/";

    public YuzuSoft(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) {
            launchSteamGame();
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void launchSteamGame() {
        for (int appId : STEAM_APP_IDS) {
            try {
                openUri(new URI("steam://rungameid/" + appId));
                return;
            } catch (URISyntaxException ignored) {
            }
        }

        try {
            openUri(new URI("steam://open/store/" + STEAM_APP_IDS[0]));
            return;
        } catch (URISyntaxException ignored) {
        }

        try {
            openUri(new URI(OFFICIAL_WEB));
        } catch (URISyntaxException ignored) {
        }
    }

    private void openUri(URI uri) {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "start", "/b", uri.toASCIIString()).start();
            } else if (os.contains("mac")) {
                new ProcessBuilder("open", uri.toASCIIString()).start();
            } else {
                new ProcessBuilder("xdg-open", uri.toASCIIString()).start();
            }
        } catch (IOException ignored) {
        }
    }
}
