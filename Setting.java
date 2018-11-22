package settings;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Setting {

    private boolean saveCash;
    private boolean time;
    private String pathToCash;
    final String saveFilePath;


    public Setting(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    public boolean getSaveCash() {
        return saveCash;
    }

    public boolean getTime() {
        return time;
    }

    public String getPathToCash() {
        return pathToCash;
    }

    public static String load(String saveFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(saveFilePath));
        String json = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            json = sb.toString();
            System.out.println(json);
        } finally {
            reader.close();
        }
        return json;
    }


    static Setting parseFromJson(String json) {
        return JSON.parseObject(json, Setting.class);
    }

    public static void save(String json, String saveFilePath) throws IOException {
        FileWriter fileWriter = new FileWriter(saveFilePath);
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }

    static String serializeObject(Setting set) {
        String json = JSON.toJSONString(set);

        return json;
    }

    public void setSaveCash(boolean saveCash) {
        this.saveCash = saveCash;
    }

    public void setTime(boolean time) {
        this.time = time;
    }

    public void setPathToCash(String pathToCash) {
        this.pathToCash = pathToCash;
    }

    public void saveSetting(boolean a, boolean b, String c) {
        saveCash = a;
        time = b;
        pathToCash = c;

    }


}
