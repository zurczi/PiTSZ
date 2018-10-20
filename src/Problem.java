import java.util.ArrayList;
import java.lang.Math.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Problem {
    private ArrayList<Task> taskArrayList = new ArrayList<>();
    private int SUM_P;
    private int numberOfTask;


    public Problem(int numberOfTask){
        this.numberOfTask=numberOfTask;
        this.SUM_P=0;
    }
    public ArrayList<Task> getTaskArrayList(String [] propeties) {
        return taskArrayList;
    }

    public int getNumberOfTask() {
        return numberOfTask;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList){
        this.taskArrayList = taskArrayList;
    }

    public void makeTaskArrayList(ArrayList<String[]> taskArrayListString) {
        for(int i=0;i<taskArrayListString.size();i++){
            Task task = new Task(Integer.parseInt(taskArrayListString.get(i)[0]),Integer.parseInt(taskArrayListString.get(i)[1]),Integer.parseInt(taskArrayListString.get(i)[2]));
            taskArrayList.add(task);
        }
        countSumP();
    }

    public void countSumP(){
        for(Task t : taskArrayList) {
            SUM_P += t.getP();
        }
    }

    public double resolve(double h){
        int d = (int)(SUM_P * h);
        int time=0;
        //tutaj jakis tam algorytm ale narazie jak leci
        float F=0;
        //obliczenie funkcji celu
        for(Task t: taskArrayList) {
            time += t.getP();
            F += t.getA() * Math.max(d - time, 0) + t.getB() * Math.max(time - d, 0);
        }
        return F;
    }

    public void scheduleTasks(){
        ArrayList<Task> aSmallerThanB = new ArrayList<>();
        ArrayList<Task> aGreaterThanB = new ArrayList<>();
        for(Task task : taskArrayList){
            if(task.getA()>task.getB()){
                aGreaterThanB.add(task);
            }else{
                aSmallerThanB.add(task);
            }
        }
        Collections.sort(aSmallerThanB);
        Collections.sort(aGreaterThanB, new Comparator<Task>(){
            public int compare(Task o1, Task o2){
                return -Integer.compare(o1.getB(),o2.getB());
            }
        });
        taskArrayList.clear();
        taskArrayList.addAll(aSmallerThanB);
        taskArrayList.addAll(aGreaterThanB);
        for(Task task : taskArrayList){
            System.out.println(task.getP() +" "+task.getA()+" "+ task.getB());
        }

    }

    public ArrayList<Task> scheduleTasksRandom(){
        ArrayList<Task> randomSchedule = new ArrayList<>();
        Random generator = new Random();

        for(int i=0; i<numberOfTask; i++) {
            int index = generator.nextInt(taskArrayList.size());
            randomSchedule.add(taskArrayList.get(index));
            taskArrayList.remove(index);
        }
        return randomSchedule;
    }
}
