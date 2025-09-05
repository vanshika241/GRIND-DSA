// Question - 
//   You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation is represented as an array [v, r1, c1, r2, c2], where:

// v is the value to be added
// (r1, c1) is the top-left cell of a submatrix
// (r2, c2) is the bottom-right cell of the submatrix (inclusive)
// For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2). Return the final matrix after applying all operations.

// Constraint:
// 1 ≤ n×m, q ≤ 105
// 0 ≤ r1 ≤ r2 ≤ n - 1
// 0 ≤ c1 ≤ c2 ≤ m - 1
// -104 ≤ mat[i][j], v ≤ 104

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
        //make matrix 
        
        //Brute force manually 
        
         int n = mat.length;
         int m = mat[0].length;
         int opR = opr.length;
         ArrayList<ArrayList<Integer>> mt = new ArrayList<>();
        // for(int i=0;i<n;i++)mt.add(new ArrayList<>());
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         mt.get(i).set(j,mat[i][j]);
        //     }
        // }
        // if( n == 0)return mt;
        // for(int i=0;i<opR;i++){
        //     int el = opr[i][0];
        //     int r1 = opr[i][1];
        //     int c1 = opr[i][2];
        //     int r2 = opr[i][3];
        //     int c2 = opr[i][4];
            
        //     for(int r=r1;r<=r2;r++){
        //         for(int c=c1;c<=c2;c++){
        //             mt.get(r).set(c,mt.get(r).get(c)+el);
        //         }
        //     }
        // }
        
        // return mt;
        
        int diff[][] = new int[n+1][m+1];
        for(int i=0;i<opR;i++){
            int val = opr[i][0];
            int r1 = opr[i][1];
            int c1 = opr[i][2];
            int r2 = opr[i][3];
            int c2 = opr[i][4];
            diff[r1][c1] += val;
            if(c2+1<m)diff[r1][c2+1] -= val;
            if(r2+1<n)diff[r2+1][c1] -= val;
            if(r2+1 < n && c2+1<m) diff[r2+1][c2+1] +=val;
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                diff[i][j] += diff[i][j-1];
            }
        }
        
                
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                diff[i][j] += diff[i-1][j];
            }
        }
        
        
       for(int i=0;i<n;i++){
           ArrayList<Integer> curr = new ArrayList<>();
           for(int j=0;j<m;j++){
               curr.add(mat[i][j] + diff[i][j]);
           }
           mt.add(curr);
       }
       
        return mt;
    }
}
