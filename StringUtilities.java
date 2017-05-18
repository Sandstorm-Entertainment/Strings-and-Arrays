/*
 ICS3U - Assignment String Utilities 
 By Eren Sulutas, Aaron Buitenwurf, and Joshua Perkins 
 
 Description:
 Program that that allows the user to enter a single sentence or statement(s) and allows them to chose between various string utilities. 
 
 */ 

import java.util.Scanner;

class StringUtilities
{
  public static void main(String[] args)
  {
    
    String input;
    String userContinue;
    int descriptionOf;
    
    System.out.println("String Utility Program");
    System.out.println("\nEnter a single sentence or statement(s) to begin:");
    input = In.getString(); // User input 
    
    System.out.println("\nList of String Utilities:\nEnter the number of a corresponding utility to view its description.\n");
    
    // Main menu which displays the list of string utilities the user can use 
    System.out.printf("%-25s %-25s %10s %n", "1. Count Letters", "5. Reverse Letters", "9. Consonants vs Vowels");
    System.out.printf("%-25s %-25s %10s %n", "2. Count Words", "6. Reverse Words", "10. Letters Only");
    System.out.printf("%-25s %-25s %10s %n", "3. Capitalize Every Word", "7. Alternate Case", "11. Search");
    System.out.printf("%-25s %-25s %10s %n", "4. Reverse Statement", "8. Letter Frequency", "12. Search & Replace");
    
    
    do {
      
      System.out.print("\nString Utility Number: ");
      
      // The user enters the string utility they wish to use and their input will be taken and checked in the validEntry method
      descriptionOf = validEntry();
      
      System.out.println("\nDescription: ");
      
      if (descriptionOf == 1) { // Description of string utility 1
        System.out.println("Count the total number of letters (no spaces, punctuation) in the statement(s).");
      } else if (descriptionOf == 2) { // Description of string utility 2 
        System.out.println ("Count the total number of words in the statement(s).");
      } else if (descriptionOf == 3) { // Description of string utility 3
        System.out.println ("Change the first letter of each word to uppercase.");
      } else if (descriptionOf == 4) { // Description of string utility 4
        System.out.println ("Output the statement completely in reverse. The first character is now last, the last character is now first.");
      } else if (descriptionOf == 5) { // Description of string utility 5
        System.out.println ("Output the statement so the words are in the correct order, but the letters for each word are reversed.");
      } else if (descriptionOf == 6) { // Description of string utility 6
        System.out.println ("Output the statement so the words are in reverse order, but the letters from each word are still in the correct order.");
      } else if (descriptionOf == 7) { // Description of string utility 7
        System.out.println ("Output the statement so the first letter is uppercase, the 2nd is lowercase, the 3rd is uppercase, etc.");
      } else if (descriptionOf == 8) { // Description of string utility 8
        System.out.println ("Analyze the word to determine which letters are present, and output a summary of the count for each letter.");
      } else if (descriptionOf == 9) { // Description of string utility 9
        System.out.println ("Analyze the word to determine the number of consonants, vowels, spaces, and punctuation in the word.");
      } else if (descriptionOf == 10) { // Description of string utility 10
        System.out.println ("Display the statement(s) with no spaces or punctuation.");
      } else if (descriptionOf == 11) { // Description of string utility 11
        System.out.println ("Find a letter or substring in the statement(s), and output the full statements, indicating where the letters or substring may be found.");
      } else if (descriptionOf == 12) { // Description of string utility 12
        System.out.println ("Find a letter or substring and replace them with a new substring specified by the user.");
      } 
      
      System.out.println("\nIf you want to continue with this string utility, enter \"Y\" otherwise hit the enter key to view another string utility."); //User decides if they want the current string utility or not 
      userContinue = In.getString();
      userContinue = userContinue.toUpperCase();
     
      
    } while (!userContinue.equals("Y")); // Loops until the user confirms the string utility they want to use 
    
    
    if (descriptionOf == 1) { // User selects string utility 1
      countLetters(input); 
    } else if (descriptionOf == 2) { // User selects string utility 2
      countWords(input);
    } else if (descriptionOf == 3) { // User selects string utility 3
      capitalizeEveryWord(input);
    } else if (descriptionOf == 4) { // User selects string utility 4
      reverseStatement(input);
    } else if (descriptionOf == 5) { // User selects string utility 5
      reverseLetters(input);
    } else if (descriptionOf == 6) { // User selects string utility 6
      reverseWords(input);
    } else if (descriptionOf == 7) { // User selects string utility 7
      alternateCase(input);
    } else if (descriptionOf == 8) { // User selects string utility 8
      letterFrequency(input);
    } else if (descriptionOf == 9) { // User selects string utility 9
      consonantsAndVowels(input);
    } else if (descriptionOf == 10) { // User selects string utility 10
      lettersOnly(input);
    } else if (descriptionOf == 11) { // User selects string utility 11
      search(input);
    } else if (descriptionOf == 12) { // User selects string utility 12
      searchAndReplace(input);
    }
    
  }
  
  
  // Method used to validate the user entry for the string utility number
  public static int validEntry()
  {
    
    Scanner scan = new Scanner(System.in);
    int input = 0;
    boolean isValid = false; 
    
    while (isValid == false) { // Loops until the user enters a proper input 
      if (scan.hasNextInt()) { // Checks if the users input has an integer value 
        input = scan.nextInt(); // Assigns the input value to the local variable input if the user entered a valid input
        
        if (input >= 1 && input <= 12) { // Checks if the user input is between 1 and 12
          isValid = true;
          
        } else { // User inputted a number that is not between 1 and 12 
          System.out.println("Error: Enter an input between 1 and 12."); // Error message if the user enters an invalid input 
          scan.nextLine(); // Scans the next line for an integer value 
        }
        
      } else { // User enters an invalid number input 
        System.out.println("Error: Invalid integer input. Enter another input."); // Error message if the user enters an invalid input 
        scan.nextLine(); // Scans the next line for an integer value 
      }
    }
    
    // Closes the scanner 
    scan.close(); 
    
    // Returns the input value to the main method
    return input;  
    
  }
  
