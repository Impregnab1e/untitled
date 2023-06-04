package Lesson4;
import java.util.LinkedList;
//Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
//dequeue() - возвращает первый элемент из очереди и удаляет его,
//first() - возвращает первый элемент из очереди, не удаляя.


public class Task2<T> {
    private LinkedList<T> queue;


//Конструктор класса Task2 инициализирует внутреннюю LinkedList.
    public Task2() {
        queue = new LinkedList<>();
    }


//Метод enqueue добавляет элемент в конец очереди.
    public void enqueue(T element) {
        queue.addLast(element);
    }

// Метод dequeue возвращает и удаляет первый элемент из очереди.
    public T dequeue() {
        return queue.pollFirst();
    }


//Метод first возвращает первый элемент из очереди без удаления.
    public T first() {
        return queue.peekFirst();
    }

//Метод isEmpty проверяет, является ли очередь пустой.
    public boolean isEmpty() {
        return queue.isEmpty();
    }


//Метод size возвращает текущий размер очереди.
    public int size() {
        return queue.size();
    }

//Метод display выводит список элементов в очереди.
    public void display() {
        System.out.println("Elements in the queue: " + queue);
    }

    public static void QueueUsingLinkedList() {
        Task2<Integer> queue = new Task2<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Size of the queue: " + queue.size());

        System.out.println("First element: " + queue.first());

        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("First element after dequeue: " + queue.first());

        queue.display();

        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}