package cert.java.threads;

public class LiveLock {
    public static void main(String[] args) {
        OneThread oneThread = new OneThread();
        AnotherThread anotherThread = new AnotherThread();
        oneThread.setAnotherThread(anotherThread);
        anotherThread.setOneThread(oneThread);
        Thread t1 = new Thread(oneThread);
        Thread t2 = new Thread(anotherThread);
        t1.start();
        t2.start();
    }
}

class OneThread implements Runnable{
    Boolean isOver = false;
    AnotherThread anotherThread;

    public void setAnotherThread(AnotherThread anotherThread) {
        this.anotherThread = anotherThread;
    }

    @Override
    public void run() {
        while(!this.anotherThread.isOver){
            System.out.println("OneThread is waiting ....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int number = (int) (Math.random() * 10);
            System.out.println(number);
            if ( number == 5){
                isOver = true;
            } else if(number == 2) {
                anotherThread.isOver = true;
            }
        }
    }
}

class AnotherThread implements Runnable{
    Boolean isOver = false;
    OneThread oneThread;

    public void setOneThread(OneThread oneThread){
        this.oneThread = oneThread;
    }

    @Override
    public void run() {
        while(!this.oneThread.isOver){
            System.out.println("AnotherThread is waiting ....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int number = (int) (Math.random() * 10);
            System.out.println(number);
            if ( number == 5){
                isOver = true;
            } else if(number == 2) {
                oneThread.isOver = true;
            }
        }
    }
}
