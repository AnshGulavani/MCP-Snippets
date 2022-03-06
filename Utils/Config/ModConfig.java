import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.anshg.urban.UrbanClient;
import me.anshg.urban.client.config.Config;
import me.anshg.urban.client.modules.UrbanModule;

import java.io.*;

public class ModConfig extends Config {

    public ModConfig(){
        super("Urban-Modules.json");
    }

    @Override
    public void save() {
        JsonArray modules = new JsonArray();
        for(UrbanModule m : ModuleManager.getModules()){
            JsonObject jsonModule = new JsonObject();
            m.saveSettings(jsonModule);
            modules.add(jsonModule);
        }
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String s = gson.toJson(modules);
        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getPath());
            fw.write(s);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
            JsonArray modules = gson.fromJson(br, JsonArray.class);

            if(!modules.isJsonNull()){
                for(JsonElement je : modules){
                    JsonObject jsonModule = je.getAsJsonObject();
                    for(UrbanModule m : ModuleManager.getModules()){
                        if(jsonModule != null && jsonModule.get("name").getAsString().equals(m.getName().toLowerCase().replaceAll(" ", "-"))) {
                            m.loadSettings(jsonModule);
                        }
                    }
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}