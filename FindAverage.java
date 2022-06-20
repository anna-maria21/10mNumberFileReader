import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindAverage implements Runnable {

    LineNumberReader lineNumberReader = null;
    FileReader fileReader = null;
    private float average = 0;
    private long size = 0;

    public float getAverage() {
        return average;
    }

    public long getSize() {
        return size;
    }

    public FindAverage(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        lineNumberReader = new LineNumberReader(fileReader);
    }

    synchronized void read() throws IOException {
        Thread curThread = Thread.currentThread();
        String str = "";
        long sum = 0;
        while ((str = lineNumberReader.readLine()) != null) {
            sum += Long.parseLong(str);
            this.size += 1;
        }
        this.average = (float) sum / size;
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
