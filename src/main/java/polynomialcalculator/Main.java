package polynomialcalculator;

import LinkedList.Node;
import LinkedList.SingleLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        window();
    }

    public static void window() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char choice, option = 'n';
        String poly1, poly2;
        SingleLinkedList result = null;
        SingleLinkedList polyList1 = new SingleLinkedList();
        SingleLinkedList polyList2 = new SingleLinkedList();


        System.out.println("Polynomial Calculator\n");
        do {
            if (option == 'n' || option == 'N') {
                System.out.println("Enter your first polynomial: ");
                poly1 = reader.readLine();
            } else {
                poly1 = result.toString();
                System.out.println("polynomial 1: " + poly1);
            }
            System.out.println("Enter your second polynomial: ");
            poly2 = reader.readLine();

            System.out.println("Enter your choice: \n" +
                    "\t 1. Add\n" +
                    "\t 2. Subtract\n" +
                    "\t 3. Multiply\n" +
                    "\t 4. Evaluate\n" +
                    "\t 5. Exit");
            choice = reader.readLine().charAt(0);

            switch (choice) {
                case '1':
                    polyList1 = newPolynomial(poly1);
                    polyList2 = newPolynomial(poly2);
                    if (polyList1 == null || polyList2 == null)
                        break;
                    result = add(polyList1, polyList2);
                    System.out.println("Result: " + result.toString());
                    break;
                case '2':
                    polyList1 = newPolynomial(poly1);
                    polyList2 = newPolynomial(poly2);
                    if (polyList1 == null || polyList2 == null)
                        break;
                    result = sub(polyList1, polyList2);
                    System.out.println("Result: " + result.toString());
                    break;
                case '3':
                    polyList1 = newPolynomial(poly1);
                    polyList2 = newPolynomial(poly2);
                    if (polyList1 == null || polyList2 == null)
                        break;
                    result = multiply(polyList1, polyList2);
                    System.out.println("Result: " + result.toString());
                    break;
                case '4':
                    do {
                        System.out.println("choose the polynomial you want to evaluate: \n" +
                                "\t 1. " + poly1.toString() + "\n" +
                                "\t 2. " + poly2.toString() + "\n");
                        choice = reader.readLine().charAt(0);
                    } while (choice != '1' && choice != '2');

                    System.out.println("Enter the value of x: ");
                    double x = Double.parseDouble(reader.readLine());

                    if (choice == '1') {
                        polyList1 = newPolynomial(poly1);
                        if (polyList1 == null)
                            break;
                        else
                            System.out.println("Result: " + evaluate(x, polyList1));
                    } else {
                        polyList2 = newPolynomial(poly2);
                        if (polyList2 == null)
                            break;
                        else
                            System.out.println("Result: " + evaluate(x, polyList2));
                    }
                    break;
                case '5':
                    System.out.println("Thank you for using the Polynomial Calculator.");
                    System.out.println("Exiting...");
                    break;
            }

            if (polyList1 != null && polyList2 != null) {
                do {
                    System.out.println("Enter your choice: \n" +
                            "\t y. Continue with the result polynomial\n" +
                            "\t n. Continue with a new polynomial\n" +
                            "\t q. Exit");
                    option = reader.readLine().charAt(0);
                } while (option != 'y' && option != 'Y' && option != 'n' && option != 'N' && option != 'q' && option != 'Q');
            }

        } while (choice != '5' && option != 'q' && option != 'Q');
    }

    public static SingleLinkedList add(SingleLinkedList poly1, SingleLinkedList poly2) {
        poly1.insertionSort();
        poly2.insertionSort();

        SingleLinkedList result = new SingleLinkedList();
        Node ptr1 = poly1.getFirst();
        Node ptr2 = poly2.getFirst();
//        Node adder;

        while (ptr2 != null || ptr1 != null) {
            if (ptr2.exp > ptr1.exp) {
                result.insert(ptr2.coff, ptr2.exp);
                ptr2 = ptr2.next;
            } else if (ptr1.exp > ptr2.exp) {
                result.insert(ptr1.coff, ptr1.exp);
                ptr1 = ptr1.next;
            } else {
                result.insert(ptr1.coff + ptr2.coff, ptr1.exp);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            if (ptr1 == null) {
                while (ptr2 != null) {
                    result.insert(ptr2.coff, ptr2.exp);
                    ptr2 = ptr2.next;
                }
            } else if (ptr2 == null) {
                while (ptr1 != null) {
                    result.insert(ptr1.coff, ptr1.exp);
                    ptr1 = ptr1.next;
                }
            }
        }
        return result;
    }

    public static SingleLinkedList sub(SingleLinkedList poly1, SingleLinkedList poly2) {
        poly1.insertionSort();
        poly2.insertionSort();

        SingleLinkedList result = new SingleLinkedList();
        Node ptr1 = poly1.getFirst();
        Node ptr2 = poly2.getFirst();
//        Node adder;

        while (ptr2 != null || ptr1 != null) {
            if (ptr2.exp > ptr1.exp) {
                result.insert(ptr2.coff, ptr2.exp);
                ptr2 = ptr2.next;
            } else if (ptr1.exp > ptr2.exp) {
                result.insert(ptr1.coff, ptr1.exp);
                ptr1 = ptr1.next;
            } else {
                result.insert(ptr1.coff - ptr2.coff, ptr1.exp);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            if (ptr1 == null) {
                while (ptr2 != null) {
                    result.insert(ptr2.coff, ptr2.exp);
                    ptr2 = ptr2.next;
                }
            } else if (ptr2 == null) {
                while (ptr1 != null) {
                    result.insert(ptr1.coff, ptr1.exp);
                    ptr1 = ptr1.next;
                }
            }
        }
        return result;
    }

    public static SingleLinkedList multiply(SingleLinkedList poly1, SingleLinkedList poly2) {
        poly1.insertionSort();
        poly2.insertionSort();

        SingleLinkedList result = new SingleLinkedList();
        Node ptr1 = poly1.getFirst();
        Node ptr2 = poly2.getFirst();


        while (ptr1 != null) {
            result.insert(ptr1.coff * ptr2.coff, ptr1.exp + ptr2.exp);
            ptr2 = ptr2.next;
            if (ptr2 == null) {
                ptr2 = poly2.getFirst();
                ptr1 = ptr1.next;
            }
        }
        return result;
    }

    public static SingleLinkedList newPolynomial(String poly) {
        poly = poly.replaceAll("\\s+", "");
        poly = poly.replaceAll("X", "x");
        poly = poly.replaceAll("x\\^", "&") + "#"; // # is used as a terminator for the end of the string
        System.out.println("Checking for errors in the polynomial...");

        SingleLinkedList result = new SingleLinkedList();
        Node variableNode = new Node();
        String var = "";
        int mode = 1;
        char ch;

        try {
            for (int i = 0; i < poly.length(); i++) {
                ch = poly.charAt(i);
                if (Character.isDigit(ch) || ch == '.') {
                    var += ch;
                    if ((mode == 1) && ((poly.charAt(i + 1) == '+') || (poly.charAt(i + 1) == '-') || (poly.charAt(i + 1) == '#'))) {
                        variableNode.exp = 0;
                        variableNode.coff = Double.parseDouble(var);
                        result.insert(variableNode.coff, variableNode.exp);
                        var = "";
                        i++;
                    }
                } else if (ch == '&') {
                    if (var == "")
                        var = "1";
                    variableNode.coff = Double.parseDouble(var);
                    var = "";
                    mode = 2;
                } else if (ch == '+' || ch == '-' || ch == '#') {
                    if (var == "")
                        var = "1";
                    variableNode.exp = Integer.parseInt(var);
                    result.insert(variableNode.coff, variableNode.exp);
                    var = "";
                    mode = 1;
                } else if (ch == 'x') {
                    if (var == "")
                        var = "1";
                    variableNode.coff = Double.parseDouble(var);
                    var = "";
                    mode = 2;
                } else {
                    System.out.println("ERROR: Invalid input character '" + ch + "' at position " + (i + 1) + " in the string.\n");
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: Invalid Input\n");
            e.printStackTrace();
            return null;
        }
        System.out.println("Polynomial is valid.\n");
        return result;
    }

    public static double evaluate(double x, SingleLinkedList poly) {
        double result = 0;
        Node ptr = poly.getFirst();
        while (ptr != null) {
            result += ptr.coff * Math.pow(x, ptr.exp);
            ptr = ptr.next;
        }
        return result;
    }
}
