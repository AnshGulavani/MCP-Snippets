import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public abstract class Config {

    protected final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    protected final File file;

    public Config(String fileLocation){
        file = new File("YourClientName" + File.separator + fileLocation);
    }

    public abstract void save();

    public abstract void load();
}