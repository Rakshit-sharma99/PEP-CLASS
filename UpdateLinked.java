import java.util.LinkedList;

public class UpdateLinked {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> languages = new LinkedList<>();

        // Add elements to the LinkedList
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        System.out.println("Original LinkedList: " + languages);

        // Update the element at index 2 (C++) to "Golang"
        languages.set(2, "Golang");

        System.out.println("Updated LinkedList: " + languages);

        // Update functionality example
        if (languages.contains("Python")) {
            int index = languages.indexOf("Python");
            languages.set(index, "TypeScript");
            System.out.println("After replacing Python with TypeScript: " + languages);
        }
    }
}
