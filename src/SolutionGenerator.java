import java.util.ArrayList;

public class SolutionGenerator {
    private ArrayList<Problem> problemsArrayList = new ArrayList<>();
    private ArrayList<String[]> contentArray;
    private int numberOfProblems;
    private double [] h;
    private double [] solutions;
    private int k;

    public SolutionGenerator(double[] h,int k, String fileName){
        this.h = h;
        this.k = k;
        FileReader fileReader = new FileReader();
        contentArray = fileReader.readFile(fileName);
        setNumberOfProblems();
        solutions = new double[h.length];
        for(int i=0;i<solutions.length;i++){
            solutions[i]=Double.MAX_VALUE;
        }
    }

    public void readProblems(){
        for(int i=0;i<numberOfProblems;i++){
            ArrayList<String[]> arrayListPerProblem = new ArrayList<>();
            Problem problem = new Problem(Integer.parseInt(contentArray.get(0)[0]));
            contentArray.remove(0);
            for(int j=0;j<problem.getNumberOfTask();j++){
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
        System.out.println("Number of problems " + numberOfProblems);
    }

    public void resolveProblems(){
        int x=0;
        while (x!=100000){
            for(int i=0;i<h.length;i++){
                ArrayList<Task> solutionArray = problemsArrayList.get(k).scheduleTasksRandom();
                double solution = problemsArrayList.get(k).resolve(h[i]);

                if(solutions[i]>solution){
                    solutions[i]=solution;
                    problemsArrayList.get(k).setTaskArrayList(solutionArray);
                    }
            }
            x++;
        }
        for(int i=0;i<h.length;i++){
            System.out.println(solutions[i]);
        }
    }

}
