// Question - 
// Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -103 ≤ arr[i] ≤ 103
// -105 ≤ k ≤ 105

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
    int n = arr.length;
    int cnt = 0;
    HashMap<Integer,Integer> mp = new HashMap<>(); // to remove second loop in brute where i am again and again calculating all subarrays
    mp.put(0,1); // sum == k - sum-k = 0
    int sum = 0;
    for(int i=0;i<n;i++){
        sum += arr[i];
        int rem = sum-k; // Total = sum , if mp have sum-k then sum-k+k - it means it have k sum also 
        if(mp.containsKey(rem)){
            cnt += mp.get(rem); //store in sum which give cnt
        }
        mp.put(sum , mp.getOrDefault(sum,0)+1); //current sum store
    }
    return cnt;
    }
}
