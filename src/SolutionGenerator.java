import java.io.*;
import java.util.ArrayList;

public class SolutionGenerator {
    private ArrayList<Problem> problemsArrayList = new ArrayList<>();
    private ArrayList<String[]> contentArray;
    private int numberOfProblems;
    private double[] h;

    public SolutionGenerator(double[] h, String fileName) {
        this.h = h;
        FileReader fileReader = new FileReader();
        contentArray = fileReader.readFile(fileName);
        setNumberOfProblems();
    }


    public void readProblems() {
        for (int i = 0; i < numberOfProblems; i++) {
            ArrayList<String[]> arrayListPerProblem = new ArrayList<>();
            Problem problem = new Problem(Integer.parseInt(contentArray.get(0)[0]));
            contentArray.remove(0);
            for (int j = 0; j < problem.getNumberOfTask(); j++) {
                arrayListPerProblem.add(contentArray.get(0));
                contentArray.remove(0);
            }
            problem.makeTaskArrayList(arrayListPerProblem);
            problemsArrayList.add(problem);
        }
    }

    public void setNumberOfProblems() {
        numberOfProblems = Integer.parseInt(contentArray.get(0)[0]);
        contentArray.remove(0);
        // System.out.println("Number of problems " + numberOfProblems);
    }

    public void resolveProblem(int k) {
        double F = 0;
        for (int i = 0; i < h.length; i++) {
            problemsArrayList.get(k).scheduleTasks();
            F = problemsArrayList.get(k).countFunction(h[i], 0);
            printResultToFile(problemsArrayList.get(k).getNumberOfTask(), k, (int) (h[i] * 10), 0, F);
        }
    }

    public void printResultToFile(int n, int k, int h, int r, double F) {
        try (PrintWriter out = new PrintWriter("sch" + n + "_" + (k + 1) + "_" + h + ".txt")) {
            out.println(h);
            out.println(F);
            out.println(n);
            out.println(r);
            for (Task task : problemsArrayList.get(k).getTaskArrayList()) {
                out.println(task.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printGoalFunctionToFile(double goalFunction, boolean next, boolean last) {
        try {
            FileWriter fw = new FileWriter("allResults.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            if (last) {
                out.print("\n\n");
            } else {
                out.print(goalFunction);
               // System.out.print(goalFunction);
                out.print("\t");
                //System.out.print("\t");
                if (next) {
                    out.print("\n");
                  //  System.out.print("\n");
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processAllFile() {
        for (int k = 0; k < numberOfProblems; k++) { //dla kazdego problemu
            problemsArrayList.get(k).scheduleTasks();
            for (int i = 0; i < h.length; i++) { //dla kazdego h
                double F = problemsArrayList.get(k).countFunction(h[i], 0);
                printResultToFile(problemsArrayList.get(k).getNumberOfTask(), k, (int) (h[i] * 10), 0, F);
                if (i == h.length - 1) {
                    printGoalFunctionToFile(F, true, false);
                } else {
                    printGoalFunctionToFile(F, false, false);
                }
            }

            if (k == numberOfProblems - 1) {
                printGoalFunctionToFile(0, false, true);
            }

        }
    }


}
