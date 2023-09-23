package data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JsonDataReader {
    public JsonObject targetedNode;

    public JsonDataReader() {
        targetedNode = null;
    }

    public JsonObject getTargetedNode() {
        return targetedNode;
    }

    public void ReadJsonFile(String nodeName) {
        try {
            //JSON parser object to parse read file
            JsonParser jsonParser = new JsonParser();
            String filePath = System.getProperty("user.dir") + "/src/test/java/data/TestData.json";
            File srcFile = new File(filePath);
            FileReader reader = new FileReader(srcFile);

            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JsonArray nodeList = (JsonArray) obj;

            //Iterate over nodeList array
            nodeList.forEach(
                    node -> {
                        if (((JsonObject) node).has(nodeName)) {
                            JsonObject targetedNodeObject = (JsonObject) ((JsonObject) node).get(nodeName);
                            targetedNode = targetedNodeObject;
                        }
                    }
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}