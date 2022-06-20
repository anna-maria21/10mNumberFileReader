import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = args[0];
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File not found in specified path!");
            System.exit(1);
        }
        try {
            FindMin findMin = new FindMin(path);
            FindMax findMax = new FindMax(path);
            FindAverage findAverage = new FindAverage(path);
            FindMedian findMedian = new FindMedian(path);
            Thread t1 = new Thread(findMin);
            Thread t2 = new Thread(findMax);
            Thread t3 = new Thread(findAverage);
            Thread t4 = new Thread(findMedian);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println("Minimum is: " + findMin.getMin());
            System.out.println("Maximum is: " + findMax.getMax());
            System.out.println("Average is: " + findAverage.getAverage());
            System.out.println("Median is: " + findMedian.getMedian());

        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
