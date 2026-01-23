import java.util.*;


public class switchh {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter day num (1-7) ");
    int number = sc.nextInt();

    switch(number){
        case 1:
            System.out.println("Sun");
            break;
        case 2:
            System.out.println("Mon");   
            break;
        case 3:
            System.out.println("Tue");
            break;
        case 4:
            System.out.println("Wed");
            break;
        case 5:
            System.out.println("Thur");
            break;
        case 6:
            System.out.println("Fr");
            break;
        case 7:
            System.out.println("Sat");
            break;
        default:
            System.out.println("Dumb, it must be 1-7");
    }
}
}