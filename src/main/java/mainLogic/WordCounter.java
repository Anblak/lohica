package mainLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {


    private List<String> allWords = new ArrayList<>();
    private List<String> uniqueWords = new ArrayList<>();
    private Map<String, Integer> resultMap = new TreeMap<>();


    private void takeWords() {
        BufferedReader bufferedReader = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader("lyrics.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";!\n.");
                while (stringTokenizer.hasMoreElements()) {
                    for (String word : stringTokenizer.nextToken().split(" ")) {
                        allWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
                takeSingleWords();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void takeSingleWords() {
        uniqueWords.addAll(allWords
                .stream()
                .distinct()
                .collect(Collectors.toList()));

        Collections.shuffle(uniqueWords);
    }

    public void soutResult(int countWords) {
        takeWords();
        for (String uniqueWord :
                uniqueWords) {
            int numberOfWords = 0;
            for (String word :
                    allWords) {
                if (resultMap.size() < countWords) {
                    if (word.equals(uniqueWord)) {
                        numberOfWords++;
                        if (resultMap.containsKey(word)) {
                            resultMap.replace(word, numberOfWords);
                        } else {
                            resultMap.put(word, numberOfWords);
                        }
                    }
                } else break;
            }

        }

        resultMap.forEach((word, numberOfDuplicates) -> System.out.println(word + " have - " + numberOfDuplicates + " of duplicates"));

    }


}
