/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kekovertailu;
import java.util.Scanner;
/**
 *
 * @author Tatu Tahvanainen
 */

//Class TUI handles the text userinterface of heapcomparing
public class TUI {

    public void start() {

        mainMenu();
    }
    private void mainMenu() {

        Scanner input;
        boolean ready,stop = false;
        int choise = 0;

        while (!stop) {

            ready = false;
            choise = 0;

            System.out.println("----- Welcome to Heap comparison! -----");
            System.out.println("Please select a heap method to be compared (0-5)");
            System.out.println("----------------------------------------");
            System.out.println("1. Inserting a key ");
            System.out.println("2. Finding min key");
            System.out.println("3. Deleting minimun key");
            System.out.println("4. Degreasing key");
            System.out.println("5. Merge/Union of heaps");
            System.out.println("0. Exit");
            System.out.println("----------------------------------------");

            
            while(!ready) {
                input = new Scanner(System.in);
                choise = checkInput(input);
                if (0 <= choise && choise <= 5) {
                    switch (choise) {
                        case 1: insertMenu(); ready = true; break;
                        case 2: findMinMenu(); ready = true; break;
                        case 3: deleteMinMenu(); ready = true; break;
                        case 4: degreaseKeyMenu(); ready = true; break;
                        case 5: mergeMenu(); ready = true; break;
                        case 0: stop = true; ready = true; break;
                        default: break;
                    }
                }
            }
        }
   }
   private int checkInput(Scanner input) {
        System.out.println("Input: ");
        input = new Scanner(System.in);

        while (!input.hasNextInt() ) {
            System.out.println("Wrong input!");
            System.out.println("Input : ");
            input = new Scanner(System.in);
        }
        return input.nextInt();
    }

    private void insertMenu() {
        int numKeys = 0;
        int testTimes = 0;
        Scanner input;

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-1000000");

        input = new Scanner(System.in);
        numKeys = checkInput(input);

        System.out.println("Please select the number of times to run the comparing");

        input = new Scanner(System.in);
        testTimes = checkInput(input);

        ComparingHeaps.insert(numKeys,testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
      
    }
    private void findMinMenu() {
        ComparingHeaps.findmin();
        System.out.println("Press enter to return main menu");
    }
   
    private void deleteMinMenu() {
        int numKeys = 0;
        int testTimes = 0;
        Scanner input;

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-1000000");

        input = new Scanner(System.in);
        numKeys = checkInput(input);

        System.out.println("Please select the number of times to run the comparing");

        input = new Scanner(System.in);
        testTimes = checkInput(input);

        ComparingHeaps.deleteMin(numKeys,testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }
    private void degreaseKeyMenu() {
        int numKeys = 0;
        int testTimes = 0;
        int degreaseCount = 0;
        Scanner input;

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-1000000");

        input = new Scanner(System.in);
        numKeys = checkInput(input);

        System.out.println("Please select the number of times to run the comparing");

        input = new Scanner(System.in);
        testTimes = checkInput(input);

        System.out.println("Please select the number of times that degreasing key is done");

        input = new Scanner(System.in);
        degreaseCount = checkInput(input);

        ComparingHeaps.degreaseKey(numKeys, testTimes, degreaseCount);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }
    private void mergeMenu() {
        int numKeys = 0;
        int testTimes = 0;
        Scanner input;

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-1000000");

        input = new Scanner(System.in);
        numKeys = checkInput(input);

        System.out.println("Please select the number of times to run the comparing");

        input = new Scanner(System.in);
        testTimes = checkInput(input);

        ComparingHeaps.merge(numKeys,testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }
}
