package cert.java.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Test {
    static List<String> colorList = new ArrayList<>();
    static List<String> fixedLengthColorList = Arrays.asList("blue", "green", "yellow", "white", "black", "brown");
    static List<String> unmodifiableColorList = List.of("purple", "pink", "mustard", "orange", "gray", "silver");
    static List<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) {

        Test.unmodifiableColorList.stream().forEach(colorList::add);
        Test.colorList.stream().forEach(c -> System.out.println(c));

        try{
            Test.colorList.stream().forEach(color -> {
                System.out.println("WIll Start " + color );
                Lateral lateral = new Lateral(color);
                Thread aThread = new Thread(lateral);
                Thread anotherThread = new Thread(lateral);
                threadList.add(aThread);
                threadList.add(anotherThread);
                //System.out.println("Should reach without problem " + color );
                //Test.colorList.remove(color);
                //System.out.println("Never Reached " + color );
            });
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }

        colorList.clear();

        //Test.fixedLengthColorList.stream().forEach(colorList::add);

        //Test.colorList.stream().forEach(c -> System.out.println(c));

//        System.out.println("Next Round!!!!!!!!!");
//        Iterator iterator = Test.colorList.iterator();
//        while (iterator.hasNext()) {
//            String color =  (String)iterator.next();
//            iterator.remove();
//            Thread aThread = new Thread(new Lateral(color));
//            threadList.add(aThread);
//        }

        Test.colorList.stream().forEach(c -> System.out.println(c));
        threadList.stream().forEach(t -> t.start());
        threadList.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Long timeOn = Long.valueOf(0L);
        Long[] timeArray = new Long[] {timeOn};
        final List<Long[]> timeList = new ArrayList<>();
        timeList.add(timeArray);
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(timeList.get(0)[0] < 400 ){
                long start = System.nanoTime();
                System.out.println("Interrupting threads  ..... ");
                threadList.stream().forEach(t -> t.interrupt());
                threadList.stream().forEach(t -> System.out.println(t.getState()));
                try {
                    long end = System.nanoTime();
                    timeList.get(0)[0] = timeList.get(0)[0] + (end - start) / 100000L;
                    System.out.println(" Start " + start + "  .. End " + end + " .. End - Start: " + (end - start));
                    System.out.println("Time elapsed " + timeList.get(0)[0] );
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                   // e.printStackTrace();
                }
            }
        };

        Thread blocker = new Thread(r);
        blocker.start();
        try {
            blocker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
