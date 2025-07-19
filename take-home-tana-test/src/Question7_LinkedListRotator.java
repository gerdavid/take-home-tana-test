class ListNode {
    String val;
    ListNode next;

    ListNode(String val) {
        this.val = val;
    }
}

public class Question7_LinkedListRotator {

    // Rotates the linked list to the right by k steps.
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // Nothing to do
        }

        // First, find the length of the list and the last node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make it circular by connecting tail to head
        tail.next = head;

        // Figure out where the new head should be
        k = k % length; // Don't over-rotate
        int stepsToNewHead = length - k;

        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Break the cycle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Builds a linked list from an array of strings
    public static ListNode buildList(String[] items) {
        if (items.length == 0) return null;

        ListNode head = new ListNode(items[0]);
        ListNode current = head;

        for (int i = 1; i < items.length; i++) {
            current.next = new ListNode(items[i]);
            current = current.next;
        }

        return head;
    }

    // Displays the list in readable format
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            } else {
                System.out.print(" -> null");
            }
        }
        System.out.println();
    }

    // ------------------- Test Example -------------------

    public static void main(String[] args) {
        String[] data = {"ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"};

        ListNode original = buildList(data);
        System.out.print("Original list: ");
        printList(original);

        ListNode rotated = rotateRight(original, 2);
        System.out.print("After rotating right by 2: ");
        printList(rotated);
    }
}
