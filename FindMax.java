import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindMax implements Runnable {
    LineNumberReader lineNumberReader = null;
    FileReader fileReader = null;
    private long max = Long.MIN_VALUE;

    public long getMax() {
        return max;
    }

    public FindMax(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        lineNumberReader = new LineNumberReader(fileReader);
    }

    synchronized void read() throws IOException {
        Thread curThread = Thread.currentThread();
        String str = "";
        while ((str = lineNumberReader.readLine()) != null) {
//            System.out.println(curThread.getName() + " " + str);
            long longVal = Long.parseLong(str);
            if (longVal > max) max = longVal;
        }
    }

    @Override
    public void run() {
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
