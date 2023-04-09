package com.dsa.array;

import java.util.HashMap;

/*

Test Case: 1
Input:
a1[] = {11, 1, 13, 21, 3, 7}
a2[] = {11, 3, 7, 1}
Output:
Yes
Explanation:
a2[] is a subset of a1[]


Test Case: 2
Input:
a1[] = {1, 2, 3, 4, 5, 6}
a2[] = {1, 2, 4}
Output:
Yes
Explanation:
a2[] is a subset of a1[]


 */
public class IsArraySubsetOfAnotherArr {

    public static void main(String[] args) {

        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        System.out.println(isSubSet(arr1,arr2, arr1.length, arr2.length));
    }


    /*
        #Approach: (brute-force)
     */

    public static boolean isSubSet(int arr1[], int arr2[], int m, int n){

        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if(arr2[i] == arr1[j]){
                    break;
                }
                /*

          If the above inner loop
          was not broken at all then
          arr2[i] is not present in
          arr1[]


                 */
                if (j == m){
                    return false;
                }

            }
        }
        return true;
    }

    /*
    #Approach: (sorting)


     */









    /*
    #Approach : (Hashing)

     */

    public String isSubset( long a1[], long a2[], long n, long m) {

        HashMap<Long,Long> map = new HashMap<>();
        if(m>n){
            return "No";
        }

        for(long i : a1){
            map.put(i,map.getOrDefault(i,0L)+1L);
        }

        for(long i : a2){
            if(map.containsKey(i)){
                if(map.get(i)>1){
                    map.put(i,map.get(i)-1);
                }else{
                    map.remove(i);
                }
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
