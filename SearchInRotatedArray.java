package s30Coding;


// Time Complexity O(log(n))

//Logic :- 
//	Find mid index and check if it is equal to the target, if yes, return the index
//	Check if low element is less the mid element and if target is between low and mid.
//		If yes, perform recursion with low = low and high = mid-1
//		Else, perform recursion with low = mid_1 and high = high
// Check target is between mid and high
//		IF yes perform recursion with low = mid+1 and high = high
//		else, perform recursion with low = low and high = mid -1

//Diffulties faced :- It was easy to solve with normal bst,
//but I tried to solve it would recursion as well along with it so it took me some time

//Code successfully runs on leetcode

public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
	       
        int result = search(nums, 0, nums.length-1, target);
        return result;
       
    }
   
      static int search(int num[], int low, int high, int target)
    {
         
        if (low > high) 
            return -1;
       
        int mid = (low+high)/2;
          
          
        //if target is equal to num of mid
        if (num[mid] == target)
            return mid;
       
          //num of low less than equal to mid  (sorted and rotation point found)
        if (num[low] <= num[mid])
        {
          
            if (target >= num[low] && target <= num[mid])
               return search(num, low, mid-1, target);
         
            return search(num, mid+1, high, target);
        }
       
       // target between mid and high
        if (target >= num[mid] && target <= num[high])
            return search(num, mid+1, high, target);
          
       //num of low greater than mid (not sorted yet)
          
        return search(num, low, mid-1, target);
    }
    
}
