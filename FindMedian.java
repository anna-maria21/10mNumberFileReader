import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class FindMedian implements Runnable {

    LineNumberReader lineNumberReader = null;
    FileReader fileReader = null;
    private Long median = 0L;

    public Long getMedian() {
        return median;
    }

    public FindMedian(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        lineNumberReader = new LineNumberReader(fileReader);
    }

    synchronized void read() throws IOException {
        Thread curThread = Thread.currentThread();
        String str = "";
        ArrayList<Long> arrayList = new ArrayList<>();
        while ((str = lineNumberReader.readLine()) != null) {
            arrayList.add(Long.parseLong(str));
        }
        Collections.sort(arrayList);
        if (arrayList.size() % 2 == 0) {
            this.median = (arrayList.get(arrayList.size()/2) + arrayList.get(arrayList.size()/2+1)) / 2;
        } else {
            this.median = arrayList.get(arrayList.size()/2+1);
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
