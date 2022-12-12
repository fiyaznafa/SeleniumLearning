package com.test.sel;

import Utils.CustomTestDataReader;
import org.json.JSONObject;

public class CheckTestData {

    public static void main(String[] args) {
         JSONObject tesData = CustomTestDataReader.getTesData("Flipkart", "Flipkart1");
        System.out.println(tesData);

       /* JSONObject tesData2 = CustomTestDataReader.getTesData("Amazon.json", "Amazon2");
        System.out.println(tesData2);
*/
    }

}
