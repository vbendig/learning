package cert.java.threads;

public class Starvation {
    static String  myString = "This is a String";
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableClass(1));
        Thread t2 = new Thread(new RunnableClass(2));
        Thread t3 = new Thread(new RunnableClass(3));
        Thread t4 = new Thread(new RunnableClass(4));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static synchronized void myMethod(int threadName){
        try {
            System.out.println(" Called by " + threadName);
            Thread.sleep(10_000);
            System.out.println(" Ending Call from " + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunnableClass implements Runnable{
    int id;

    RunnableClass(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Runnable Class1 Starting " + id);
        Starvation.myMethod(id);
        System.out.println("Runnable Class1 Finishing " + id);
    }
}
