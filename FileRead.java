import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileRead implements Runnable {
    LineNumberReader lineNumberReader = null;
    FileReader fileReader = null;

    public FileRead(String path) throws FileNotFoundException {
        fileReader = new FileReader(path);
        lineNumberReader = new LineNumberReader(fileReader);
    }

    synchronized void read() throws IOException {
        Thread curThread = Thread.currentThread();
        String str = "";
        while ((str = lineNumberReader.readLine()) != null) {
            System.out.println(curThread.getName() + " " + str);
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
