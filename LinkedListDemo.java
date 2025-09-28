class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count = count + 1;
        }
        return current;
    }

    // Implementación del delete según pseudocódigo
    public Node LinkedListDelete(int index) {
        //  Si la lista está vacía
        if (head == null) {
            return null;
        }

        //  Si queremos eliminar la cabeza
        if (index == 0) {
            Node new_head = head.next;
            head.next = null;
            head = new_head;
            return head;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        // Recorrer hasta el índice
        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count = count + 1;
        }

        // Si encontramos el nodo
        if (current != null) {
            //  enlazar anterior con el siguiente
            previous.next = current.next;
            //  aislar el nodo eliminado
            current.next = null;
        } else {
            //  índice inválido
            System.out.println("Error: índice inválido.");
        }

        return head;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/\n");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        // Lista inicial: 10->20->30->40->50->/
        list.printList();

        // Insertar 71 después del nodo en posición 2 (30)
        Node previous = list.LinkedListLookUp(2);
        Node newNode = new Node(71);
        list.LinkedListInsertAfter(previous, newNode);
        list.printList();  // 10->20->30->71->40->50->/

        //  Eliminar nodo en índice 3 (71)
        list.LinkedListDelete(3);
        list.printList();  // 10->20->30->40->50->/
    }
}
