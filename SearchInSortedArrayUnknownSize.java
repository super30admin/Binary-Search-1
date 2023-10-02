//// Time Complexity : O(log(n))
//// Space Complexity : O(1)
//// Did this code successfully run on Leetcode :Yes
//// Any problem you faced while coding this :No
//class Solution {
//    private int low;
//    private int high;
//
//    public Solution(){
//        this.low=0;
//        this.high=1;
//    }
//    public int search(ArrayReader reader, int target) {
//    
//        while(reader.get(high)<target){
//            low =high;
//            high=2*high;
//        }
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(target==reader.get(mid)) return mid;
//            if(reader.get(mid)<target){
//                low=mid+1;
//            }
//            else{
//                high=mid-1;
//            }
//        }
//    return -1;
//}
//}