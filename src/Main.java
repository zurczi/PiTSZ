import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Walidator - 1. Obliczenia - 2. Oblicz wszystko 3.");
            int choice = Integer.parseInt(bufferRead.readLine());
            switch (choice) {
                case 1:
                    Verifier verifier = new Verifier();
                    verifier.verifyResolution("");

                    //walidacja
                    break;
                case 2:
                    System.out.println("Podaj h w postaci h1,h2,...hn");
                    String[] h_string = bufferRead.readLine().split(",");
                    double h[] = new double[h_string.length];
                    for (int i = 0; i < h_string.length; i++) {
                        h[i] = Double.parseDouble(h_string[i]);
                    }
                    System.out.println("Podaj nazwe pliku");
                    String fileName = bufferRead.readLine();
                    System.out.println("Podaj numer instancji - k z zakresu (1,10)");
                    int k = Integer.parseInt(bufferRead.readLine())-1;
                    SolutionGenerator solutionGenerator = new SolutionGenerator(h, fileName);
                    solutionGenerator.readProblems();
                    solutionGenerator.resolveProblem(k);
                    break;
                default:
                    System.out.println("Nie rozpoznane polecenie");
                case 3:
                    String [] fileNames = {"sch10.txt","sch20.txt","sch50.txt","sch100.txt","sch200.txt","sch500.txt","sch1000.txt"};
                    double [] hTab = {0.2,0.4,0.6,0.8};
                    for(String file : fileNames) {
                        SolutionGenerator solGenerator = new SolutionGenerator(hTab, file);
                        solGenerator.readProblems();
                        solGenerator.processAllFile();
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
