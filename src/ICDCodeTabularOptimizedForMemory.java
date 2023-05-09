import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular {

    Map<String, String> ICDCodeDescriptions;


    public void loadDescriptions(String path) throws FileNotFoundException {
        File file = new File(path);
        if(file.exists()){
            FileInputStream fs = new FileInputStream()

        }

    }

    @Override
    public void getDescription() {

    }
}
