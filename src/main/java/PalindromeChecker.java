import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
    public void tester() {
        String[] lines = new String[6]; 
        try {
            File myFile = new File("palindromes.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("There are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            if (palindrome(lines[i])) {
                System.out.println(lines[i] + " IS a palindrome.");
            } else {
                System.out.println(lines[i] + " is NOT a palindrome.");
            }
        }
    }

    public boolean palindrome(String sWord) {
        String a = onlyLetters(sWord).toLowerCase(); 
        return a.equals(reverse(a));
    }

    public String reverse(String sWord) {
        String x = "";
        for (int i = sWord.length(); i > 0; i--) {
            x += sWord.substring(i - 1, i);
        }
        return x;
    }

    public String onlyLetters(String sString) {
        String x = "";
        for (int i = 0; i < sString.length(); i++) {
            if (Character.isLetter(sString.charAt(i))) {
                x += sString.charAt(i);
            }
        }
        return x;
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        checker.tester();
    }
}
