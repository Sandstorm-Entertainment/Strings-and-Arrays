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
    String wantsToContinue;
    boolean userWantsContinue = false;
    
    
    System.out.println("String Utility Program");
   
    do {
    
    System.out.println("\nMain Menu\n\nEnter a single sentence or statement(s) to begin:");
    input = validInputEntry(); // User input 
    
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
      
      System.out.println("\nIf you want to continue with this string utility, enter \"Y\" otherwise hit the enter key to view another string uility."); //User decides if they want the current string utility or not 
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
    
    System.out.println("\nDo you wish to continue with another string utility? Input \"Y\" to continue, otherwise hit enter to terminate the program.");
    wantsToContinue = In.getString(); // Input
    
    if (wantsToContinue.toUpperCase().equals("Y")) { // If the user wants to continue 
      userWantsContinue = true;
    } else { // User wants to terminate the program 
      System.out.println("\nProgram terminated by user.");
    }
    
    } while (userWantsContinue == true); // Loops until the user no longer wants to continue running the program 
    
  }
  
  // Method used to validate the user input entry 
  public static String validInputEntry()
  {
    String input;
    boolean moreThanOneWord = false;
    boolean isValid = false;
    
    do {
      input = In.getString(); // User enters an input 
      input = input.trim(); // Removes additional spaces at the end and begining of the input 
      
      
      // Checks if the entry is blank
      if (input.length() == 0) {
        System.out.println("Error: Entry may not be blank.");
        
      } else {
        
        // Loops to check for spaces
        for (int i = 0; i < input.length(); i++) {
          char c = input.charAt(i);
          
          // Finds a space which indicates that there is more than one word
          if (c == ' ') {
            moreThanOneWord = true;
          }
        }
        
        if (moreThanOneWord == true) {
          // Input contains more than one word 
          isValid = true;
        } else { // The input is one word or less
          System.out.println("Error: Input must contain more than one word in order to be compatible with all the string utilities.");
        }
        
      }
    } while (isValid == false);
    
    // Returns the input to the main method
    return input;
    
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
   
    System.out.println("\nCount Words");
   
    String trimmed = input.trim(); // Trims input of extra spaces
    int words = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length; // Splits trimmed input and records its length
    System.out.println(words); // Outputs number of words 
    
  }
  
  // Method for the capitilize every word utility 
  public static void capitalizeEveryWord(String input) 
  {
     
   System.out.println("\nCapitalize Every Word");
    
    input = input.trim();
    String[] words = input.split("\\s+"); 
    input = "";
   
    for (int count = 0; count < words.length; count++)
    {
     char upperCase = Character.toUpperCase(words[count].charAt(0));
     input += " " + upperCase + words[count].substring(1); // Capitilizes the first letter in each word
    }
   
    input = input.trim();
    System.out.println(input + "\n");
    
  }
  
  // Method for the reverse statement utility 
  public static void reverseStatement(String input) 
  {
    String reverseInput = "";
      
    System.out.println("\nReverse Statement"); 
      
    for (int i = (input.length() - 1); i >= 0; i --) {
      
      reverseInput = reverseInput + input.charAt(i); // Adds each character to the reverseInput variable in reverse
    }
    
    // Output 
    System.out.println("\n" + reverseInput);
    
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
   System.out.println("\nAlternateCase");
   
    String sentence;
    char[] ch = new char[] {};
    ch = input.toCharArray(); //making a character array with the letters in input
    
    for (int count = 0; count < ch.length; count = count +2)
    {
      if (ch[count] != ' ' && !Character.isLetter(ch[count])) //checking for spaces and if the input is a symbol
      {
        ch[count] = Character.toUpperCase(ch[count]); //Capitalizing the letter
      }
      else
      {}
    }
    sentence = new String(ch);
    System.out.println(sentence);
  }
  
  // Method for the letter frequency utility 
  public static void letterFrequency(String input) 
  {
    System.out.println("\nLetterFrequency");
    System.out.println("This sentence is compised of...");
    
    input = input.replace(" ", ""); //removes spaces
    input = input.toUpperCase(); //makes it all uppercase
    int[] in = new int [27]; //includes all letters and uses one element for all symbols
                                
    for (int j = 0; j <= input.length() -1 ; j++)
    {
      if (input.charAt(j) == 'A') //checks all the letters of the string to see if there is an 'A'
      {
        in[0] = in[0] + 1; //if true (add one to the 'A' count
      }
      else if (input.charAt(j) == 'B')
      {
        in[1] = in[1] + 1;
      }
      else if (input.charAt(j) == 'C')
      {
        in[2] = in[21] + 1;
      }
      else if (input.charAt(j) == 'D')
      {
        in[3] = in[3] + 1;
      }
      else if (input.charAt(j) == 'E')
      {
        in[4] = in[4] + 1;
      }
      else if (input.charAt(j) == 'F')
      {
        in[5] = in[5] + 1;
      }
      else if (input.charAt(j) == 'G')
      {
        in[6] = in[6] + 1;
      }
      else if (input.charAt(j) == 'H')
      {
        in[7] = in[7] + 1;
      }
      else if (input.charAt(j) == 'I')
      {
        in[8] = in[8] + 1;
      }
      else if (input.charAt(j) == 'J')
      {
        in[9] = in[9] + 1;
      }
      else if (input.charAt(j) == 'K')
      {
        in[10] = in[10] + 1;
      }
      else if (input.charAt(j) == 'L')
      {
        in[11] = in[11] + 1;
      }
      else if (input.charAt(j) == 'M')
      {
        in[12] = in[12] + 1;
      }
      else if (input.charAt(j) == 'N')
      {
        in[13] = in[13] + 1;
      }
      else if (input.charAt(j) == 'O')
      {
        in[14] = in[14] + 1;
      }
      else if (input.charAt(j) == 'P')
      {
        in[15] = in[15] + 1;
      }
      else if (input.charAt(j) == 'Q')
      {
        in[16] = in[16] + 1;
      }
      else if (input.charAt(j) == 'R')
      {
        in[17] = in[17] + 1;
      }
      else if (input.charAt(j) == 'S')
      {
        in[18] = in[18] + 1;
      }
      else if (input.charAt(j) == 'T')
      {
        in[19] = in[19] + 1;
      }
      else if (input.charAt(j) == 'U')
      {
        in[20] = in[20] + 1;
      }
      else if (input.charAt(j) == 'V')
      {
        in[21] = in[21] + 1;
      }
      else if (input.charAt(j) == 'W')
      {
        in[22] = in[22] + 1;
      }
      else if (input.charAt(j) == 'X')
      {
        in[23] = in[23] + 1;
      }
      else if (input.charAt(j) == 'Y')
      {
        in[24] = in[24] + 1;
      }
      else if (input.charAt(j) == 'Z')
      {
        in[25] = in[25] + 1;
      }
      else
      {
        in[26] = in[26] + 1; //counting any symbols or numbers
      }
    }
    if (in[0] != 0) //if there is an A in the sentence
    {
      System.out.printf("%-5s %s %n","A - " , in[0]); //print how many 'A's there are
    }
    if (in[1] != 0)
    {
      System.out.printf("%-5s %s %n","B - " , in[1]);
    }
    if (in[2] != 0)
    {
      System.out.printf("%-5s %s %n","C - " , in[2]);
    }
    if (in[3] != 0)
    {
      System.out.printf("%-5s %s %n","D - " , in[3]);
    }
    if (in[4] != 0)
    {
      System.out.printf("%-5s %s %n","E - " , in[4]);
    }
    if (in[5] != 0)
    {
      System.out.printf("%-5s %s %n","F - " , in[5]);
    }
    if (in[6] != 0)
    {
      System.out.printf("%-5s %s %n","G - " , in[6]);}
    if (in[7] != 0)
    {
      System.out.printf("%-5s %s %n","H - " , in[7]);
    }
    if (in[8] != 0)
    {
      System.out.printf("%-5s %s %n","I - " , in[8]);
    }
    if (in[9] != 0)
    {
      System.out.printf("%-5s %s %n","J - " , in[9]);
    }
    if (in[10] != 0)
    {
      System.out.printf("%-5s %s %n","K - " , in[10]);
    }
    if (in[11] != 0)
    {
      System.out.printf("%-5s %s %n","L - " , in[11]);
    }
    if (in[12] != 0)
    {
      System.out.printf("%-5s %s %n","M - " , in[12]);
    }
    if (in[13] != 0)
    {
      System.out.printf("%-5s %s %n","N - " , in[13]);
    }
    if (in[14] != 0)
    {
      System.out.printf("%-5s %s %n","O - " , in[14]);
    }
    if (in[15] != 0)
    {
      System.out.printf("%-5s %s %n","P - " , in[15]);
    }
    if (in[16] != 0)
    {
      System.out.printf("%-5s %s %n","Q - " , in[16]);
    }
    if (in[17] != 0)
    {
      System.out.printf("%-5s %s %n","R - " , in[17]);
    }
    if (in[18] != 0)
    {
      System.out.printf("%-5s %s %n","S - " , in[18]);
    }
    if (in[19] != 0)
    {
      System.out.printf("%-5s %s %n","T - " , in[19]);
    }
    if (in[20] != 0)
    {
      System.out.printf("%-5s %s %n","U - " , in[20]);
    }
    if (in[21] != 0)
    {
      System.out.printf("%-5s %s %n","V - " , in[21]);
    }
    if (in[22] != 0)
    {
      System.out.printf("%-5s %s %n","W - " , in[22]);
    }
    if (in[23] != 0)
    {
      System.out.printf("%-5s %s %n","X - " , in[23]);
    }
    if (in[24] != 0)
    {
      System.out.printf("%-5s %s %n","Y - " , in[24]);
    }
    if (in[25] != 0)
    {
      System.out.printf("%-5s %s %n","Z - " , in[25]);
    }
    if (in[26] != 0)
    {
      System.out.printf("%-5s %s %n","Symbols - " , in[26]);
    }
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
   
    Scanner scan = new Scanner(System.in);
    String search;
    String str = "";
    int occurance = 0;
    String index = "";
    
    System.out.println("\nSearch");
    
    System.out.print("\nFind: ");
    search = scan.nextLine(); // User input 
  
    for (char c : input.toCharArray()) { // Loop goes through the user's statement
      str += c;
      if (str.length() == search.length()) {
        if (str.equals(search)) {
          occurance ++; // Adds 1 to the occurance of the searched item
        }
        str = str.substring(1);
      }
    }
    
    for (int i = -1; (i = input.indexOf(search, i + 1)) != -1; ) {
    index = index + " " + (i + 1); // Adds the index to the index variable
    }
    
    if (occurance > 0) {
      System.out.println("\nThe string is present and the count of the given string is: " + occurance);
      System.out.println("The substring " + search + " was found in the position(s):" + index);
    } else {
      System.out.println("\nThe string is not present");
    }
    
    scan.close(); // Closes the scanner 
    
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




























