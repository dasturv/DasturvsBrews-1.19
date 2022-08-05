package net.dasturv.dasturvbrews.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dasturv.dasturvbrews.DasturvBrews;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class KettleScreen extends HandledScreen<KettleScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(DasturvBrews.MOD_ID, "textures/gui/kettle_gui.png");

    public KettleScreen(KettleScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 83, y + 36, 177, 15, handler.getScaledProgress(), 17);
        }

        if(handler.isOnHeatSource()) {
            drawTexture(matrices, x + 53, y + 56, 176, 0, 17, 15);
        }
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
