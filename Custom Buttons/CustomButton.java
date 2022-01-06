package whirlwind.ui.util;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class CustomButton extends Gui{
	
	protected int width;
	protected int height;
	protected int textureWidth;
	protected int textureHeight;
	protected int xPosition;
	protected int yPosition;
	public String function;
	protected ResourceLocation oldImageLocation;
	protected ResourceLocation imageLocation;
	protected ResourceLocation hoverLocation;
	protected String displayString;
	private boolean isImage;
	int hoverColor;
	int bkColor;
	int normalColor;
	int hoverBkColor;
	
	private boolean hovered;

    public CustomButton(String buttonFunction, int x, int y, int widthIn, int heightIn,int textureWidthIn, int textureHeightIn, String location, String hoverLocation)
    {
    	this.displayString = "";
        this.function = buttonFunction;
        this.xPosition = x;
        this.yPosition = y;
        this.width = widthIn;
        this.height = heightIn;
        this.textureWidth = textureWidthIn;
        this.textureHeight = textureHeightIn;
        this.imageLocation = new ResourceLocation(location);
        this.oldImageLocation = new ResourceLocation(location);
        this.hoverLocation = new ResourceLocation(hoverLocation);
        isImage = true;
    }
    
    public CustomButton(String buttonFunction, int x, int y, int widthIn, int heightIn, String buttonString, Color hoverColor, Color bkColor, Color normalColor, Color hoverBkColor)
    {
    	this.oldImageLocation = null;
    	this.imageLocation = null;
    	this.hoverLocation = null;
        this.function = buttonFunction;
        this.xPosition = x;
        this.yPosition = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonString;
        this.hoverColor = hoverColor.getRGB();
        this.bkColor = bkColor.getRGB();
        this.normalColor = normalColor.getRGB();
        this.hoverBkColor = hoverBkColor.getRGB();
        isImage = false;
    }
    
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {

    	FontRenderer fontrenderer = mc.clientFont;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        int i = this.getHoverState(this.hovered);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.blendFunc(770, 771);
    	if(!isImage) {
    		int p = this.bkColor;
    		
    		if(this.hovered) {
    			p = this.hoverBkColor;
    		}
    		RoundedUtils.drawRoundedRect((float)this.xPosition, (float)this.yPosition, (float)this.xPosition + (float)this.width, (float)this.yPosition + (float)this.height, 3.0F, p);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = this.normalColor;
            
            if (this.hovered)
            {
                j = this.hoverColor;
            }
            
            this.drawCenteredString(fontrenderer,displayString, this.xPosition + this.width / 2 + 0.7f, this.yPosition + (this.height - 8) / 2, j);
    	}else if(isImage) {
    		this.mouseDragged(mc, mouseX, mouseY);
    		imageLocation = oldImageLocation;
    		
    		if(this.hovered) {
    			imageLocation = hoverLocation;
    		}
    		mc.getTextureManager().bindTexture(imageLocation);
    		this.drawModalRectWithCustomSizedTexture(this.xPosition, this.yPosition, 0, 0, this.width, this.height, this.textureWidth, this.textureHeight);
    	}
	}
    


    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    protected void mouseDragged(Minecraft mc, int mouseX, int mouseY)
    {
    }

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    public void mouseReleased(int mouseX, int mouseY)
    {
    }

    /**
     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
     * e).
     */
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
        return mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
    }

    /**
     * Whether the mouse cursor is currently over the button.
     */
    public boolean isMouseOver()
    {
        return this.hovered;
    }

    public void drawButtonForegroundLayer(int mouseX, int mouseY)
    {
    }

    public void playPressSound(SoundHandler soundHandlerIn)
    {
        soundHandlerIn.playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
    }

    public int getButtonWidth()
    {
        return this.width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
    
    protected int getHoverState(boolean mouseOver)
    {
        int i = 0;
        if (mouseOver)
        {
            i = 1;
        }

        return i;
    }
}
