package CompareGrids;

import java.io.IOException;
/**
 * Created by praveendadu on 14/07/2017.
 */
public class CompareSingledayGrid {
    static int  countQuarters = 0;
    static String Gridvalues;
    static int TotalQuarters;
    static String ProgramnAverages;
    static String Dataval;
    static String Hutvalues;
    static String ActualProgramval;
    static String ActualData ;
    static String ActHut;
    static String MyJson;
    public static void main (String[] Args)
    {
        String ContentType = "application/raw";
        //MyJson = CreateJson.createJsonstructure();
        MyJson = "{\n" +
                "  \"grid\": [\n" +
                "    {\n" +
                "      \"streamId\": \"4\",\n" +
                "      \"marketId\": \"67\",\n" +
                "      \"date\": [\n" +
                "        \"2017-02-07\",\n" +
                "        \"2017-02-08\",\n" +
                "        \"2017-02-09\"\n" +
                "      ],\n" +
                "      \"demoId\": \"143\",\n" +
                "      \"currencyId\": \"7\",\n" +
                "      \"stationId\": \"236\",\n" +
                "      \"dayStartTime\": \"03:00AM\",\n" +
                "      \"returnHut\": true,\n" +
                "      \"returnIntab\": true,\n" +
                "      \"averageType\": \"AVERAGE_DOMINANT_PROGRAM\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"dayparts\": []\n" +
                "}";
        String Authurl = "http://10.10.87.67:8888/api/grid";
        try {
            String resultString = TestGrdiresponse.JsonResponse(MyJson, Authurl, ContentType);
          //String requiredString = resultString.substring(resultString.indexOf("programs") + 9, resultString.indexOf("dayparts"));
            Hutvalues = resultString.substring(resultString.indexOf("huts") + 7, resultString.indexOf("intab") - 3);
            Hutvalues = CalculateGridvalues.changeDecimalvalues(Hutvalues);
          TotalQuarters =   CalculateGridvalues.getTotalquarters(resultString);
          ProgramnAverages = CalculateGridvalues.getprognametotaquarters(resultString);
          Dataval = CalculateGridvalues.getData(resultString);
          ActualProgramval = ReadExcelvalues.returnvalues("programnamenAverage");
            ActualData = ReadExcelvalues.returnvalues("Data");
            ActHut = ReadExcelvalues.returnvalues("Hut");
           // System.out.println(ActHut);
            //System.out.println(ActualData);
           CalculateGridvalues.compareValues(ProgramnAverages, ActualProgramval, "programnamenAverage");
           CalculateGridvalues.compareValues(Dataval, ActualData, "data");
          CalculateGridvalues.compareValues(Hutvalues, ActHut, "hut");
            } catch ( Exception e1) {
            e1.printStackTrace();
        }
    }
    }

