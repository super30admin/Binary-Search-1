class SortedPivot {

    public int findPivot(int[] nums, int low, int high){
        
        //null check
        if(nums.length == 0)
            return -1;

        //isPivot zero check
        if(nums[0] <= nums[nums.length-1])
            return 0;
        
        //binary pivot
        if(low > high){
            return -1;
        }        
        
        int mid = low + (high-low)/2;
        if(nums[mid] > nums[mid+1])
            return mid+1;
        
        if(nums[low] <= nums[mid]){
            return findPivot(nums, mid+1, high);
        }
        else{
            return findPivot(nums, low, mid-1);
        }
    }

    public int binarySearch(int[] nums, int low, int high, int target){
        if(nums.length == 0)
            return -1;
        if(low > high)
            return -1;        
        int mid = low + (high-low)/2;
        if(nums[mid] == target)
            return mid;
        
        if(nums[mid] < target){
            System.out.println(mid+1);
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
        int[] arr = {1};
        int target = 0;
        SortedPivot obj = new SortedPivot();

        System.out.println(obj.search(arr, target));
    }
} 