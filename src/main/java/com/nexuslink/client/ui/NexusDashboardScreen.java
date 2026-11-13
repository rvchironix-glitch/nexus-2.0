package com.nexuslink.client.ui;

import com.nexuslink.networking.SessionManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class NexusDashboardScreen extends Screen {
    private final Screen parent;
    private String activeTab = "Friends";

    public NexusDashboardScreen(Screen parent) {
        super(Text.literal("NexusLink Dashboard"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Friends"), b -> { activeTab = "Friends"; this.clearAndInit(); })
                .dimensions(centerX - 180, centerY - 90, 80, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Host World"), b -> { activeTab = "Host"; this.clearAndInit(); })
                .dimensions(centerX - 180, centerY - 65, 80, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Join World"), b -> { activeTab = "Join"; this.clearAndInit(); })
                .dimensions(centerX - 180, centerY - 40, 80, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Cosmetics"), b -> { activeTab = "Cosmetics"; this.clearAndInit(); })
                .dimensions(centerX - 180, centerY - 15, 80, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Settings"), b -> { activeTab = "Settings"; this.clearAndInit(); })
                .dimensions(centerX - 180, centerY + 10, 80, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), b -> {
            if (this.client != null) {
                this.client.setScreen(parent);
            }
        }).dimensions(centerX - 180, centerY + 70, 80, 20).build());

        if (activeTab.equals("Host")) {
            this.addDrawableChild(ButtonWidget.builder(
                    Text.literal(SessionManager.isHosting() ? "Stop Hosting" : "Start Hosting Session"),
                    b -> {
                        if (SessionManager.isHosting()) {
                            SessionManager.stopHosting();
                        } else {
                            SessionManager.startHosting("Singleplayer_World");
                        }
                        this.clearAndInit();
                    }
            ).dimensions(centerX - 80, centerY + 50, 160, 25).build());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int panelX = width / 2 - 200;
        int panelY = height / 2 - 110;
        context.fill(panelX, panelY, panelX + 400, panelY + 220, 0xEE121418);
        context.fill(panelX - 1, panelY - 1, panelX + 401, panelY + 221, 0x338A2BE2);

        context.drawCenteredTextWithShadow(this.textRenderer, this.title, width / 2, panelY + 12, 0xFFFFFFFF);
        context.drawText(this.textRenderer, Text.literal("Section: " + activeTab), panelX + 100, panelY + 30, 0xFF3B82F6, false);

        if (activeTab.equals("Host")) {
            context.drawText(this.textRenderer, Text.literal("Host your active singleplayer world instantly."), panelX + 100, panelY + 60, 0xFFAAAAAA, false);
            context.drawText(this.textRenderer, Text.literal("Status: " + (SessionManager.isHosting() ? "ONLINE (" + SessionManager.getSessionCode() + ")" : "OFFLINE")), panelX + 100, panelY + 80, 0xFF00FF88, false);
        } else if (activeTab.equals("Cosmetics")) {
            context.drawText(this.textRenderer, Text.literal("Custom Capes, Hats & Wings - COMING SOON"), panelX + 100, panelY + 80, 0xFFFF5555, false);
        } else if (activeTab.equals("Friends")) {
            context.drawText(this.textRenderer, Text.literal("No friends online right now."), panelX + 100, panelY + 60, 0xFFAAAAAA, false);
        } else if (activeTab.equals("Join")) {
            context.drawText(this.textRenderer, Text.literal("Enter a session code to join a friend's world."), panelX + 100, panelY + 60, 0xFFAAAAAA, false);
        } else if (activeTab.equals("Settings")) {
            context.drawText(this.textRenderer, Text.literal("NexusLink Client v1.0.0 - Ready"), panelX + 100, panelY + 60, 0xFFAAAAAA, false);
        }

        super.render(context, mouseX, mouseY, delta);
    }
}
