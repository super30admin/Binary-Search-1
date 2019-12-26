public class InfiniteSortedArray {
    // Java program to demonstrate working of an algorithm that finds an element in an array of infinite size

        static public int findPos(int[] nums, int target) { //size unknown and infinite array
            int low=0;  //Initiation
            int high=1;
            while(target>nums[high]){ //Finding the right range for Binary Search 
                low=high; //The window changes from old high to new high
                high*=2; //New high -- range doubles
            }
            while(low<=high){ //Condition to not run in infinite loop
                int mid=low + (high-low)/2; //Not (low+high)/2 to prevent Integer overflow error
                if(nums[mid]==target) return mid; //Middle element is target. Best case in first iteration: O(1)
                else if(target<nums[mid]){ //If target is greater than mid, the value is in the left side. Since this is in descending order
                    high=mid-1;
                }
                else{ //If target is lesser than mid, the value is in the right side. Since this is in descending order. If it is equal to mid, it is returned in the next iteration 
                    low = mid+1;
                }
            }
            return -1;
        }

        // Driver method to test the above function
        public static void main(String[] args)
        {
            int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                    100, 130, 140, 160, 170};
            int ans = findPos(arr,10);

            if (ans==-1)
                System.out.println("Element not found");
            else
                System.out.println("Element found at index " + ans);
        }
    }
    
}
