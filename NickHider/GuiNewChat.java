/*
Locate GuiNewChat.java and replace the method "printChatMessageWithOptionalDeletion" with the following
*/

public void printChatMessageWithOptionalDeletion(IChatComponent p_146234_1_, int p_146234_2_)
{
    IChatComponent message = p_146234_1_;
    if(Eclipse.getInstance().moduleManager.nickHider.isEnabled() && message.getFormattedText().contains(mc.thePlayer.getNameClear())) {
    	String msg = message.getFormattedText().replaceAll(mc.thePlayer.getNameClear(), Eclipse.getInstance().moduleManager.nickHider.getPlayerName());
    	message = new ChatComponentText(msg);
    }
    this.setChatLine(message, p_146234_2_, this.mc.ingameGUI.getUpdateCounter(), false);
    logger.info("[CHAT] " + message.getUnformattedText());
}
