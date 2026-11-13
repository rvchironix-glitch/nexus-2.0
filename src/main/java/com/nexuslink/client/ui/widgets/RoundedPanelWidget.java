package com.nexuslink.client.ui.widgets;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.text.Text;

public class RoundedPanelWidget extends ClickableWidget {
    private final int backgroundColor;
    private final int borderColor;
    private final int radius;

    public RoundedPanelWidget(int x, int y, int width, int height, Text message, int bgColor, int borderColor, int radius) {
        super(x, y, width, height, message);
        this.backgroundColor = bgColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        int x1 = this.getX();
        int y1 = this.getY();
        int x2 = x1 + this.width;
        int y2 = y1 + this.height;

        context.fill(x1 + radius, y1, x2 - radius, y2, borderColor);
        context.fill(x1, y1 + radius, x2, y2 - radius, borderColor);
        
        context.fill(x1 + radius, y1 + 1, x2 - radius, y2 - 1, backgroundColor);
        context.fill(x1 + 1, y1 + radius, x2 - 1, y2 - radius, backgroundColor);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
        this.appendDefaultNarrations(builder);
    }
}
