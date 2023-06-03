import util.Node;

import java.util.HashMap;

public class LinkedLists {

    public void removeDuplicates(Node head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while(head != null) {
            map.put(head.data, 1);
            if(head.next != null) {
                if(map.get(head.next.data) != null) {
                    head.next = head.next.next;
                }
            }
            head = head.next;
        }
    }

    public int kthToLast(Node head, int k) {
        Node current = head;
        int length = 0;

        while(current != null) {
            length++;
            current = current.next;
        }

        int target = length - k;
        int count = 0 ;
        Node temp = head;
        while(count != target && temp != null) {
            temp = temp.next;
            count++;
        }

        assert temp != null;
        return temp.data;

    }

}
