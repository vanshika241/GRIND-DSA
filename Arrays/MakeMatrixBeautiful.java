// Question - A beautiful matrix is defined as a square matrix in which the sum of elements in every row and every column is equal. Given a square matrix mat[][], your task is to determine the minimum number of operations required to make the matrix beautiful.
// In one operation, you are allowed to increment the value of any single cell by 1.

// Constraints:
// 1 ≤ mat.size() ≤ 900
// 0 ≤ mat[i][j] ≤ 106

class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int rowSum[] = new int[n];
        int maxSum = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<m;j++){
                sum += mat[i][j];
            }
            rowSum[i] = sum;
            maxSum = Math.max(maxSum , sum);
        }
        
        for(int j=0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += mat[i][j];
            }
            maxSum = Math.max(maxSum , sum);
        }
        
        int op = 0;
        for(int i=0;i<n;i++){
            op += maxSum - rowSum[i];
        }
        return op;
    }
}
