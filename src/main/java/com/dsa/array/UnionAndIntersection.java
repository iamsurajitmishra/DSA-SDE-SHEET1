package com.dsa.array;

/*

Prob : Given two arrays find union and intersection.

Input: arr1[] = {1, 3, 4, 5, 7}
        arr2[] = {2, 3, 5, 6}
Output: Union : {1, 2, 3, 4, 5, 6, 7}
         Intersection : {3, 5}

Input: arr1[] = {2, 5, 6}
        arr2[] = {4, 6, 8, 10}
Output: Union : {2, 4, 5, 6, 8, 10}
         Intersection : {6}

 */


import java.util.*;

public class UnionAndIntersection {

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 2, 2, 3 };
        int arr2[] = { 2, 3, 4, 5 };

        /*
           Union testing --------------------------------------------------------------------------------------
         */
        // approach1
        System.out.println(Arrays.toString(union(arr1,arr2)));

        //approach2
        unionNoDuplicates(arr1,arr2,arr1.length,arr2.length);

        System.out.println();
        //approach3
        getUnion(arr1,arr2,arr1.length,arr2.length).stream().forEach(x-> System.out.print(x+" "));

        System.out.println();
        //approach4
        findUnion(arr1,arr2,arr1.length,arr2.length).stream().forEach(x -> System.out.print(x+" "));
        System.out.println();

        /*
             Intersection testing --------------------------------------------------------------------------
         */
        intersection(arr1, arr2, arr1.length, arr2.length);
        System.out.println();
        findIntersection(arr1, arr2, arr1.length, arr2.length);

    }

    /*
        prob : Intersection
        #Approach1 : Two Pointer
               TC : O(m+n)
               SC : O(1)
     */

    public static void intersection(int[] arr1, int[] arr2, int m,int n){
        int i = 0, j = 0;
        // Scan elemnts of arr1 and arr2
        while(i<m && j<n){
            if(arr1[i] <arr2[j]){
                i++;
            }else if(arr2[j]<arr1[i]){
                j++;
            }else{
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

    /*
       Prob : Intersection
       #Approach2: Using hashing ( handle duplicates)
            TC  : O(m+n)
            SC  : O(m+n)
     */

    public static  void findIntersection(int[] arr1, int[] arr2, int m , int n){
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();

        while(i<m && j<n){
            if (arr1[i]<arr2[j]){
                i++;
            }else if (arr1[i]>arr2[j]){
                j++;
            }else {

                if (!set.contains(arr1[i])){
                    set.add(arr1[i]);
                }
                i++; j++;
            }
        }
        for (int e: set){
            System.out.print(e+" ");
        }

    }

    /*
         @Approach4 : using HashMap [<Key,Value>] [ Handle duplicates]
         #Algo:
         1. map<element, count>
         2. print the keyset

        TC = O(m+n)
        SC = O(min(m,n))
     */

     public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int m, int n){
         HashMap<Integer, Integer> map = new HashMap<>();
         ArrayList<Integer> list = new ArrayList<>();

         // Check in first array if any duplicate elemnt is present
         for (int i= 0;i<m;i++){
             if (map.containsKey(arr1[i])){
                 map.put(arr1[i], map.get(arr1[i])+1);
             }else{
                 map.put(arr1[i],1);
             }
         }

         // check in the second array
         for (int j = 0;j<n;j++){
             if(map.containsKey(arr2[j])){
                 map.put(arr2[j], map.get(arr2[j]+1));
             }else {
                 map.put(arr2[j],1);
             }
         }

         for (int k: map.keySet()){
             list.add(k);
         }

        return list;

     }


    /*
       @Approach3 : using TreeSet [does not allow duplicates and insert leemnts in sorted order] [handle duplicates]
           #Algo :
           1.Add all elements of arr1 into  treeset and all elements of arr2 into treeset
           2.Add all the elements into a list
           3.print(list)

        TC -> O(m+n) [ where m is the size of arr1 and n is the size of arr2]
        SC -> O( m*log(m) + n*log(n) ) [adding element into treeset took log(n) time, to add n number of elements will take n*Log(n) time]

     */

    public static ArrayList<Integer> getUnion(int[] arr1, int[] arr2, int m, int n){
        TreeSet<Integer> tset = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        // add all elemnts of arr1 to tset
        for(int i: arr1){
            tset.add(i);
        }

        // add all elements of arr2 to tset
        for (int j : arr2){
            tset.add(j);
        }

        for (int k : tset){
            list.add(k);
        }

        return list;
    }




    /*
      @Approach2 :
      Algo : Two pointer algo with handling duplicates
          TC : O(l1+l2)
          SC : O(n)

      drawback - size range restriction is always is there
     */

    public static void unionNoDuplicates(int[] arr1,int[] arr2, int m,int n){

        int size = 0;

        // finding the bigger length of arrays
        if(m>n){
            size = m;
        }else{
            size = n;
        }

        int[] narr = new int[size+1];

        //printing the first element
        System.out.print(arr1[0]+" ");
        //incrementing the first index count
        ++narr[arr1[0]];


        //Scan the first arra
        for(int i = 1;i<m;i++){
            if(arr1[i] != arr1[i-1]){
                System.out.print(arr1[i]+ " ");
                ++narr[arr1[i]];
            }
        }


        //scan the second array

        for(int j = 0;j<n;j++){
            if(narr[arr2[j]] == 0){
                System.out.print(arr2[j]+" ");
                ++narr[arr2[j]];
            }
        }



    }






    /*
    @Approach1 :
    Algo : Two pointer algo
        # This algo does not handle the duplicates

        If the arr1 has the m size and arr2 has n size then,
        Time complexity - O(m+n)

     */
    public static int[] union(int[] arr1,int[] arr2){
        int i = 0, j =0, k = 0;
        int s1 = arr1.length;
        int s2 = arr2.length;

        int uni[] = new int[s1+s2];

        while(s1<s2){
            if (arr1[i] < arr2[j]){
                uni[k] = arr1[i];
                k++;
                i++;
            }else if(arr1[i] > arr2[j]){
                uni[k] = arr2[j];
                k++;
                j++;
            }else{
                uni[k] = arr1[i];
                k++;i++;j++;
            }
        }

        //print the remaining element of array 1
        while(i<s1){
            uni[k] = arr1[i];
            i++; k++;
        }
        // print the remaining element of array 2
        while(j < s2){
            uni[k] = arr2[j];
            j++;k++;
        }

        return uni;
    }



}
