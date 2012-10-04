package main;

/**
 * Created with IntelliJ IDEA.
 * User: renuahla
 * Date: 5/10/12
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReserveBook {
     void reserveBook() {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int i2 = Program.getUserChoice();
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            default:
                System.out.println("\n");
                System.out.println("Sorry we don't have that book yet.");
        }
    }
}
