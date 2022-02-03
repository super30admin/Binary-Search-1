//Time Complexity : O(log(n)) Not sure
//Space Complexity : O(1)
// Yes, It's run successfully
// No I don't face any problem.



public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int j=0;
        int i= nums.length-1;
//        System.out.println("i : "+i+" j : "+j);
        if(nums.length<=2){
            while (j<nums.length){
                if(nums[j]==target){
                    return j;
                }
                j++;
            }
        }

        while (!(j>i)){
//            System.out.println("i : "+i+" j : "+j);
            if(nums[i]> nums[i-1]){
                i = i-1;
            }
            else {
//                System.out.println("i : "+i+" j : "+j);
                int left = binarySearch(nums, i, nums.length-1, target );
                int right = binarySearch(nums, 0, i-1, target );
                System.out.println(left+" - "+ right);
                if(left>right){
                    return left;
                }
                else if (right>left){
                    return right;
                }
                else {
                    return -1;
                }
            }

            if(nums[j]< nums[j+1]){
                j=j+1;
            }
            else {
                 int left = binarySearch(nums, 0, j, target );
                 int right = binarySearch(nums, j+1, nums.length-1, target);
                if(left>right){
                    return left;
                }
                else if (right>left){
                    return right;
                }
                else {
                    return -1;
                }
            }
        }
        return binarySearch(nums, 0, nums.length-1, target );
    }

    private int binarySearch(int [] nums, int start, int end, int target){

        while (start<=end){
            int mid = start+ (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]< target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] nums = {1,3,5};
        int target = 1;

        SearchInRotatedSortedArray object = new SearchInRotatedSortedArray();
        System.out.println(object.search(nums, target));
    }


}
