package cert.java.threads;

public class DeadLock {
    static String syncAStr = "I am syncA";
    static String syncBStr = "I am syncB";

    public static void syncA(){
        try {
            Thread.sleep(3000);
            System.out.println(syncAStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void syncB(){
        try {
            Thread.sleep(3000);
            System.out.println(syncBStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RunnableClass rc = new RunnableClass();
        RunnableClass1 rc1 = new RunnableClass1();

        Thread t1 = new Thread(rc);
        Thread t2 = new Thread(rc1);

        t1.start();
        t2. start();

        Runnable r = () -> {
            boolean keepGoing = true;
            while(keepGoing){
                System.out.println("T1 state: " + t1.getState());
                System.out.println("T2 state: " + t2.getState());
                keepGoing = (Thread.State.TERMINATED.equals(t1.getState())
                        && Thread.State.TERMINATED.equals(t2.getState()))? false : true;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3 = new Thread(r);
        t3.start();
    }

    static class RunnableClass implements Runnable{

        @Override
        public void run() {
            synchronized(DeadLock.syncAStr){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLock.syncBStr){
                    DeadLock.syncA();
                    DeadLock.syncB();
                }
            }
        }
    }

    static class RunnableClass1 implements Runnable{

        @Override
        public void run() {
            synchronized(DeadLock.syncBStr){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLock.syncAStr){
                    DeadLock.syncA();
                    DeadLock.syncB();
                }
            }
        }
    }
}

