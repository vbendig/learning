package cert.java.threads;

import java.util.UUID;

public class Lateral implements Runnable{
    public UUID uuid = UUID.randomUUID();
    public String color = "";

    Lateral(String color){
        this.color = color;
    }

    public static void doWork(Lateral curr){
        Thread ct = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            while(ct.isInterrupted()) {
                System.out.println("Color " + curr.color + "  #" + i + " - I am Interrupted! " + curr.uuid.toString());
                return;
            }
            System.out.println("Color " + curr.color + "  #" + i + " - I am running! " + curr.uuid.toString());
            int sleepInterval = (int) (Math.random() * 100);
            if (i == 99 ) {
                System.out.println("\n\n\n\n DONEEEEEEE COLOR " + curr.color.toUpperCase() + "\n\n\n\n\n");
            }
            try {
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void doNonSyncWork(Lateral curr){
        Thread ct = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println("Color " + curr.color + "  #" + i + " - I am NON SYNC  running! " + curr.uuid.toString());
            int sleepInterval = (int) (Math.random() * 100);
            if (i == 99 ) {
                System.out.println("\n\n\n\n DONEEEEEEE  NON SYNC  COLOR " + curr.color.toUpperCase() + "\n\n\n\n\n");
            }
            try {
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public void run() {
        doNonSyncWork(this);
        synchronized (Lateral.class) {
            doWork(this);
        }
    }
}
