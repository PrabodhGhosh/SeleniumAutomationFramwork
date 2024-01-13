package org.learning.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class JSONDataProvider {

    @DataProvider(name = "dataProvider")

    public static Object[][] dataProvider(Method method) throws IOException, ParseException {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/dataProviders/" + method.getName() + ".json");
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        JSONArray testCases = (JSONArray)jsonParser.parse(reader);
        List<JSONObject> testCaseList = new ArrayList<>();
        for (int i=0;i<testCases.size();i++)
        {
            testCaseList.add((JSONObject)testCases.get(i));
        }

        Object [][] result = new Object[testCaseList.size()][testCaseList.get(0).size()];
        for (int i = 0; i < testCaseList.size(); i++) {
            result[i] = new Object[] { testCaseList.get(i) };
        }
        return result;


    }
}
