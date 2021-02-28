package lab2.store;

import lab2.model.IWeight;

import java.util.Arrays;

public class AbstractStore {
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
        for (int i = 0; i < count; i++) {
            sb.append(arr[i]).append("\n");
        }
        return  sb.toString();
    }
}
