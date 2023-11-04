package labs1;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public final class IntegerArray{
    private int[] arr;

    public IntegerArray(){
        this.arr = null;
    }
    public IntegerArray(int v){
        this.arr=new int[v];
    }
    public IntegerArray(int[] arr) {
        this.arr = arr;
    }
    public int length(){
        return arr.length;
    }

    public int getElementAt(int i){
        if(i < 0 || i > length()-1){
            return 0;
        }
        else{
            return arr[i];
        }
    }

    public int sum(){
        int sum = 0;
        for (int i=0; i<length()-1; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public double average(){
        return (double)sum()/(double)length();
    }

    public IntegerArray getSorted(){
        IntegerArray newArr= new IntegerArray(this.arr);
        Arrays.sort(newArr.arr);
        return newArr;
    }

    public IntegerArray concat(IntegerArray ia){
        IntegerArray newArr = new IntegerArray();
        newArr.arr= Arrays.copyOf(this.arr, this.length()+ia.length());
        for (int j=0, i=this.length(); i<this.length()+ia.length(); i++){
            newArr.arr[i]=ia.arr[j++];
        }
        return newArr;
    }
    public void add(int value) {
        int[] newArray = Arrays.copyOf(arr, arr.length + 1);
        newArray[arr.length] = value;
        arr = newArray;
    }

    @Override
    public String toString() {
        return '[' + Arrays.toString(arr) + ", " + "]";
    }
}

final class ArrayReader{
    public static IntegerArray readIntegerArray(InputStream input){
        Scanner sc = new Scanner(input);
        int num=sc.nextInt();
        IntegerArray arrej = new IntegerArray(num);
        for (int i=0; i<num; i++){
            int val=sc.nextInt();
            arrej.add(val);
        }
        return arrej;
    }
}
