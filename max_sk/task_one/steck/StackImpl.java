package max_sk.task_one.steck;

import java.util.Scanner;

public class StackImpl<E> implements Stack<E> {

    public static void main(String[] args) {
        String str;
        int number;
        Stack<String> stack = new StackImpl(5);
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Введите строку для добовления в Стек");
            str = scanner.next();
            stack.push(str);
            if (stack.isFull()){
                System.out.println("Стек заполнен");
                break;
            }
        }

        while (true){
            System.out.println("1 для получения значения из очереди\n" + "2 для выхода");
            number = scanner.nextInt();

            if (number == 1){
                System.out.println(stack.pop());
                if (stack.isEmpty()){
                    System.out.println("Стек пуст");
                    break;
                }
            }
            if (number == 2){
                break;
            }

        }
    }

    private final E[] data;
    private int size;

    public StackImpl(int maxSize){
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void push(E value) {
        data[size++] = value;
    }

    @Override
    public E pop() {
        E value = peek();
        data[--size] = null;
        return value;
    }

    @Override
    public E peek() {
        return data[size - 1];
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

    @Override
    public void display() {
        System.out.println(this);
    }
}
