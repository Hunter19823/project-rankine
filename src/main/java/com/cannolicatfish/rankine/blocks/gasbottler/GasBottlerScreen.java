package com.cannolicatfish.rankine.blocks.gasbottler;

import com.cannolicatfish.rankine.ProjectRankine;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GasBottlerScreen extends ContainerScreen<GasBottlerContainer>{
    private ResourceLocation GUI = new ResourceLocation(ProjectRankine.MODID, "textures/gui/gas_condenser.png");
    public GasBottlerScreen(GasBottlerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(p_230450_1_,relX, relY, 0, 0, this.xSize, this.ySize);

        int l = this.container.getCookProgressScaled(24);
        this.blit(p_230450_1_, this.guiLeft + 74, this.guiTop + 33, 176, 0, l + 1, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
        drawCenteredString(p_230451_1_, Minecraft.getInstance().fontRenderer, "Gas Bottler", 92, 10, 0xffffff);
    }
}