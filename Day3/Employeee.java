package Day3;

class Employee {
    int id;
    String name;

    Employee() {
        id = 0;
        name = "Unknown";
    }

    Employee(int i) {
        id = i;
        name = "Unknown";
    }

    Employee(int i, String n) {
        id = i;
        name = n;
    }

    void show() {
        System.out.println(id + " " + name);
    }
}

public class Employeee {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee(101);
        Employee e3 = new Employee(102, "rAKSHIT");

        e1.show();
        e2.show();
        e3.show();
    }
}
