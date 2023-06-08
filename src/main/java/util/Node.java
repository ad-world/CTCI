package util;

public class Node {
    public Node next = null;
    public int data;

    public Node(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    public void appendToTail(Node d) {
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }

        n.next = d;
    }

    public String getListString() {
        Node n = this;
        StringBuilder builder = new StringBuilder();

        while(n != null) {
            builder.append(n.data).append(' ');
            n = n.next;
        }

        return builder.toString().trim();
    }

    public Node findFirst(int n) {
        Node node = this;
        while(node != null) {
            if(node.data == n) return node;
            node = node.next;
        }

        return null;
    }

    public int length() {
        int length = 0;
        Node n = this;
        while(n != null) {
            length++;
            n = n.next;
        }

        return length;
    }

}
