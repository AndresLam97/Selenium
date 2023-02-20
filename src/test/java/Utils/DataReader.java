package Utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataReader {

    public static <T> T readDataFromJSONFile(String fileLocation, Class<T> className)
    {
        try {
            T data = null;
            Gson gson = new Gson();
            Path jsonFile = Paths.get(System.getProperty("user.dir").concat(fileLocation));
            Reader fileReader = Files.newBufferedReader(jsonFile);
            data = gson.fromJson(fileReader,className);
            return data;
        }catch(Exception ex)
        {
            System.out.println(System.getProperty("user.dir").concat(fileLocation));
            throw new IllegalArgumentException("[ERR] The json file is invalid, please add a new file !!!");
        }
    }

    public static void readDataFromXLXSFile()
    {

    }

}
