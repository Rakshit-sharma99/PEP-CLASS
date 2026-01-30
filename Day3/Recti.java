class Rect {
    private int length = 1;
    private int width = 1;

    // Setter for length
    public void setLength(int l) {
        length = l;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Setter for width
    public void setWidth(int w) {
        width = w;
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Method to calculate area
    public int area() {
        return length * width;
    }
}

// Test class
public class Recti {
    public static void main(String[] args) {
        Rect r = new Rect();

        System.out.println(r.area()); // 1

        r.setLength(5);
        r.setWidth(3);

        System.out.println(r.area()); // 15
    }
}
