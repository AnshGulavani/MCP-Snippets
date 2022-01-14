import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import whirlwind.hud.mod.HudMod;
import java.awt.*;

public class ToggleModSwitch {
	public HudMod m;
	boolean allowDraw;
	Minecraft mc = Minecraft.getMinecraft();
	
	//235, 95
	public ToggleModSwitch(HudMod m) {
		this.m = m;
	}
	boolean allowClick;
	
	public void draw() {
		if(allowDraw) {
			mc.clientFont.drawString("Enabled: ", 235, 95 + 0.2f, -1);
			if(m.isEnabled() && !m.isDisabled()) {
				UIUtils.drawRoundedRect(235 +50, 95, 235 +66, 95 + 8,1, new Color(0,255,0,170).getRGB());
				UIUtils.drawRoundedRect(235 +58, 95 + 1, 235 +64.5f, 95 + 7, 1, -1);
				allowClick = true;
				
			}else if(!m.isEnabled()){
				UIUtils.drawRoundedRect(235 +50, 95, 235 +66, 95 + 8, 1,new Color(255,0,0,170).getRGB());
				UIUtils.drawRoundedRect(235 +51, 95 + 1, 235 +57, 95 + 7, 1, -1);
				allowClick = true;
			}else if(m.isDisabled()) {
				UIUtils.drawRoundedRect(235 +50, 95, 235 +66, 95 + 8, 1,new Color(200,200,200,170).getRGB());
				if(m.isEnabled()) {
					UIUtils.drawRoundedRect(235 +51, 95 + 1, 235 +57, 95 + 7, 1, -1);
				}else {
					UIUtils.drawRoundedRect(235 +51, 95 + 1, 235 +57, 95 + 7, 1, -1);
				}
				allowClick = false;
			}
		}
	}
	
	public void onClick(int mouseX,int mouseY, int button) {
		if(allowClick) {
			if(mouseX >= 285 && mouseX <= 295 && mouseY >= 95 && mouseY <= 100) {
				m.toggle();
			}
		}
	}
	
	public int getX() {
		return 235;
	}
	
	public int getY() {
		return 95;
	}
	
	public HudMod getMod() {
		return this.m;
	}
	
	public void setAllowDraw(boolean allowDraw) {
		this.allowDraw = allowDraw;
	}
	public boolean getAllowDraw() {
		return allowDraw;
	}
}
