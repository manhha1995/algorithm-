import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStack<T> {
    private AtomicReference<Node<T>> head = new AtomicReference<>();
    private AtomicInteger counter = new AtomicInteger(0);
    public void push(T value) {
        Node<T> newNode = new Node<>(value);

        while (true) {
            Node<T> currentHead = head.get();
            newNode.next = currentHead;
            if (head.compareAndSet(currentHead, newNode)) {
                return;
            } else {
                Thread.yield(); // Backoff strategy
                LockSupport.parkNanos(1);
            }
            counter.getAndIncrement();
        }

    }

    public T pop() {
        while (true) {
            Node<T> currentHead = head.get();
            if (currentHead == null) {
                return null; // Stack is empty
            }

            Node newHead = currentHead.next;
            if (head.compareAndSet(currentHead, newHead)) {
                return currentHead.value;
            } else {
                Thread.yield(); // Backoff strategy
                LockSupport.parkNanos(1);
            }
        }
    }

    public int getCounter() {
       return counter.get();
    }

    class Node<T> {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }
}