// Question - 
//   Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 0 ≤ k ≤ 106

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int len = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)sum--; //el less than k 
            else sum++; // el greater than k 
            
            if(sum > 0){  // sum > 0 it means greater 
                len = i+1;
            }
            else{
                if(mp.containsKey(sum-1)){  // sum - (sum-1) = 1 
                    len = Math.max(len, i-mp.get(sum-1)); //find length
                }
            }
            
            mp.putIfAbsent(sum , i); // put sum - prefix sum 
        }
        return len;
    }
    
}
