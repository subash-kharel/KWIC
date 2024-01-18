import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KWIC {

    private static String[] circularShiftedLines;

    public static void main(String[] args) {
        // Change the file path accordingly
        String filePath = "src/input.txt";

        try {
            String[] lines = readLinesFromFile(filePath);
            circularShift(lines);
            alphabetizing();
            displayKWICIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] readLinesFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();

        return content.toString().split("\n");
    }

    private static void circularShift(String[] lines) {
        int totalWords = getTotalWords(lines);
        circularShiftedLines = new String[totalWords];

        int currentIndex = 0;
        for (String line : lines) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                StringBuilder shiftedWord = new StringBuilder();
                for (int j = i; j < i + words.length; j++) {
                    shiftedWord.append(words[j % words.length]).append(" ");
                }
                circularShiftedLines[currentIndex++] = shiftedWord.toString().trim();
            }
        }
    }

    private static int getTotalWords(String[] lines) {
        int totalWords = 0;
        for (String line : lines) {
            totalWords += line.split(" ").length;
        }
        return totalWords;
    }

    private static void alphabetizing() {
        for (int i = 0; i < circularShiftedLines.length - 1; i++) {
            for (int j = i + 1; j < circularShiftedLines.length; j++) {
                if (compareStrings(circularShiftedLines[i], circularShiftedLines[j]) > 0) {
                    String temp = circularShiftedLines[i];
                    circularShiftedLines[i] = circularShiftedLines[j];
                    circularShiftedLines[j] = temp;
                }
            }
        }
    }

    private static int compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (Character.toLowerCase(str1.charAt(i)) != Character.toLowerCase(str2.charAt(i))) {
                return Character.toLowerCase(str1.charAt(i)) - Character.toLowerCase(str2.charAt(i));
            }
        }
        return str1.length() - str2.length();
    }

    private static void displayKWICIndex() {
        for (String indexedLine : circularShiftedLines) {
            System.out.println(indexedLine);
        }
    }
}
