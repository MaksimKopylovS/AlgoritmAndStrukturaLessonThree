package max_sk.task_one.queue;

import java.util.Scanner;

public class QueueImpl<E> implements Queue<E> {

    private static final int HEAD_DEFAULT = 0;
    private static final int TAIL_DEFAULT = -1;

    private final E[] data;
    private int size;

    private int tail;
    private int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }
        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (head == data.length) {
            head = HEAD_DEFAULT;
        }
        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        QueueImpl<String> queue = new QueueImpl(5);
        String str;
        int number;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите строку для помещения в очередь");
            str = scanner.next();
            queue.insert(str);
            if (queue.isFull()) {
                System.out.println("Очередь заполнена");
                break;
            }
        }
        while (true) {
            System.out.println("1 для получения значения из очереди\n" + "2 для выхода");
            number = scanner.nextInt();
            if (number == 1) {
                System.out.println(queue.remove());
            }
            if (number == 2) {
                break;
            }
        }
    }
}
