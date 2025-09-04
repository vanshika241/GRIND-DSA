// Link - https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
// Ques - Given an array arr[], find the sum of all the subarrays of the given array.
// Note: It is guaranteed that the total sum will fit within a 32-bit integer range.

// Constraints :
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤ 104

class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n = arr.length; // size of array 
    //     int tsum = 0; // totalSum
    //   for(int i=0;i<n;i++){ // traverse all elements 
    //       int sum = 0; // from that loop to end 
    //       for(int j=i;j<n;j++){
    //           sum += arr[j]; // currSum
    //           tsum += sum; //add every currSum
    //       }
    //   }
    //   return tsum;
    
    //Here the second loop is my problem it adding elementsin O(N) time i want to get sum of all in O(1) time 
    //Optimal Solution - 
    
    int tsum = 0;
    for(int i=0;i<n;i++){
        tsum += (n-i)*(i+1)*arr[i]; // Start with i * Without start with i and that element (n-i) + (n-i)*i
    }
    return tsum;
    
    }
}
