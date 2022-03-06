public void saveSettings(JsonObject settings){
    settings.addProperty("name", getName().toLowerCase().replaceAll(" ", "-"));
    settings.addProperty("enabled", enabled);
    settings.addProperty("x", getX());
    settings.addProperty("y", getY());
    settings.addProperty("scale", getScale());
}

public void loadSettings(JsonObject settings){
    setEnabled(settings.get("enabled").getAsBoolean());
    setX(settings.get("x").getAsFloat());
    setY(settings.get("y").getAsFloat());
    setScale(settings.get("scale").getAsFloat());
}