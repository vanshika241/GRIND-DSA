// Question - You are given a 2D matrix mat[][] of size n x m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0.

// Constraints:
// 1 ≤ n, m ≤ 500
// - 231 ≤ mat[i][j] ≤ 231 - 1
class Solution {
    // public void markRow(int i , int mat[][],int m){
    //     for(int j=0;j<m;j++){
    //       if(mat[i][j] != 0) mat[i][j] = Integer.MIN_VALUE;
    //     }
    // }
    
    // public void markCol(int j , int mat[][] , int n){
    //     for(int i=0;i<n;i++){
    //       if(mat[i][j] != 0) mat[i][j] = Integer.MIN_VALUE;
    //     }
    // }
    public void setMatrixZeroes(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(mat[i][j] == 0){
        //             markRow(i, mat,m);
        //             markCol(j, mat,n);
        //         }
        //     }
        // }
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(mat[i][j] == Integer.MIN_VALUE){
        //             mat[i][j] = 0;
        //         }
        //     }
        // }
        
        //T.C = O(N^3) - Here it work correctly but time complexity is very bad here so we can use extra space mark row and col 
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i] || col[j]){
                    mat[i][j] = 0;
                }
            }
        }
    }
}
