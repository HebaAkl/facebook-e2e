package data;

import com.google.gson.JsonObject;


public class GetTestData {

    JsonDataReader jsonDataReader;
    JsonObject testData;

    public String getTestingData(String nodeName, String dataKey) {
        jsonDataReader = new JsonDataReader();
        testData = new JsonObject();
        jsonDataReader.ReadJsonFile(nodeName);
        testData = jsonDataReader.getTargetedNode();
        String subDomainName = String.valueOf(testData.get(dataKey));

        return (subDomainName.replace("\"", ""));
    }

}