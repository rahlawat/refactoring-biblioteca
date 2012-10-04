package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";
    private static PrintBookCatalog bookCatalog = new PrintBookCatalog();
    private static ReserveBook reserve = new ReserveBook();
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int i1 = getUserChoice();

            if (i1 == 1) {
                bookCatalog.printBookCatalog();
            } else if (i1 == 2) {
                reserve.reserveBook();
            } else if (i1 == 3) {
               checkLibraryNumber();
            } else if (i1 == 4) {
                printMovieCatalog();
            } else if (i1 == 5) {
                login();

            } else if (i1 == 9) {
                quit();
                break;
            } else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }
        }
    }

    private static void quit() {
        System.out.println("Quitting...");
    }

    private static void login() {
        BufferedReader reader = createNewReader();
        clearLogin();
        System.out.println("Enter your library number");
        try {
            String libraryNumber = reader.readLine();
            if (validLibraryNumber(libraryNumber)) {
                try {
                    System.out.println("Enter your Password: ");
                    String password = reader.readLine();
                    if (validPassword(password)) {
                        loggedIn = true;
                        savedLibraryNumber = libraryNumber;
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }
    }

  private static void checkLibraryNumber() {
        if (loggedIn) {
            System.out.println("\n");
            System.out.println("Your library number is " + savedLibraryNumber);
        } else {

            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
        }
    }

    private static void printMovieCatalog() {
        System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
        System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
        System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
        System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
        System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(createMovie("Inception", "Frank Darabont", "10"));
        System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    private static void printMenu() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private static BufferedReader createNewReader() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        return new BufferedReader(inputStream);
    }

    protected static int getUserChoice() {
        BufferedReader reader = createNewReader();
        try {
            String value = reader.readLine();
           return Integer.parseInt(value);
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
            return 0;
        }

    }

    private static boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private static boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

