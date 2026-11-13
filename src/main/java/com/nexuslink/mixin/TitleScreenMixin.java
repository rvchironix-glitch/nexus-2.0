package com.nexuslink.mixin;

import com.nexuslink.client.ui.NexusDashboardScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void addNexusLinkButton(CallbackInfo ci) {
        TitleScreen screen = (TitleScreen) (Object) this;
        int buttonWidth = 120;
        int buttonHeight = 20;
        int x = this.width / 2 - 100;
        int y = this.height / 4 + 48 + 72 + 12;

        this.addDrawableChild(ButtonWidget.builder(Text.literal("NexusLink Social"), button -> {
            if (this.client != null) {
                this.client.setScreen(new NexusDashboardScreen(screen));
            }
        }).dimensions(x + 104, y, buttonWidth, buttonHeight).build());
    }
}
