package max_sk.task_one.queue;

public interface Queue<E>{
    boolean insert(E value);

    E remove();

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();
}
