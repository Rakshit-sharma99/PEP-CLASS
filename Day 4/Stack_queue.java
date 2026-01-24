// package Day 4;

// public class Stack_queue {
//     private int[] arr;
//     private int top;

//     public Stack_queue(int size) {
//         arr = new int[size];
//         top = -1;
//     }
//     public boolean isEmpty() {
//         return top == -1;
//     }
//     public boolean isFull() {
//         return top == arr.length - 1;
//     }
//     public void push(int value) {
//         if (!isFull()) {
//             arr[++top] = value;
//         } else {
//             System.out.println("Stack is full");
//         }
//     }
//     public int pop() {
//         if (!isEmpty()) {
//             return arr[top--];
//         } else {
//             System.out.println("Stack is empty");
//             return -1;
//         }
//     }
//     public int peek() {
//         if (!isEmpty()) {
//             return arr[top];
//         } else {
//             System.out.println("Stack is empty");
//             return -1;
//         }
//     }
//     public static void main(String[] args) {
//         Stack_queue stack = new Stack_queue(5);
//         stack.push(10);
//         stack.push(20);
//         stack.push(30);
//         System.out.println("Top element: " + stack.peek());
//         System.out.println("Popped element: " + stack.pop());
//         System.out.println("Top element after pop: " + stack.peek());
//     }
// }


// Default Constructor 
package Day 4;

public class Stack_queue {
    private int[] arr;
    private int top;

    // Default constructor
    public Stack_queue() {
        this(10);   // default size = 10
    }

    // Parameterized constructor
    public Stack_queue(int size) {
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(int value) {
        if (!isFull()) {
            arr[++top] = value;
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return arr[top--];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public static void main(String[] args) {
        Stack_queue stack = new Stack_queue(); // no size needed
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek());
    }
}
