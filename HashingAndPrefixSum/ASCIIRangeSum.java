// Given a lowercase English string s, for each character that appears more than once (i.e., its first and last positions differ), compute the sum of the ASCII values of all characters strictly between its first and last occurrence. Collect all such sums that are non-zero into a list (in any order). If no such sums exist, return an empty list.

// Constraints:
// 1 ≤ s.size() ≤ 105

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        int n = s.length();
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character,Integer> last = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!first.containsKey(ch)){
                first.put(ch , i);
            }
            
                last.put(ch , i);
            
        }
        
    ArrayList<Integer> ans = new ArrayList<>();
     for(Map.Entry<Character,Integer> e : first.entrySet()){
         char ch = e.getKey();
         int firstPos = first.get(ch);
         int lastPos = last.get(ch);
         if(lastPos>firstPos+1){
             int sum = 0;
             for(int i=firstPos+1;i<lastPos;i++){
                 sum += (int)s.charAt(i);
             }
             ans.add(sum);
         }
     }
     return ans;
    }
}
