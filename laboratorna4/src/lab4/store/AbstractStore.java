package lab4.store;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class AbstractStore implements Iterable <Object> {
    protected int count = 0;
    protected Object[] arr = new Object[3];

    public Object[] getArr() {
        return Arrays.copyOf(arr,count);
    }

    public int getCount(){
        return count;
    }

    protected void add(Object newObject){
        //Запобігаємо переповнення масиву
        if(arr.length == count)
            arr = Arrays.copyOf(arr, count + count/2);
        //Додаємо новий елемент
        arr[count++] = newObject;
    }

    public  String toString(){
        StringBuilder sb = new StringBuilder();
        for (Object obj : this) {
            sb.append(obj).append("\n");
        }
        return  sb.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new StoreIterator();
    }

    private class StoreIterator implements Iterator<Object>{
        //Індекс поточного елементу масиву
        int current =0;
        @Override
        public boolean hasNext() {
            //count - це кількість елементів у масиві
            return current<count;
        }
        @Override
        public Object next() {
            return arr[current++];
        }
        @Override
        public void remove(){
            System.arraycopy(arr,current,arr,current-1,count-- -current--);
        }
    }
    public ListIterator<Object> listIterator(){
        return new ListStoreIterator();
    }

    private class ListStoreIterator extends StoreIterator implements ListIterator<Object>{

        @Override
        public boolean hasPrevious() {
            return current>0;
        }

        @Override
        public Object previous() {
            return arr[current--];
        }

        @Override
        public int nextIndex() {
            return current+1;
        }

        @Override
        public int previousIndex() {
            return current-1;
        }

        @Override
        public void set(Object o) {
            arr [current]=0;
        }

        @Override
        public void add(Object o) {
            if (current == arr.length - 1){
                arr = Arrays.copyOf(arr, arr.length + 1);
            }
            System.arraycopy(arr,current,arr, current + 1, count - current);
            arr[current] = o;
            current++;
            count++;
        }
    }
}
