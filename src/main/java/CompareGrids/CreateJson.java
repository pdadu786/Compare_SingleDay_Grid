package CompareGrids;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by praveendadu on 16/07/2017.
 */
public class CreateJson {
    static String message;

    public static String createJsonstructure(){
        try {
            JSONObject json = new JSONObject();
            JSONArray grid = new JSONArray();
            JSONObject item = new JSONObject();
            String [] daypartEmpty = {};
            String [] a1 = {Readconfig.returnconfig("a1")};
            if (!Readconfig.returnconfig("dayparts").equals("")){
                String [] dayparts = {Readconfig.returnconfig("dayparts")};
                json.put("dayparts", dayparts);
            }
            else{
                json.put("dayparts", daypartEmpty);
            }
            String [] dayparts = {Readconfig.returnconfig("dayparts")};
            item.put("streamId", Readconfig.returnconfig("streamId"));
            item.put("marketId", Readconfig.returnconfig("marketId"));
            item.put( "date", a1);
            item.put(  "demoId",  Readconfig.returnconfig("demoId"));
            item.put( "currencyId", Readconfig.returnconfig("currencyId"));
            item.put( "stationId", Readconfig.returnconfig("stationId"));
            item.put( "dayStartTime", Readconfig.returnconfig("dayStartTime"));
            if (Readconfig.returnconfig("returnHut").equals("true")){
                item.put("returnHut", true);
            }
           else
            {
                item.put("returnHut", false);
            }
            if (Readconfig.returnconfig("returnIntab").equals("true")){
                item.put("returnIntab", true);
            }
            else
            {
                item.put("returnIntab", false);
            }
            item.put( "averageType", Readconfig.returnconfig("averageType"));
            grid.put(item);
            json.put("grid", grid);

            message = json.toString();
        }catch(Exception e){
            message = "test";
        }
        System.out.print(message);
    return message;
    }
}

/* String MyJson = "{\n" +
                "  \"grid\": [\n" +
                "    {\n" +
                "      \"streamId\": \"4\",\n" +
                "      \"marketId\": \"222\",\n" +
                "      \"date\": [\n" +
                "        \"2017-03-31\"\n" +
                "      ],\n" +
                "      \"demoId\": \"90\",\n" +
                "      \"currencyId\": \"7\",\n" +
                "      \"stationId\": \"202\",\n" +
                "      \"dayStartTime\": \"03:00AM\",\n" +
                "      \"returnHut\": true,\n" +
                "      \"returnIntab\": true,\n" +
                "      \"averageType\": \"NONE\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"dayparts\": []\n" +
                "}";
                */