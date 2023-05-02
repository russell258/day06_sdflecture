package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UniqueWords {
    public static void main(String[] args) throws IOException{
        String[] STOPWORDS = {
            "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be",
            "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could",
            "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from",
            "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll",
            "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll",
            "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more",
            "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
            "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should",
            "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then",
            "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to",
            "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were",
            "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why",
            "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours",
            "yourself", "yourselves"
        };

        // read words into string[] first
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        List <String> wordList = new ArrayList<>();
        List <String> lineArray = new ArrayList<>();
        String[] lineList;
        String line = ""; 
        String wordListString ="";
        String[] wordListArray;

        // replace all punctuations
        while (null!=(line=br.readLine())){
            // lineList = line.toLowerCase().replaceAll("\\p{Punct}","").split(" ");
            lineList = line.toLowerCase().trim().replaceAll(","," ").split(" ");
            lineArray = Arrays.asList(lineList);
            wordList.addAll(lineArray);
        }
        
        // remove stopwords
        for (int j=0; j<STOPWORDS.length; j++){
            if (wordList.contains(STOPWORDS[j])){
                wordList.remove(STOPWORDS[j]);
            }
        }

        // convert back to string and remove punctuation
        // wordList.replaceAll("\\p{Punct}", "");
        wordListString = wordList.toString().replaceAll("\\p{Punct}", " ");
        wordListArray = wordListString.split(" ");

        //create hashmap having integer key of String value

        HashMap<Integer,String> hashmap = new HashMap<Integer,String>();   
        for (int i = 0; i<wordListArray.length; i++){
            hashmap.put(i, wordListArray[i]);
        }

        br.close();
        System.out.print(hashmap.size() +"\n");

        HashSet<String> hashset = new HashSet<>();   
        for (int i = 0; i < wordListArray.length; i++){   
            // check whether the element is present in the hashset or not. If it is not present in the hashset, add in it.
            if(!hashset.contains(wordListArray[i])){
                hashset.add(wordListArray[i]);
            }
        }
        System.out.println(hashset);
        System.out.println(hashset.size());
    }
}
