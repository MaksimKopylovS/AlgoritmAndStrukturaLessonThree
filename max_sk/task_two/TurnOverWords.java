package max_sk.task_two;

import max_sk.task_one.steck.StackImpl;

import java.util.Scanner;

public class TurnOverWords {

    public static void main(String[] args) {
        Scanner sccaner = new Scanner(System.in);
        String words = null;

        System.out.println("Введите строку");
        words = sccaner.next();

        String[] arrWords = words.split("");

        StackImpl stack = new StackImpl(arrWords.length);

        for(int i = 0; i < arrWords.length; i++ ){
            stack.push(arrWords[i]);
        }

        for(int i = 0; i < arrWords.length; i ++){
            System.out.print(stack.pop());
        }

    }
}
