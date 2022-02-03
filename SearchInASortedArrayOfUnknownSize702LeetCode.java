//Time Complexity : O(log(n))
//Space Complexity : O(1)
// Yes, It's run successfully
// No I don't face any problem.


public class SearchInASortedArrayOfUnknownSize702LeetCode {

//    public int search(ArrayReader reader, int target) {
//
//        int start = 0;
//        int end = 1;
//
//        while (reader.get(end) < target){
//            start = end + 1;
//            end = end * 2;
//        }
//
//        while (start<=end){
//            int mid = start + (end -start)/2;
//            if(reader.get(mid) == target){
//                return mid;
//            }
//            else if(reader.get(mid) < target){
//                start = mid + 1;
//            }
//            else {
//                end = mid - 1;
//            }
//        }
//        return -1;
//    }
}
