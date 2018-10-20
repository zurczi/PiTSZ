public class Task implements Comparable{

    private int p;//czas przetwarzania
    private int a; //kara za wczesniejsze wykonanie
    private int b; //kara za pozneijsze wykonanie

    public Task(int p,int a, int b){
        this.a=a;
        this.b=b;
        this.p=p;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getP(){
        return p;
    }

    public String toString(){
        return "P: "+ getP() + " A: " +getA()+ " B: "+getB();
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.a, ((Task)o).getA());
    }
}
