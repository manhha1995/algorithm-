import java.util.ArrayList;
import java.util.List;

public class HashMap {

    private static final int DEFAULT_CAPACITY = 1000;
    private static final double LOAD_FACTOR = 0.75;

    private List<HashNode> buckets;
    private int numOfBuckets;
    private int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        numOfBuckets = capacity;
        buckets = new ArrayList<>(numOfBuckets);
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
    }

    private int getBucketIndex(int key) {
        return Math.abs(key) % numOfBuckets;
    }

    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets.get(bucketIndex);
        HashNode newNode = new HashNode(key, value);

        // If the key already exists, update its value
        HashNode current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Key doesn't exist, add new node at the beginning of the list
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        size++;

        // Check if rehashing is needed
        if ((1.0 * size) / numOfBuckets >= LOAD_FACTOR) {
            rehash();
        }
    }

    private void rehash() {
        List<HashNode> temp = buckets;
        buckets = new ArrayList<>(numOfBuckets * 2);
        numOfBuckets *= 2;
        size = 0;

        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(null);
        }

        for (HashNode headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }
}

class HashNode {
    int key;
    int value;

    HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}