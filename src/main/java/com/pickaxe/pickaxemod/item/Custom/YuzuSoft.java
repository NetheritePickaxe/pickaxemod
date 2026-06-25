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

    private static final int STEAM_APP_ID = 1144400;

    public YuzuSoft(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) {
            launchSteamGame(STEAM_APP_ID);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void openUri(URI uri) {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "start", uri.toASCIIString()).start();
            } else if (os.contains("mac")) {
                new ProcessBuilder("open", uri.toASCIIString()).start();
            } else {
                new ProcessBuilder("xdg-open", uri.toASCIIString()).start();
            }
        } catch (IOException ignored) {
        }
    }

    private void launchSteamGame(int appId) {
        String gameUrl = "steam://rungameid/" + appId;
        String storeUrl = "steam://open/store/" + appId;
        String officialWeb = "https://www.yuzu-soft.com/";

        try {
            openUri(new URI(gameUrl));
            return;
        } catch (URISyntaxException e) {
        }
        try {
            openUri(new URI(storeUrl));
            return;
        } catch (URISyntaxException e) {
        }
        try {
            openUri(new URI(officialWeb));
        } catch (URISyntaxException e) {
        }
    }
}
