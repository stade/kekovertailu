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

//Class TUI handles text userinterface of heapcomparing
public class TUI {

    public void start() {
        Scanner input;
        boolean ready = false;
        int choise = 0;

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
                case 0: endMenu(); ready = true; break;
                default: break;
            }
        }
      }
   }
   private int checkInput(Scanner input) {
        System.out.println("Choise: ");
        input = new Scanner(System.in);

        while (!input.hasNextInt() ) {
            System.out.println("Wrong input!");
            System.out.println("Choise: ");
            input = new Scanner(System.in);
        }
        return input.nextInt();
    }

    private void insertMenu() {

        System.out.println("----------------------------------------");
        System.out.println("Please select the number of keys to be inserted (10-10000000");
       



        ComparingHeaps.insert();
      
    }
    private void findMinMenu() {
        ComparingHeaps.findmin();
    }
    private void deleteMinMenu() {
        ComparingHeaps.deleteMin();
    }
    private void degreaseKeyMenu() {
        ComparingHeaps.degreaseKey();
    }
    private void mergeMenu() {
        ComparingHeaps.merge();
    }
    private void endMenu() {

    }
}
