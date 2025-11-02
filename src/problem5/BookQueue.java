package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue(){
        this.queue = new LinkedList<>();
    }

    public void enqueue(Book book) {
        queue.addLast(book);
    }

    public Book dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queue.removeFirst();
    }

    public Book peek() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        for (Book b : queue) {
            System.out.println(" - " + b);
        }
    }
}
