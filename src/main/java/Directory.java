import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Directory {

    public static void main(String[] args) throws IOException {

        try {
            List<Subscriberparameters> sublist = new ArrayList<>();
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            while ((str = br.readLine()) != null) {
                String[] list = str.split(";");
                long i = Long.parseLong(list[3].trim());
                sublist.add(new Subscriberparameters(list[0],list[1],list[2],i));



            }
            for (Subscriberparameters item : sublist){
                System.out.println(item.toString());
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}