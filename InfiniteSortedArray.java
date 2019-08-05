public class InfiniteSortedArray{
    public static int binSearchInRotatedArray(int[] nums, int target) {
        int slow = 0, fast = 2;
        try {
            while (nums[fast] < target) {
                slow = fast;
                fast *= 2;
            }
        } catch (Exception e) {
            try {
                while(slow > 0){
                    if(nums[slow] == target)
                        return slow;
                    slow++;
                }
            } catch (Exception e2) {
                System.out.println("Not Found");
            }
           
        }
        return search(nums,target,slow,fast);
    }

    private static int search(int[] nums, int target, int low, int high){
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] array1 = {1,2,4,5,7,23,45,67,99,100};
        
    
        System.out.println(InfiniteSortedArray.binSearchInRotatedArray(array1,1));
        System.out.println(InfiniteSortedArray.binSearchInRotatedArray(array1,7));
        System.out.println(InfiniteSortedArray.binSearchInRotatedArray(array1,2));
        System.out.println(InfiniteSortedArray.binSearchInRotatedArray(array1,101));

    }
}