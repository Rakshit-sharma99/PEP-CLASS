package Day3;
class Biggest {
    int arr[];

    Biggest() {
        arr = new int[]{10, 25, 5, 40, 15};
    }

    void display() {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Largest element = " + max);
    }

    public static void main(String[] args) {
        Biggest b = new Biggest();
        b.display();
    }
}
