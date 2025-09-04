// Question - Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.
// Note: The returned array of majority elements should be sorted.

// Constraint:
// 1 ≤ arr.size() ≤ 106
// -105 ≤ arr[i] ≤ 105

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        // for(int i=0;i<n;i++){ // Traverse all array
        //     int cnt = 1; // initially count i el 
        //     for(int j=i+1;j<n;j++){ // i have to go through complete arry for count same element 
        //         if(arr[j] == arr[i]){ 
        //             cnt++;
        //         }
        //     }
        //     if(cnt>n/3){ //if cnt ? n/3 and not duplicate
        //         if(!ans.contains(arr[i]))ans.add(arr[i]);
        //     }
        // }
        
        //T.C = O(N^2) 
        // Optimal - Moore Voting Algo - it help to find the max freq element in array 
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1 == 0 && arr[i] != el2){
                el1 = arr[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && arr[i] != el1){
                el2 = arr[i];
                cnt2 = 1;
            }
            else if(arr[i] == el1){
                cnt1++;
            }
            else if(arr[i] == el2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        
        //Verification 
        cnt1 = 0;
        cnt2 = 0;
        for(int num : arr){
            if(num == el1)cnt1++;
            if(num == el2)cnt2++;
        }
        if(cnt1>n/3){
            ans.add(el1);
        }
         if(cnt2>n/3){
            ans.add(el2);
        }
        Collections.sort(ans); //sorted 
        return ans;
    }
}
