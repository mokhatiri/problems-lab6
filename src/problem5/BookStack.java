package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        this.stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addFirst(book);
    }

    public Book pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.removeFirst();
    }

    public Book peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book b : stack) {
            System.out.println(" - " + b);
        }
    }
}
