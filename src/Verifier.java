

import java.io.BufferedReader;
import java.util.ArrayList;

public class Verifier {

    public boolean verifyResolution(String fileName) {
        ArrayList<String[]> contentArray = readResultFile("sch10_1_8.txt");
        double h = Double.parseDouble(contentArray.get(0)[0]) / 10;
        double F = Double.parseDouble(contentArray.get(1)[0]);
        int n = Integer.parseInt(contentArray.get(2)[0]);
        int r = Integer.parseInt(contentArray.get(3)[0]);
        System.out.println(h +" " +F+" "+ n +" "+r);
        ArrayList<Task> taskArrayList = new ArrayList<>();
        for (int i = 4; i < contentArray.size(); i++) {
            Task task = new Task(Integer.parseInt(contentArray.get(i)[0]), Integer.parseInt(contentArray.get(i)[1]), Integer.parseInt(contentArray.get(i)[2]));
            taskArrayList.add(task);
            System.out.println(task);
        }
        Problem problem = new Problem(n);
        problem.setTaskArrayList(taskArrayList);
        double FCheck = problem.countFunction(h, r);
        System.out.println(FCheck);
        if (FCheck == F) {
            System.out.println("OK");
            return true;
        } else {
            System.out.println("Nie poprawne");
            return false;
        }
    }

    public ArrayList<String[]> readResultFile(String fileName) {
        ArrayList<String[]> contentArray = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                contentArray.add(line.trim().split("\t"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contentArray;
    }
}