  // Method for the count letters utility 
  public static void countLetters(String input) 
  {
  
    System.out.println("\nCount Letters");
    
    int letterCount = 0; // initializes letter count to 0
    
    for(int count = 0; count < input.length(); count++) 
    {
      char c = input.charAt(count);
      if (Character.isLetter(c)) // checks to see if character is valid 
      {
        letterCount = letterCount + 1; // adds 1 to letterCount if c is a valid character
      }
    }
     System.out.println("The total number of letters within your statement(s) is: " + letterCount);
   
  }
  
  // Method for the count words utility 
  public static void countWords(String input) 
  {
    
    // Josh's code goes here
    
  }
  
  // Method for the capitilize every word utility 
  public static void capitalizeEveryWord(String input) 
  {
    
    // Josh's code goes here
    
  }
  
  // Method for the reverse statement utility 
  public static void reverseStatement(String input) 
  {
    
    // Josh's code goes here
    
  }
  
  // Method for the reverse letters utility 
  public static void reverseLetters(String input) 
  {
    System.out.println("\nReverseLetters"); //name of utility
    
    
    String result = (""); //sets the result to nothing
    String[] words = input.split("\\s+"); //splits the input into words seperated by spaces
    String[] reverse = new String[input.length()]; //setting the length of this array to the amount of words
    for (int j = 0; j < words.length; j ++) //making each element of the array equal to nothing
    {
      reverse[j] = "";
    }
     
    for (int count = 0; count < words.length; count ++) //repeats for each word there is
    {
      for (int c = words[count].length() -1; c >= 0; c--) //repeats for how long the word is
      {
        reverse[count] = reverse[count] + words[count].charAt(c);
      }
    }
    for (int x = 0; x < words.length; x++) 
    {
    result = result + reverse[x] + " "; //making the result by putting in each word reversed plus a space
    }      
    System.out.println(result); //prints result
  }
 
  // Method for the reverse words utility 
  public static void reverseWords(String input) 
  {
   System.out.println("\nReverseWords");
    
    String result = ("");
    String[] words = input.split("\\s+");
    
    for (int count = words.length -1; count >= 0; count--)
    {
      result = result + words[count] + " ";
    }
    System.out.println(result);
  }
  
  // Method for the alternate case utility 
  public static void alternateCase(String input) 
  {
    
    // Aaron's code goes here
    
  }
  
  // Method for the letter frequency utility 
  public static void letterFrequency(String input) 
  {
    
    // Aaron's code goes here
    
  }
  
  // Method for the consonants and vowels utility 
  public static void consonantsAndVowels(String input)
  {
    // Array used to store the different types including vowels, consonants, spaces, and punctuation
    int type[] = new int[4];
    
    System.out.println("\nConsonants and Vowels");
    
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      c = Character.toUpperCase(c); // Capitilizes the character 
      
      if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U') { // Character is a vowel 
        type[0] ++; // Adds 1 to type[0] which is for vowels 
      } else if (Character.isLetter(c)) { // Consonant
        type[1] ++; // Adds 1 to type[1] which is for consonants
      } else if (c == ' ') { //Character is a space
        type[2] ++; // Adds 1 to type[3] which is for spaces
      } else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) { // Puncuation
        type[3]++; // Adds 1 to type[4] which is for puncuation 
      }
    }
    
    // Output 
    System.out.println("\nVowels: " + type[0] + "\nConsonants: " + type[1] + "\nSpaces: " + type[2] + "\nPuncuation: " + type[3]);
    
  }
  
  // Method for the letters only utility 
  public static void lettersOnly(String input) 
  {
    String output = "";
    
    System.out.println("\nLetters Only");
    
    // Loops through every chararcter in the input 
    for (int i = 0; i < input.length(); i++) { 
      char c = input.charAt(i);
      
      if (Character.isLetter(c)) {
        output = output + c; // Adds the charracter to the output 
      }
    }
    
    // Ouput
    System.out.println(output);
    
  }
  
  // Method for the search utility 
  public static void search(String input) 
  {
    
    // Eren's code goes here
    
  }
  
  // Method for the search and replace utility 
  public static void searchAndReplace(String input) 
  {
    
    Scanner scan = new Scanner(System.in);
    String search;
    String replace;
    String str = "";
    int occurance = 0;
    
    System.out.println("\nSearch and Replace");
    
    System.out.print("\nFind: ");
    search = scan.nextLine(); // User search input 
    
    for (char c : input.toCharArray()) { // Loop goes through the user's statement
      str += c;
      if (str.length() == search.length()) {
        if (str.equals(search)) {
          occurance ++; // Adds 1 to the occurance of the searched item
        }
        str = str.substring(1);
      }
    }
    
    if (occurance > 0) { // The item the user wishes to find and replace is present in the original input 
      
      System.out.print("\nReplace with: ");
      replace = scan.nextLine(); // User find input 
      
      input = input.replaceAll(search, replace); // Replace feature
      
      // Output
      System.out.println("\nReplaced results:");
      System.out.println(input);
      
    } else { // The item the user wishes to find and replace is not present in the original input 
      
      System.out.println("\nThe string is not present");
    }
    
    scan.close(); // Closes the scanner 
    
  }
  
}




























