/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kekovertailu;
import java.util.Scanner;
/**
 * Class TUI handles the text userinterface of heapcomparing
 *
 * @author Tatu Tahvanainen
 */
public class TUI {

    final int MAX_VALUE_KEYS = 1000000;
    final int MAX_VALUE_TIMES = 1000000;

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
            System.out.println("4. Decreasing key");
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
                        case 4: decreaseKeyMenu(); ready = true; break;
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
        boolean ready = false;
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-" + MAX_VALUE_KEYS + ")");

        while (!ready) {
            input = new Scanner(System.in);
            numKeys = checkInput(input);

            if (10 <= numKeys && numKeys <= MAX_VALUE_KEYS) {
                ready = true;
            }
        }
        System.out.println("Please select the number of times to run the comparing (1-" + MAX_VALUE_TIMES + ")");
        ready = false;
        
        while (!ready) {
            input = new Scanner(System.in);
            testTimes = checkInput(input);

            if(1 <= testTimes && testTimes <= MAX_VALUE_TIMES) {
                ready = true;
            }
        }

        ComparingHeaps.insert(numKeys,testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
      
    }
    private void findMinMenu() {
        int numKeys = 0;
        int testTimes = 0;
        boolean ready = false;
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-" + MAX_VALUE_KEYS + ")");

        while (!ready) {
            input = new Scanner(System.in);
            numKeys = checkInput(input);

            if (10 <= numKeys && numKeys <= MAX_VALUE_KEYS) {
                ready = true;
            }
        }
        System.out.println("Please select the number of times to run the comparing (1-" + MAX_VALUE_TIMES + ")");
        ready = false;

        while (!ready) {
            input = new Scanner(System.in);
            testTimes = checkInput(input);

            if(1 <= testTimes && testTimes <= MAX_VALUE_TIMES) {
                ready = true;
            }
        }
        ComparingHeaps.findmin(numKeys, testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }
   
    private void deleteMinMenu() {
        int numKeys = 0;
        int testTimes = 0;
        boolean ready = false;
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-" + MAX_VALUE_KEYS + ")");

        while (!ready) {
            input = new Scanner(System.in);
            numKeys = checkInput(input);

            if (10 <= numKeys && numKeys <= MAX_VALUE_KEYS) {
                ready = true;
            }
        }

        System.out.println("Please select the number of times to run the comparing (1-" + MAX_VALUE_TIMES + ")");
        ready = false;

        while (!ready) {
            input = new Scanner(System.in);
            testTimes = checkInput(input);

            if (1 <= testTimes && testTimes <= MAX_VALUE_TIMES) {
                ready = true;
            }
        }

        ComparingHeaps.deleteMin(numKeys,testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }
    private void decreaseKeyMenu() {
        int numKeys = 0;
        int testTimes = 0;
        int decreaseCount = 0;
        boolean ready = false;
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-" + MAX_VALUE_KEYS + ")");

         while (!ready) {
            input = new Scanner(System.in);
            numKeys = checkInput(input);

            if (10 <= numKeys && numKeys <= MAX_VALUE_KEYS) {
                ready = true;
            }
        }

        System.out.println("Please select the number of times to run the comparing (1-" + MAX_VALUE_TIMES + ")");
        ready = false;

        while (!ready) {
            input = new Scanner(System.in);
            testTimes = checkInput(input);

            if (1 <= testTimes && testTimes <= MAX_VALUE_TIMES) {
                ready = true;
            }
        }

        System.out.println("Please select the number of times that decreasing key is done (1-" + MAX_VALUE_TIMES + ")");
        ready = false;

        while (!ready) {
            input = new Scanner(System.in);
            decreaseCount = checkInput(input);

            if (1 <= decreaseCount && decreaseCount <= MAX_VALUE_TIMES) {
                ready = true;
            }
        }

        ComparingHeaps.degreaseKey(numKeys, testTimes, decreaseCount);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }
    private void mergeMenu() {
        int numKeys = 0;
        int testTimes = 0;
        boolean ready = false;
        Scanner input = new Scanner(System.in);


        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-" + MAX_VALUE_KEYS + ")");

        while (!ready) {
            input = new Scanner(System.in);
            numKeys = checkInput(input);

            if (10 <= numKeys && numKeys <= MAX_VALUE_KEYS) {
                ready = true;
            }
        }

        System.out.println("Please select the number of times to run the comparing (1-" + MAX_VALUE_TIMES + ")");
        ready = false;

        while (!ready) {
            input = new Scanner(System.in);
            testTimes = checkInput(input);

            if (1 <= testTimes && testTimes <= MAX_VALUE_TIMES) {
                ready = true;
            }
        }

        ComparingHeaps.merge(numKeys,testTimes);
        System.out.println("Press enter to return main menu");
        input.nextLine();
    }

}
