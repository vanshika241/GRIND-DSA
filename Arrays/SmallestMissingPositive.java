Question - You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
Note: Positive number starts from 1. The array can have negative integers too.

Constraints:  
1 ≤ arr.size() ≤ 105
-106 ≤ arr[i] ≤ 106

class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length; // array size  - total number of elements 
        // boolean check[] = new boolean[n+1]; // check array - last el = n
        // for(int num: arr){  // only element access - forEach loop
        //     if(num > 0 && num <=n && !check[num]){ // condition 
        //         check[num]= true; // mark in check 
        //     }
        // }
        // //find
        // for(int i=1;i<=n;i++){
        //     if(check[i] == false){ // false - not in arr - this is missing
        //         return i;
        //     }
        // }
        // return n+1; // nothing missing b/w 1 to n then smallest missing would be n+1
        // // T.C = O(N)
        // // S.C = O(N)
        
        //CYCLE SORT 
        
        int i=0; // start
        
        while(i<n){ // because i want to increment i when my condition is satisfied 
            int correctIdx = arr[i]-1; // its correctidx
            if(arr[i]>0 && arr[i]<=n && arr[i] != arr[correctIdx]){ // check condition for swap
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
            else{ // else move i 
                i++;
            }
        }
        //verification 
        for(int id=0;id<n;id++){
            if(arr[id]   != id+1){ // this is missing 
                return id+1;
            }
        }
        return n+1;
    }
}
