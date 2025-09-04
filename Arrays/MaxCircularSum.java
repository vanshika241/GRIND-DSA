Questions - You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.
class Solution {
    
    public int maxKadanes(int arr[]){
        int n = arr.length;
        int sum = arr[0];
        int maxSum = arr[0];
        for(int i=1;i<n;i++){
            sum = Math.max(sum+arr[i],arr[i]); // ya toh prev + arr[i] or new subarray start from arr[i]
            maxSum = Math.max(sum , maxSum);
        }
        return maxSum;
    }
    
    public int minKadanes(int arr[]){
        int n  = arr.length;
        int sum = arr[0];
        int minSum = arr[0];
        for(int i=1;i<n;i++){
            sum = Math.min(sum+arr[i],arr[i]);
            minSum = Math.min(minSum , sum);
        }
        return minSum;
    }
    public int maxCircularSum(int arr[]) {
        // code here
        int n = arr.length; // size of array 
        // int maxSum = arr[0]; // initially 
        // for(int i=0;i<n;i++){ // traverse all elements
        //     int currSum  = 0; //curr sum start with i 
        //     for(int j=0;j<n;j++){ // remain ele with i and other
        //         int idx = (i+j)%n; // index 
        //         currSum += arr[idx]; // add 
        //         maxSum = Math.max(maxSum , currSum); // find side by side maximum
        //     }
        // }
        // return maxSum; 
        // T.C = O(N^2)
        
        //Kadanes Algo 
        //MAX , MIN , TSUM 
        //MAXIMUM SUM = TSUM -MIN OR MAX 
        
        int tsum = 0;
        for(int num:arr)tsum += num;
        int maxSum = maxKadanes(arr);
        int minSum = minKadanes(arr);
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum , tsum-minSum);
    }
}

