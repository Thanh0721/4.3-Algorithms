import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms 
{
    public static void main(String[] args) 
    {
        try 
        {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);

            int twoLetterCount = 0;
            int longestWordLength = 0;
            int longestWordCount = 0;
            int palindromeCount = 0;

            while (scanner.hasNext()) 
            {
                String word = scanner.next();

                if (word.length() == 2) 
                {
                    twoLetterCount++;
                }

                if (word.length() > longestWordLength) 
                {
                    longestWordLength = word.length();
                    longestWordCount = 1;
                } 
                else if (word.length() == longestWordLength) 
                {
                    longestWordCount++;
                }

                if (isPalindrome(word)) {
                    palindromeCount++;
                }
            }

            scanner.close();

            System.out.println("Two letter word count: " + twoLetterCount);
            System.out.println("Longest word count: " + longestWordCount);
            System.out.println("Palindrome word count: " + palindromeCount);

        } 
        
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: File not found.");
        }
    }

    public static boolean isPalindrome(String word) 
    {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) 
        {
            if (word.charAt(i) != word.charAt(length - 1 - i)) 
            {
                return false;
            }
        }
        
        return true;
    }
}
