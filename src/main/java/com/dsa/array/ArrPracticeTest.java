package com.dsa.array;

public class ArrPracticeTest {

    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        int n = arr.length;
        for (int i = n-2;i >= 0;i--){
            System.out.println(i +","+ (i+1));
        }
    }

}
