package Day3;
class Rect {
    private int length = 1;
    private int width = 1;

    public void setLength(int l) {
        length = l;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int w) {
        width = w;
    }

    public int getWidth() {
        return width;
    }

    public int area() {
        return length * width;
    }
}

public class RectangleTest {
    public static void main(String[] args) {
        Rect r = new Rect();

        System.out.println(r.area()); // 1

        r.setLength(5);
        r.setWidth(3);

        System.out.println(r.area()); // 15
    }
}
