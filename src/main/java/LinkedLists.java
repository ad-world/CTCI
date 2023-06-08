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

    public void deleteMiddleNode(Node node) {
        if(node == null || node.next == null) {
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }

    public void partition(Node head, int x) {
        Node slow = null;
        Node fast = head;

        // idea: let the fast runner find a node >= x
        // slow runner = node that fast found
        // from fast, find another node that < x
        // swap data

        while(fast != null) {
            if(slow == null && fast.data >= x) {
                slow = fast;
            }

            if(slow != null && fast.data < x) {
                int temp = slow.data;
                slow.data = fast.data;
                fast.data = temp;

                fast = head;
                slow = null;
            }

            fast = fast.next;
        }
    }

    public Node sumLists(Node first, Node second) {
        boolean currentCarryover = false;
        int firstLength = 0;
        int secondLength = 0;
        Node head1 = first;
        Node head2 = second;

        while(head1 != null) {
            firstLength++;
            head1 = head1.next;
        }

        while(head2 != null) {
            secondLength++;
            head2 = head2.next;
        }

        Node longest = firstLength > secondLength ? first : second;
        Node shortest = firstLength > secondLength ? second : first;

        Node newList = new Node(123123123);

        while(longest != null) {
            int sum = longest.data + (shortest != null ? shortest.data : 0);
            if (currentCarryover) {
                sum += 1;

                if(sum >= 10) {
                    // keep current carryover as is
                    newList.appendToTail(sum - 10);
                } else {
                    newList.appendToTail(sum);
                    currentCarryover = false;
                }
            } else {
                if(sum >= 10) {
                    newList.appendToTail(sum - 10);
                    currentCarryover = true;
                } else {
                    newList.appendToTail(sum);
                }
            }

            longest = longest.next;
            if(shortest != null) {
                shortest = shortest.next;
            }
        }

        if(currentCarryover) {
            newList.appendToTail(1);
        }

        return newList.next;
    }
}
