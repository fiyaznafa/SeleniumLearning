package Utils;

import com.jayway.jsonpath.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CustomTestDataReader {

    static final Logger log = LogManager.getLogger(CustomTestDataReader.class);
    private static String resourcePath;


    private static String getResourcePath() {
        setResourcePath();
        return resourcePath;
    }

    private static void setResourcePath() {
        CustomTestDataReader.resourcePath = System.getProperty("user.dir")+"/src/main/resources";
    }

    private static String getTestDataPath(){
        String filepath=null;
        filepath=getResourcePath()+ File.separator+"TestData";
        return  filepath;
    }

    public static JSONObject getTesData(String category,String TestId){
        String filepath =getTestDataPath();
        String env = getEnvToRun("ENV","FIN");
        log.info("File path: "+filepath);
        log.info("ENV: "+env);
        JSONObject obj=null;
        String regexWithEnv="$.."+category+"."+env+"[?(@.Id =~ /.*"+TestId+"/i)]";
        String regexWithOutEnv="$.."+category+"..[?(@.Id =~ /.*"+TestId+"/i)]";
        try {
            obj= getJSONObject(filepath,regexWithEnv);
            if(obj==null)obj= getJSONObject(filepath,regexWithOutEnv);
        }
        catch (Exception e){
            log.error("Exception in test data or file"+e);
        }
        return obj;
    }

    private static JSONObject getJSONObject(String filepath, String regex) {
        List<File> files = getAllFiles(filepath);
        JSONObject obj=null;
        try {
            for (File jsonFile:files) {
                if(jsonFile.getName().contains(".json")){
                    log.info("Reading File: "+jsonFile);
                    Object jsonObject = JsonPath.read(jsonFile, regex);
                    JSONArray jsonArray=new JSONArray(jsonObject.toString());
                    if(jsonArray.length()!=0){
                        obj= (JSONObject) jsonArray.get(0);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    private static List<File> getAllFiles(String directoryPath) {
        List<File> files = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] fList = directory.listFiles();
        for (File file:fList) {
            if(file.isFile())files.add(file);
            else if(file.isDirectory())files.addAll(getAllFiles(file.getAbsolutePath()));
        }
        return files;
    }

    private static String getEnvToRun(String varName, String defaultValue) {
        String env=System.getenv(varName);
        if(env==null)return defaultValue;
        return env;
    }


}
