package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class WorkWithNumStream {
    public static void main(String[] args) throws IOException{

        //read the numbers into numList
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        List <String> numList = new LinkedList<>();

        String line = ""; 

        while (null!=(line=br.readLine())){
            numList.add(line);
        }

        System.out.println(numList);
        br.close();
        fr.close();

        Consumer<String> c = (String v) -> {
            System.out.printf("v = %s\n", v);

        };
        numList.stream()
            .map(c -> Integer.parseInt(c))
            .filter((Integer c) -> (c<0))
            .forEach((Integer c) -> {
                System.out.printf("V = %d\n", c);
            }); 
        


    }
}
