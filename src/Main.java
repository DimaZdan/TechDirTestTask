import java.util.*;

public class Main {
    public static void main(String[] args) {
        String minWord = "";
        int maxNum = 0;
        int maxNumIndex = 0;
        int minWordIndex = 0;
        String s = "game 45 but 87 17 hook salary 10 image 70 computer table 35 40";
        List<String> textArrayList = new LinkedList<>(Arrays.asList(s.split(" ")));
        for (int i = 0; i < textArrayList.size() / 2; i++) {
            for (int j = i; j < textArrayList.size() - i; j++) {
                if (isNum(textArrayList.get(j))) {
                    if (maxNum < Integer.parseInt(textArrayList.get(j))) {
                        maxNum = Integer.parseInt(textArrayList.get(j));
                        maxNumIndex = j;
                    }
                } else {
                    if (Objects.equals(minWord, "") || minWord.compareTo(textArrayList.get(j)) > 0) {
                        minWord = textArrayList.get(j);
                        minWordIndex = j;
                    }
                }
            }
            if (maxNumIndex > minWordIndex) {
                textArrayList.remove(maxNumIndex);
                textArrayList.remove(minWordIndex);
            } else {
                textArrayList.remove(minWordIndex);
                textArrayList.remove(maxNumIndex);
            }
            textArrayList.add(String.valueOf(maxNum));
            textArrayList.addFirst(minWord);
            maxNum = 0;
            maxNumIndex = 0;
            minWord = "";
            minWordIndex = 0;
            String result = String.join(" ", textArrayList);
            System.out.println("Line: " + (i + 1) + "\nArray: " + result);
        }
    }

    public static boolean isNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}