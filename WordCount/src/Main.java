import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        wordCount(args).entrySet().forEach(stringIntegerEntry -> {
            System.out.println(stringIntegerEntry);
        });
    }

    public static Map<String, Integer> wordCount(String[] args) {
        int word = Integer.parseInt(args[1]);
        List<String> mainList = new ArrayList<>();
        Map<String, Integer> repeat = new HashMap<>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            String str2;
            while ((str2 = bufferedReader.readLine()) != null) {

                StringTokenizer stringTokenizer = new StringTokenizer(str2, " .,");


                while (stringTokenizer.hasMoreTokens()) {
                    String token = stringTokenizer.nextToken();
                    mainList.add(token);
                }

                str2 = new String();
            }

            for (int i = 1; i <= word; i++) {
                String temp = getRandWord(mainList, repeat);

                for (int k = 0; k < mainList.size(); k++) {
                    int count = 0;

                    if (mainList.get(k).equals(temp)) {
                        for (int j = 1; j < mainList.size(); j++) {
                            if (temp.equals(mainList.get(j))) {
                                count++;
                                repeat.put(temp, count);
                            }
                        }
                    }
                }

            }


            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (repeat.size() != Integer.parseInt(args[1]))
            return wordCount(args);

        return repeat;
    }

    private static String getRandWord(List<String> mainList, Map<String, Integer> repeat) {

        String temp;
        do {
            temp = mainList.get(new Random().nextInt(mainList.size() - 1));
        } while (repeat.entrySet().contains(temp));

        return temp;
    }


}