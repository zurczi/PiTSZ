import java.util.ArrayList;

public class SolutionGenerator {
    private ArrayList<Problem> problemsArrayList = new ArrayList<>();
    private ArrayList<String[]> contentArray;
    private int numberOfProblems;

    public SolutionGenerator(){
        FileReader fileReader = new FileReader();
        contentArray = fileReader.readFile("sch10.txt");
        setNumberOfProblems();
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
            problem.setTaskArrayList(arrayListPerProblem);
        }
    }

    public void setNumberOfProblems() {
        numberOfProblems = Integer.parseInt(contentArray.get(0)[0]);
        contentArray.remove(0);
        System.out.println("Number of problems " + numberOfProblems);
    }

    public ArrayList<Task> makeTaskArrayList() {
        ArrayList<Task> taskArrayList = new ArrayList<Task>();
        return taskArrayList;
    }
}
