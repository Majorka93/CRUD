import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Directory {

    public static void main(String[] args) throws IOException {

        try {
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\s0w1n\\Desktop\\Subscribers.txt"));

            while ((str = br.readLine()) != null) {
                String[] list = str.split(";");
                long i = Long.parseLong(list[3].trim());
                System.out.println(list[0] + " " + list[1] + " " + list[2] + " " + list[3]);


            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}