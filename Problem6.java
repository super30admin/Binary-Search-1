//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : No(not available)
// Any problem you faced while coding this : Yes, didn't try to execute. Not sure if the solution is correct
public class Problem6 {
    public int search(int[] arr, int target){
        int k = getIndex(arr,target);
        if(arr[k]==target)
            return k;
        else{
            //Binary search between 0 and k indices
            int left = 0;
            int right = k;
            while(left<=right) {
                int mid = left + (right-left)/2;
                if(arr[mid]==target)
                    return mid;
                else if(arr[mid]>target)
                    left = mid+1;
                else
                    right = mid-1;
            }
            }
        return -1;
        }


    public int getIndex(int[] arr, int target){
        int i=0;
        while(true){
            try{if(arr[i]==target || arr[i]>target)
                return i;
                i += 2;}
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }
        }
    }
}

