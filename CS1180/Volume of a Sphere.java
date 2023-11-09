import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // ask user for the radius of a sphere
        Scanner input = new Scanner(System.in);
        System.out.print("What is the radius of the sphere? ");
        
        // math and variables
        int radius = input.nextInt();
        double volume = (4 / (double) 3) * Math.PI * Math.pow(radius, 3);
        double roundedVolume = Math.round(volume * 100) / 100.0;
        
        // need to use printf to go out to 2 decimal positions
        System.out.printf("The sphere's volume is %.2f", roundedVolume);
        System.out.print(".");
    }
}