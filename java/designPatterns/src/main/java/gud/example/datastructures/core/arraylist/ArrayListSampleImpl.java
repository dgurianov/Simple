package gud.example.datastructures.core.arraylist;



import java.util.Arrays;

public class ArrayListSampleImpl {
}

class MyArrayList<E>{
    private int size ;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e){
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e;
    }
    private void ensureCapacity(){
        int newSize = elements.length * 2 ;
        elements = Arrays.copyOf(elements,newSize);
    }
    @SuppressWarnings("unchecked")
    public  E get(int i ){
        if(i>= size || i<0){
            throw  new IndexOutOfBoundsException("Index"+i+", Size "+i);
        }
        return (E) elements[i];
    }
}