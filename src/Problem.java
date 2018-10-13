import java.util.ArrayList;

public class Problem {
    private ArrayList<Task> taskArrayList = new ArrayList<>();

    public int getNumberOfTask() {
        return numberOfTask;
    }

    private int numberOfTask;
    public Problem(int numberOfTask){
        this.numberOfTask=numberOfTask;
    }
    public ArrayList<Task> getTaskArrayList(String [] propeties) {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<String[]> taskArrayListString) {
        for(int i=0;i<taskArrayListString.size();i++){
            Task task = new Task(Integer.parseInt(taskArrayListString.get(i)[0]),Integer.parseInt(taskArrayListString.get(i)[1]),Integer.parseInt(taskArrayListString.get(i)[2]));
            taskArrayList.add(task);
        }
        for(Task t:taskArrayList){
            System.out.println(t);
        }
        System.out.println("-----------------------");
    }

}
