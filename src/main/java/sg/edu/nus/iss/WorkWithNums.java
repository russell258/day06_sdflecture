package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WorkWithNums {
    
    public static void main(String[] args) throws IOException{
        
        List<Integer> numList = new LinkedList<>();

        //read the numbers into numList
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        String line = ""; 

        // can also write while (null!= (line=br.readLine())){}

        int sum = 0;

        while (null!=(line=br.readLine())){
            int i = Integer.parseInt(line);

            if (i<0){
                numList.add(i);
                sum+=i;
            }
        }
        System.out.println(sum);
        br.close();
        fr.close();

    }
}
