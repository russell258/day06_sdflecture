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

        // Consumer<String> c = (String v) -> {
        //     System.out.printf("v = %s\n", v);
        // };

        //from the stream of strings, map them to Integer and filter for <0, then print forEach of them.
        numList.stream()
            .map((String c) -> Integer.parseInt(c))
            .filter((Integer c) -> (c<0))
            .forEach((Integer c) -> {
                System.out.printf("c = %d\n", c);
            }); 
        
        // from the stream of strings, map them into integer and filter for <0, then make them into a list.
        List<Integer> intList = numList.stream()
            .map((String v) -> Integer.parseInt(v))
            .filter((Integer v) -> (v<0))
            .toList();

        System.out.println("intList: " + intList);

        //from the number stream, map each string into an int
        // then filter for those that are <0
        // reduce gives identity as 0 (usually initiate i=0), then use the operator SUM, with integer i.
        // sum + i so just add all the streams coming in.
        int total = numList.stream()
            .map ((String v) -> Integer.parseInt(v))
            .filter ((Integer v) -> (v<0))
            .reduce(0, (Integer sum, Integer i) -> sum+i);

            System.out.println("total: "+total);

    }
}
