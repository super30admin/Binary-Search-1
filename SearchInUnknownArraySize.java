// Time Complexity :O(logn)
// Space Complexity : O(n) for size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Commenting the solution because IDE gives errors due to ArrayReader.

//class Solution {
//    public int search(ArrayReader reader, int target) {
//        int start = 0;
//        int end = 10000-1;
//        while(start<=end){
//            int mid=(start+end)/2;
//            if(reader.get(start)==target) return start;
//            else if(reader.get(end)==target) return end;
//            else if(reader.get(mid)==target) return mid;
//            else{
//                if(target>reader.get(start) && target<reader.get(mid)){
//                    //start = 0;
//                    end = mid-1;
//                }
//                else{
//                    start = mid+1;
//                }
//            }
//        }
//        return -1;
//    }
//}