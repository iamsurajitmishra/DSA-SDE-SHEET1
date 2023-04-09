package com.dsa.array;

import java.util.ArrayList;
import java.util.Collections;

public class FindFactorialOfLargeNumber {




    /*
    #Approach :





     */

    static ArrayList<Integer> factorial(int N){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i<=N; i++){

            int k = 0;
            int carry = 0;
            while(k<list.size()){
                int tmp = (list.get(k) * i) + carry;
                list.set(k, (tmp%10));
                carry = tmp/10;
                k++;
            }


            while(carry != 0){
                list.add(carry%10);
                carry/=10;
            }

        }

        Collections.reverse(list);

        return list;
    }



}
