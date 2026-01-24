package Day3;
class Student {
    String name;
    int rollNo;
    int marks;

    Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 40)
            return "D";
        else
            return "F";
    }

    void displayGrade() {
        System.out.println("Name: " + name +
                           ", Roll No: " + rollNo +
                           ", Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Student s1 = new Student("Rahul", 101, 85);
        Student s2 = new Student("Anita", 102, 92);
        Student s3 = new Student("Vikram", 103, 58);

        s1.displayGrade();
        s2.displayGrade();
        s3.displayGrade();
    }
}