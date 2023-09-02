package recordsorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author nanoic 2023
 */
public class RecordSorter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> recordStrArray = new ArrayList<String>();

        recordStrArray.add("Betamax");
        recordStrArray.add("Laserdisc");
        recordStrArray.add("DVD");
        recordStrArray.add("VHS");
        recordStrArray.add("Vinyl");
        recordStrArray.add("Video CD");
        recordStrArray.add("Digital Audio Tape");
        recordStrArray.add("Super Audio CD");
        recordStrArray.add("HD DVD");

        displayMenu();
        menuOperations(recordStrArray);

    }

    public static void menuOperations(ArrayList<String> recordStrArray) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        while (option < 0 || option > 5) {
            displayMenu();
            option = input.nextInt();
        }

        if (option == 1) {
            listRecordsAlphabetically(recordStrArray);
        } else if (option == 2) {
            addNewRecordToCollection(recordStrArray);
        } else if (option == 3) {
            removeRecordFromCollection(recordStrArray);
        } else if (option == 4) {
            deleteAllRecordsFromCollection(recordStrArray);
        } else if (option == 5) {
            exitProgram();
        }
    }

    public static void displayMenu() {
        System.out.println("Menu");
        System.out.println("List records in collection: 1");
        System.out.println("Add a record to your collection: 2");
        System.out.println("Remove a record from your collection: 3");
        System.out.println("Delete all records in collection: 4");
        System.out.println("Exit program: 5");
    }

    public static void listRecordsAlphabetically(ArrayList<String> recordStrArray) {
        System.out.println("Sort records alphabetically by artist: ");
        Collections.sort(recordStrArray);
        Arrays.asList(recordStrArray).forEach(System.out::println);
        displayMenu();
        menuOperations(recordStrArray);
    }

    public static void addNewRecordToCollection(ArrayList<String> recordStrArray) {
        System.out.println("Add a record to your collection:");

        Scanner input = new Scanner(System.in);
        String newRecordS = input.nextLine();
        newRecordS.toLowerCase();
        recordStrArray.add(newRecordS);
        Collections.sort(recordStrArray);
        displayMenu();
        menuOperations(recordStrArray);
    }

    public static void removeRecordFromCollection(ArrayList<String> recordStrArray) {
        System.out.println("Remove a record from your collection");
        Scanner input = new Scanner(System.in);
        String deleteRecordS = input.nextLine();

        recordStrArray.remove(deleteRecordS);

        displayMenu();
        menuOperations(recordStrArray);
    }

    public static void deleteAllRecordsFromCollection(ArrayList<String> recordStrArray) {
        System.out.println("Delete all records from your collection");
        System.out.println("Are you sure you want to do this?");
        Scanner input = new Scanner(System.in);
        String commandS = input.next();
        if (commandS.contains("yes") || commandS.contains("y")) {
            recordStrArray.clear();
            System.out.println("All records have been permanently deleted from your collection!");
        } else if (commandS.contains("no") || commandS.contains("n")) {
            System.out.println("Returning to main menu.");

        }
        displayMenu();
        menuOperations(recordStrArray);
    }

    public static void exitProgram() {
        System.out.println("Exiting program.");
        System.exit(0);
    }
}
