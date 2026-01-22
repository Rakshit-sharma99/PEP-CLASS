import java.util.*;

class Student {
    private static int uidCounter = 1;
    private static int rollCounter = 1;
    private String uid;
    private String roll;
    private String name;
    private int age;

    Student(String name, int age) {
        this.uid = "UID" + uidCounter++;
        this.roll = "Rollno." + rollCounter++;
        this.name = name;
        this.age = age;
    }

    String getUid() {
        return uid;
    }

    String getRoll() {
        return roll;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

public class First {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student by Roll");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice;
            try {
                choice = s.nextInt();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Invalid Input");
                continue;
            }

            if (choice == 1) {
                s.nextLine();

                System.out.print("Enter Name: ");
                String name = s.nextLine();

                System.out.print("Enter Age: ");
                int age = s.nextInt();
                s.nextLine();

                if (age <= 0) {
                    System.out.println("Invalid Age");
                    continue;
                }

                Student st = new Student(name, age);
                list.add(st);
                System.out.println("Student Added Successfully");
                System.out.println("Generated UID: " + st.getUid());
                System.out.println("Generated Roll: " + st.getRoll());

            } else if (choice == 2) {
                if (list.isEmpty()) {
                    System.out.println("No Records Found");
                } else {
                    for (Student st : list) {
                        System.out.println("UID: " + st.getUid());
                        System.out.println("Roll: " + st.getRoll());
                        System.out.println("Name: " + st.getName());
                        System.out.println("Age: " + st.getAge());
                        System.out.println("----------------");
                    }
                }

            } else if (choice == 3) {
                s.nextLine();
                System.out.print("Enter Roll No to Search (e.g. Rollno.1): ");
                String r = s.nextLine();
                boolean found = false;

                for (Student st : list) {
                    if (st.getRoll().equals(r)) {
                        System.out.println("UID: " + st.getUid());
                        System.out.println("Roll: " + st.getRoll());
                        System.out.println("Name: " + st.getName());
                        System.out.println("Age: " + st.getAge());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student Not Found");
                }

            } else if (choice == 4) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
        s.close();
    }
}
