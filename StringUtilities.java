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
      
    int descriptionOf;
   
    System.out.print("\nString Utility Number: ");
    
    // The user enters the string utility they wish to use and their input will be taken and checked in the validEntry method
    descriptionOf = validEntry();
    
    System.out.println("Description: ");
    
    if (descriptionOf == 1) { // Description of string utility 1
      System.out.println("Count the total number of letters (no spaces, punctuation) in the statement(s).");
    }
    
    System.out.println("\nIf you want to continue with this string utility, enter \"Y\" otherwise hit the enter key"); //User decides if they want the current string utility or not 
    userContinue = In.getString();
    userContinue = userContinue.toUpperCase();
 
    } while (!userContinue.equals("Y")); // Loops until the user confirms the string utility they want to use 
                         
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
  
}