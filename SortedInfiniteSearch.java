class SortedInfiniteSearch {

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

    public int search(int[] nums, int target){
        
        int low = 0; int high = 1;
        
        try{
            int val = nums[high];
            while(val < target){
                low = high;
                high = 2*high;
                val = nums[high];
            }
        }
        catch(Exception e){
            System.out.println("Out of bounds exception...");
            int index = low;
            try{
                while(nums[index] <= target){
                    if(nums[index] == target){
                        return index;
                    }
    
                    index++;
                }
                return -1;
            }
            catch(Exception ex){
                return -1;
            }
            
        }
        
        
        
        return binarySearch(nums, low, high, target);
    }

    public static void main(String[] args){
        System.out.println("Sorted Infinite Search implementation ");
        int[] arr = {0,1,2,4,5,6,7};
        int target = 7;

        SortedInfiniteSearch obj = new SortedInfiniteSearch();
        System.out.println(obj.search(arr, target));

    }
}