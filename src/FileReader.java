import java.io.BufferedReader;
import java.util.ArrayList;

public class FileReader {
   // private String defaultFilePath = "C:/test/";
    public static final String defaultFilePath = "/test/";
    public ArrayList<String []> readFile(String fileName) {
        ArrayList<String[]> contentArray=new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new java.io.FileReader(defaultFilePath+fileName));
                String line;
                while ((line = br.readLine()) !=null){
                    contentArray.add(line.trim().split("\\s+"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentArray;
    }
    public void readResolution(){

    }

}
