package LinkedList;


// Customized LinkedList for polynomials
public class SingleLinkedList {
    private Node first;

    public SingleLinkedList() {
        first = null;
    }

    public Node getFirst() {
        return first;
    }

//    public boolean insertAtFront(double coff, int exp) {
//        try {
//            Node newNode = new Node(coff, exp);
//            newNode.next = first;
//            first = newNode;
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public boolean insert(double coff, int exp) {
        try {
            Node newNode = new Node(coff, exp);
            if (first == null) {
                first = newNode;
                return true;
            } else {
                Node runningNode = first;

                while (runningNode != null) {
                    if (runningNode.exp == newNode.exp) {
                        runningNode.coff = runningNode.coff + newNode.coff;
                        return true;
                    }

                    if (runningNode.next == null) {
                        runningNode.next = newNode;
                        return true;
                    } else
                        runningNode = runningNode.next;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertionSort() {
        Node ptr1 = first;
        Node ptr2;
        Node temp = new Node();

        while (ptr1 != null) {
            ptr2 = ptr1.next;
            while (ptr2 != null) {
                if (ptr1.exp < ptr2.exp) {
                    temp.coff = ptr1.coff;
                    temp.exp = ptr1.exp;

                    ptr1.coff = ptr2.coff;
                    ptr1.exp = ptr2.exp;

                    ptr2.coff = temp.coff;
                    ptr2.exp = temp.exp;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    public void display() {
        try {
            insertionSort();
            Node runningNode = first;
            while (runningNode != null) {
                if (runningNode.exp == 0) {
                    System.out.print(runningNode.coff);
                } else {
                    System.out.print(runningNode.coff + "x^" + runningNode.exp);
                }
                runningNode = runningNode.next;
                if (runningNode != null) {
                    System.out.print(" + ");
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        String result = "";
        try {
            insertionSort();
            Node runningNode = first;
            while (runningNode != null) {
                if (runningNode.exp == 0) {
                   result += runningNode.coff;
                } else {
                    result += runningNode.coff + "x^" + runningNode.exp;
                }
                runningNode = runningNode.next;
                if (runningNode != null) {
                    result += " + ";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
