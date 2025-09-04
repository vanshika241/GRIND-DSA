// Question - Balancing Consonants and Vowels Ratio

//   You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets. You need to find the number of balanced strings in arr[] which can be formed by concatinating one or more contiguous strings of arr[].
// A balanced string contains the equal number of vowels and consonants. 

// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i].size() ≤ 105
// Total number of lowercase english characters in arr[] is lesser than 105.

class Solution {
    public boolean isVowel(char ch){
        String s = "aeiou";
        return s.indexOf(ch) != -1;
    }
    public int countBalanced(String[] arr) {
        // code here
        int n = arr.length;
        int cnt = 0;
        //Brute force - generate all subarrays 
        // for(int i=0;i<n;i++){ // go through all strings 
        //     String s = ""; // initially 
        //     for(int j=i;j<n;j++){ // start with that and start adding ahead 
        //         s += arr[j];
        //         int c = 0; // consonant cnt
        //         int v = 0;  // vowel cnt
        //         for(int i=0;i<s.length();i++ ){
        //             char ch = s.charAt(i);
        //             if(isVowel(ch)){
        //                 v++;
        //             }
        //             else{
        //                 c++;
        //             }
        //         }
        //         if( v == c)cnt++; //Balance condition
        //     }
        // }
        
        int diffArr[] = new int[n]; // create diff array - v-c
        for(int i=0;i<n;i++){
            char curr[] = arr[i].toCharArray();
            int diff =0;
            for(char ch : curr){
                if(isVowel(ch)){
                    diff++; //if vowel 
                }
                else{ // if consonant
                    diff--;
                }
            }
            diffArr[i] = diff; // each string as a score of v-c
        }
        //find count all subarrays where cnt is 0
        HashMap<Integer,Integer> mp = new HashMap<>();
        int pref = 0;
        mp.put(0,1);
        for(int num:diffArr){
            pref += num;
            if(mp.containsKey(pref)){
                cnt += mp.get(pref);
            }
            mp.put(pref, mp.getOrDefault(pref,0)+1);
        }
        return cnt;
    }
}
