package cert.java.threads.volatileexample;

public class Test {
    public static void main(String[] args) {
        Shared shared = new Shared();
        new Thread(() -> {
            while (shared.y < 1){
                System.out.println("running...");
                int x = shared.x;
            }
        }).start();

        System.out.println("Starting t2");
        new Thread(() -> {
            System.out.println("setting values... ");
            shared.x = 2;
            shared.y = 2;
        }).start();

    }
}

class Shared{
    public int y;
    //public volatile int y;
    public int x;
}
