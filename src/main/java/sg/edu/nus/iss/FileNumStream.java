package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileNumStream {
    
    public static void main(String[] args) throws Exception{

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        int total = br.lines()
            .map((String v) -> Integer.parseInt(v))
            .filter((Integer v)-> (v<0))
            .reduce(0, (Integer sum, Integer v) -> sum + v);

        br.close();
        System.out.println(total);
    }

}
