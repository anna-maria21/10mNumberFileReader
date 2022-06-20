import java.io.*;
import java.util.Scanner;

public class WorkWithFile {

    public static void openFile(String path) {
        File file = new File(path);
        try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                fr.close();
                br.close();

        } catch (IOException e) {
            System.out.println("File not found in specified path!");
        }
    }

    public static void readFile(String path) {
        int max = 0, min = 0;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader, 200);
            String line;
            while((line = bufferedReader.readLine())!= null) {
                int intLine = Integer.parseInt(line);
//                System.out.println(intLine);
                if (intLine > max) {
                    max = intLine;
                }
                if (intLine < min) {
                    min = intLine;
                }
            }
            System.out.println(min + ' ' + max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
