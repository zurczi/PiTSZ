import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Podaj h w postaci h1,h2,...hn");
            String [] h_string = bufferRead.readLine().split(",");
            double h[]=new double[h_string.length];
            for(int i=0;i<h_string.length;i++){
                h[i]=Double.parseDouble(h_string[i]);
            }
            System.out.println("Podaj nazwe pliku");
            String fileName =  bufferRead.readLine();
            System.out.println("Podaj numer instancji - k z zakresu (0,9)");
            int k = Integer.parseInt(bufferRead.readLine());
            SolutionGenerator solutionGenerator = new SolutionGenerator(h,k,fileName);
            solutionGenerator.readProblems();
            solutionGenerator.resolveProblems();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
