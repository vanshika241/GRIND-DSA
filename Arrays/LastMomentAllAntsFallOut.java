// Link - https://www.geeksforgeeks.org/problems/last-moment-before-all-ants-fall-out-of-a-plank/1
// Questions - We have a wooden plank of length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second, with some moving left and others right.When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time. When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.
// Given an integer n and two integer arrays left[] and right[], the positions of the ants moving to the left and the right, return the time when the last ant(s) fall out of the plank.

//  Constraints:
// 1 ≤ n ≤ 105
// 0 ≤ left.length, right.length ≤ n + 1
// 0 ≤ left[i], right[i] ≤ n
// 1 ≤ left.length + right.length ≤ n + 1
// All values of left and right are unique, and each value can appear only in one of the two arrays.

class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int maxTime = 0;
        for(int i=0;i<left.length;i++){
            maxTime = Math.max(left[i],maxTime); //from left max time 
        }
        for(int i=0;i<right.length;i++){
            maxTime = Math.max(n-right[i],maxTime); // from right max time 
        }
        return maxTime;//at max time all ants fall out because other have less than this time 
    }
}
