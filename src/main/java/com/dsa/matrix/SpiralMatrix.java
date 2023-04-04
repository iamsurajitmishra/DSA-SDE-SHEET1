package com.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
     Problem : Traverse a matrix spirally.


     */

    public static void main(String[] args) {
            int mat[][] = {
                    {10,20,30,40},
                    {15,25,35,45},
                    {27,29,37,48},
                    {32,33,39,40}
            };

            List<Integer> list = spiralOrderTraversal(mat);
            list.stream().forEach(x -> System.out.print(x+" "));
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static List<Integer> spiralOrderTraversal(int[][] mat){
        List<Integer> res = new ArrayList<>();
        if(mat.length == 0){
            return res;
        }

        int row = mat.length;
        int col = mat[0].length;

        boolean[][] visited = new boolean[row][col];

        // Moving direction
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int x = 0, y = 0, di = 0;

        // tracerse all element in the matrix
        for (int i = 0;i<(row * col); i++){
            res.add(mat[x][y]);
            visited[x][y] = true;

            int cr = x + dr[di];
            int cc = y + dc[di];

            // If the element is inside
            if (0<=cr && cr<row && 0 <= cc && cc<col && !visited[cr][cc]){
                x = cr;
                y = cc;
            } else{
                //rotating the direction
                di = (di+1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return res;
    }
}
