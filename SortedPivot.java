class SortedPivot {

    public int findPivot(int[] nums, int low, int high){
               
        for(int i=low;i<high;i++){
            if(nums[i] > nums[i+1]){
                return i+1;
            }
        }
        return 0;
    }

    public int binarySearch(int[] nums, int low, int high, int target){
        if(low > high)
            return -1;
        
        int mid = (low+high)/2;
        if(nums[mid] == target)
            return mid;
        
        if(nums[mid] < target){
            return binarySearch(nums, mid+1, high, target);
        }
        else{
            return binarySearch(nums, low, mid-1, target);
        }

    }

    public int search(int[] nums, int target) {
     //find pivot
     int low = 0; int high = nums.length-1;
     int pivot = findPivot(nums, low, high);
    
     //binary search
     int left = binarySearch(nums, low, pivot-1, target);
     int right = binarySearch(nums, pivot, high, target);

     if(left == -1){
         return right;
     }
     else{
         return left;
     }    
    }
    public static void main(String[] args){
        System.out.println("Inside Sorted Pivot Implementation");
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        SortedPivot obj = new SortedPivot();

        System.out.println(obj.search(arr, target));
    }
} 