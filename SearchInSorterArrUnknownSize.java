// Time Compexity : O(log n)
// SpACE Complexity: O(1)
//worked on LEET code 
class Solution {
   public int search(ArrayReader reader, int target) {
        if (reader.get(0) == Integer.MAX_VALUE) return -1;
        int lo=0;
       int hi=1;
	   //finding the upper bound for the binary search to be applied on 
       while(reader.get(high)<target){
           lo=hi;
           hi=hi*2;
       }
        return bs(reader,target,lo,hi)
    }
    
    private int bs(ArrayReader reader, int target, int lo,int hi){
     
        while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(target<reader.get(mid)){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return -1;
    }
}