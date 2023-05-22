package LinkedList;

import java.text.NumberFormat;

public class Node{
    public double coff;
    public int exp;
    public Node next;

    public Node() {
        this.coff = 0;
        this.exp = 0;
        this.next = null;
    }

    public Node(double coff, int exp) {
        this.coff = coff;
        this.exp = exp;
        this.next = null;
    }
}
