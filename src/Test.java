import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Test {
    public static void main(String[] args) {
        Integer[] array = {1,4,6,8,2,3,9,0,5};
        BubbleSortTest<Integer> bst = new BubbleSortTest();
        bst.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

class GenericStack<E>{
    private E[] array;
    int index;

    public GenericStack(int size){
        this.array = (E[])(new Object[size]);
        index = 0;
    }

    public void push(E element){
        if(index == array.length){
            System.out.println("Stack is full!");
            return;
        }

        array[index++] = element;
    }

    public E pop(){
        if(index == 0 ){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return array[--index];
    }
}

class BubbleSortTest<E extends Comparable<E>>{

    public void sort(E[] array){
        int n = array.length;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n-i-1; j++ )
                if(array[j].compareTo(array[j+1]) > 0) {
                    E temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
        Arrays.toString(array);

    }
}
