//Note- Class must extend GuiScreen

@Override
public void initGui() {
	ScaledResolution sr = new ScaledResolution(mc);
	this.customButtonList.add(new CustomButton("close", sr.getScaledWidth() - 20, 7, 15, 15, "X", new Color(255,255,255,255), new Color(200,200,200,100), new Color(255,255,255,255), new Color(255,77,77,255)));
}

@Override
protected void actionPerformed(CustomButton button) throws IOException {
	if(button.function == "close") {
		mc.shutdown();
	}
	super.actionPerformed(button);
}