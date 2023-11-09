// Joe Claborn
import java.util.Scanner;

public class How_Many_Games {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many people are signed up to play?");
        int people = input.nextInt();
        int amount = people / 4;
        System.out.print("That is enough for " + amount + " games.");
        input.close();
    }
}