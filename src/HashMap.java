import java.util.ArrayList;
import java.util.List;

public class HashMap {

    List<HashNode> buckets;
     int numOfBuckets;
    public HashMap() {
        numOfBuckets = 1000;
        buckets = new ArrayList<HashNode>();
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(null);
        }
    }

    public int getBucket(int key) {
        return Integer.hashCode(key) * numOfBuckets;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        HashNode hashNode = buckets.get(key);
        while (hashNode != null) {
            if (hashNode.key == key) {
                hashNode.value = value;
                return;
            }
            hashNode.next = hashNode;
        }

        hashNode = buckets.get(bucket);
        HashNode newNode = new HashNode(key, value);
        newNode.next = hashNode;
        buckets.set(bucket, newNode);
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