import java.util.HashSet;

public class Homework6 {
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("Lenovo Legion", 16, 1, "RTX3050", "Windows");
        Laptop laptop2 = new Laptop("MSI Titan", 16, 1, "RTX3050", "Windows");
        Laptop laptop3 = new Laptop("MSI Titan", 32, 2, "RTX4070", "none");
        Laptop laptop4 = new Laptop("MacBook Air", 16, 2, "integrated", "MAC OS");

        HashSet<Laptop> laptopSet = new HashSet<>();
        laptopSet.add(laptop1);
        laptopSet.add(laptop2);
        laptopSet.add(laptop3);
        laptopSet.add(laptop4);

        System.out.println("#1: " + laptop1);
        System.out.println("#2: " + laptop2);
        System.out.println("#3: " + laptop3);
        System.out.println("#4: " + laptop4);
        System.out.println();

        System.out.println("#1 equals #2 = " + laptop1.equals(laptop2));
        System.out.println("#2 equals #3 = " + laptop2.equals(laptop3));
        System.out.println();

        Laptop.launchFilter(laptopSet);
    }
}
