import java.util.Scanner;

public class Q1{
    public static void main(String[] args) {
        int a = 50;
        if(a > 90){
            System.out.println("A+");
        }
        else if(a > 80){
            System.out.println("A");
        }
        else if(a > 70){
            System.out.println("B+");
        }
        else if(a > 60){
            System.out.println("B");
        }
        else if(a > 50){
            System.out.println("C+");
        }
        else if(a > 40){
            System.out.println("C");
        }
        else{
            System.out.println("Fail");
        }



 Scanner s = new Scanner(System.in);
System.out.println("Enter age");
int age = s.nextInt();

if(age>18){
    System.out.print("Go drive");

}
else{
    System.out.println("You cant drive");
}
    }
}
  



// //nESTED IF ELSE VERSION
//         if (a > 40) {
//             if (a > 50) {
//                 if (a > 60) {
//                     ifE (a > 70) {
//                         if (a > 80) {
//                             if (a > 90) {
//                                 System.out.println("A+");
//                             } else {
//                                 System.out.println("A");
//                             }
//                         } else {
//                             System.out.println("B+");
//                         }
//                     } else {
//                         System.out.println("B");
//                     }
//                 } else {
//                     System.out.println("C+");
//                 }
//             } else {
//                 System.out.println("C");
//             }
//         } else {
//             System.out.println("Fail");
//         }
//     }
// }


// //ONLY IF 
// public class Q1 {
//     public static void main(String[] args) {
//         int a = 50;

//         if (a > 90) System.out.println("A+");
//         if (a <= 90 && a > 80) System.out.println("A");
//         if (a <= 80 && a > 70) System.out.println("B+");
//         if (a <= 70 && a > 60) System.out.println("B");
//         if (a <= 60 && a > 50) System.out.println("C+");
//         if (a <= 50 && a > 40) System.out.println("C");
//         if (a <= 40) System.out.println("Fail");
//     }
// }

