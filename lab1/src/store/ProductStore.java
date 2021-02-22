package store;

import model.Timber;

import java.util.Arrays;

public class ProductStore {
    private int count =0;
    private Timber[] arr=new Timber[3];
    public void add(Timber newTimber)
    {

        if(arr.length==count)
        {
            arr= Arrays.copyOf(arr,count+count/2);
        }
        arr[count++]=newTimber;

    }

    public Timber[] getArr() {
        return Arrays.copyOf(arr,count);
    }

    @Override
    public String toString() {
        return "ProductStore{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

}
