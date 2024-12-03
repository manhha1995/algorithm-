public class LinkedList {
    int val;
    LinkedList node;
    public LinkedList() {
        this.val = 0;
        this.node = null;
    }

    public int get(int index) {
        LinkedList current = node;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.val;
            }
            current = current.node;
            count++;
        }

        return -1;
    }

    public void addAtHead(int val) {
        LinkedList node = null;
        node = new LinkedList();
        node.val = val;
        node.node = null;
    }

    public void addAtTail(int val) {
        LinkedList node = null;
        node = new LinkedList();
        node.val = val;
        node.node = null;
    }

    public void addAtIndex(int index, int val) {
        LinkedList node = null;
        if (index == 0) {
            LinkedList newNode = new LinkedList();
            newNode.val = val;
            newNode.node = node;
            node = newNode;
        } else {
            LinkedList current = node;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    LinkedList newNode = new LinkedList();
                    newNode.val = val;
                    newNode.node = current.node;
                    current.node = newNode;
                    break;
                }
                current = current.node;
                count++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        LinkedList node = null;
        if (index == 0) {
            LinkedList newNode = new LinkedList();
            node = newNode.node;
        } else {
            LinkedList current = node;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    current.node = current.node.node;
                    break;
                }
                current = current.node;
                count++;
            }
        }
    }
}
