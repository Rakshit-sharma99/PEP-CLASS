package Day3;
public class Largest {
    public static int largest(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static double largest(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Largest: " + largest(a, b, c));
    }
}