package DAy15;


class Node {
int data;
Node next;


Node(int data){
    this.data=  data;
    this.next =null;
}

    
}


class LinkedList{
    Node head;
    public void printlist(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public int countNode(){
        int count =0;
        Node curr  = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    public boolean search(int key){
        Node curr = head;
        while(curr!=head){
            if(curr.data==key) return true;
            curr = curr.next;
        }
        return false;
    }
    public void insertAtbBeginning(int data){
        Node newNode = new Node(data);
        newNode.next =head;
        head = newNode;
    }
    public void insertAtEnd(int data){
        Node newNode =  new Node(data);
        Node curr =  head;

        while(curr.next !=null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    public void insertAtPosition(int data, int pos){
        if(pos==1){
            insertAtbBeginning(data);
            return;
        }
        Node newNode= new Node(data);
        Node curr =  head;

        for(int i =1; i<pos-1 && curr !=null; i++){
            curr =curr.next;
        }
        if(curr ==null)return;
        newNode.next = curr.next;
        curr.next = newNode;
    }
    public void deleteAtBeginning(){
        if(head==null)return;
        head = head.next;
        }
    public void deleteAtEnd(){
        if(head==null)return;
        if(head.next==null){
            head = null;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
           
            
        }
        curr.next  = null;

    }
    public void deleteByValue(int key){
        if(head== null)return;
        if(head.data== key)
        {
            head = head.next;
            return;
        }
        Node curr = head;
        while(curr.next !=null && curr.next.data!=key){
            curr = curr.next;

        }
        if(temp.next!= null){
            temp.next = temp.next.next;
        }
        
        }

    }

}



public class llall {

    public static void main(String[] args) {
        // You can test your linked list implementations here



LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(40);
        list.insertAtEnd(20);
        list.printlist();



        list.insertAtbBeginning(5023);
        list.insertAtPosition(21, 2);
        list.printlist();
        list.deleteAtBeginning();
    }
}
