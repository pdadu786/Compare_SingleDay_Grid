package CompareGrids;
//import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by praveendadu on 14/07/2017.
 */
public class CalculateGridvalues {
    private static DecimalFormat df2 ;
    static int Totalquarters = 0 ;
    static String  returnPrognametotquart ;
    static String title ;
    static String programAvg ;
    static String data;
    static String returnData;
    static String Hut;
    static String programAvg1;
    public static int getTotalquarters(String Gridresponse) {
        String requiredString = Gridresponse.substring(Gridresponse.indexOf("programs") + 8, Gridresponse.indexOf("dayparts"));
        String[] str = requiredString.split("\\{");
        for (String str1 : str) {
            if (str1.contains("data")) {
                //System.out.println(str1);
                String strdata = str1.substring(str1.indexOf("data") + 6, str1.indexOf("tag") - 2);
                String[] totalQuartercount = strdata.split(",");
                Totalquarters = Totalquarters + totalQuartercount.length;
            }
        }
        return Totalquarters/3;
    }

    public static String getprognametotaquarters(String Gridresponse){
        String requiredString = Gridresponse.substring(Gridresponse.indexOf("programs") + 8, Gridresponse.indexOf("dayparts"));
        String[] str = requiredString.split("\\{");
        returnPrognametotquart = "";
        for (String str1 : str) {

            if (str1.contains("title")) {
                //System.out.println(str1);
                title = str1.substring(str1.indexOf("title") + 8, str1.indexOf("subtitle") - 3);
                //System.out.println(title);
                if(returnPrognametotquart == ""){
                    returnPrognametotquart = title ;
                }
                else
                { returnPrognametotquart = returnPrognametotquart + "," + title ;
                }
            }
            if (str1.contains("programAvg")) {
                //System.out.println(str1);
                programAvg = str1.substring(str1.indexOf("programAvg") + 13, str1.indexOf("data") - 3);
                programAvg = changeDecimalvalues(programAvg);
                returnPrognametotquart = returnPrognametotquart  + "," + programAvg;
            }
        }
        return returnPrognametotquart;
    }

    public static String getData(String Gridresponse){
        String requiredString = Gridresponse.substring(Gridresponse.indexOf("programs") + 8, Gridresponse.indexOf("dayparts"));
        String[] str = requiredString.split("\\{");
        returnData = "";
        for (String str1 : str) {

            if (str1.contains("data")) {
                //System.out.println(str1);
                data = str1.substring(str1.indexOf("data") + 6, str1.indexOf("tag") - 2);
                //System.out.println(title);
                data.replaceAll("\\[", "");
                data.replaceAll("]", "");
                //[[
                if(returnData == ""){
                    returnData = data.trim() ;
                }
                else
                { returnData = returnData + "," + data.trim() ;
                }
            }
        }

        return changeDecimalvalues(returnData.replaceAll("]", "").replaceAll("\\[", ""));
    }


    public static String changeDecimalvalues(String str){
        df2 = new DecimalFormat("#.##");
        String [] str1 = str.split(",");
        int i = 0;
        for(String str2 : str1) {
            Double db = Double.parseDouble(str2);
           // df2.setRoundingMode(RoundingMode.CEILING); //Optional
            df2.setMaximumFractionDigits(2);
            if (i==0) {
                programAvg1 = df2.format(db);
            }
            else
            {
                programAvg1 = programAvg1 + "," + df2.format(db);
            }
            i++;
        }
        return programAvg1 ;
    }

    public static void compareValues(String Expectedval, String Actualval, String CompareValue){

        String [] Splitact = Actualval.split(",");
        String [] Splitexp = Expectedval.split(",");
        if (Splitact.length == Splitexp.length) {
            for (int i = 0; i < Splitact.length -1; i++) {
                String element = Splitact[i].trim();
                String nextElement = Splitexp[i].trim();
                if (CompareValue.equals("programnamenAverage")) {
                    if (i == 0) {
                        if (element.equals(nextElement)) {
                            //System.out.println(element + " and " + nextElement + " are matching");
                        } else {
                            System.out.println(element + " and " + nextElement + " are not matching");
                        }
                    } else if (i % 5 == 0) {
                        if (element.equals(nextElement)) {
                            //System.out.println(element + " and " + nextElement + " are matching");
                        } else {
                            System.out.println(element + " and " + nextElement + " are not matching");
                        }

                    } else {
                        if (Double.parseDouble(element) - Double.parseDouble(nextElement) == 0) {
                            //System.out.println(element + " and " + nextElement + " are matching");
                        } else {
                            System.out.println(element + " and " + nextElement + " are not matching and difference is " + (Double.parseDouble(element) - Double.parseDouble(nextElement)));
                        }

                    }
                }
                else if (CompareValue.equals("data")) {
                        if (Double.parseDouble(element) - Double.parseDouble(nextElement) == 0) {
                            //System.out.println(element + " and " + nextElement + " are matching");
                        } else {
                            System.out.println(element + " and " + nextElement + " are not matching and difference is " + (Double.parseDouble(element) - Double.parseDouble(nextElement)));
                        }


                }
                else if (CompareValue.equals("hut")) {
                    if (Double.parseDouble(element) - Double.parseDouble(nextElement) == 0) {
                       // System.out.println(element + " and " + nextElement + " are matching");
                    } else {
                        System.out.println(element + " and " + nextElement + " are not matching and difference is " + (Double.parseDouble(element) - Double.parseDouble(nextElement)));
                    }


                }


            }
        }
    }

}




