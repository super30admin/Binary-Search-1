package Problem7;

public class SearchInRotatedArray {
    class Solution {
        int search(int[] nums, int tar){
            int pivot = findPivot(nums);
            int position = -1;
            if (pivot == -1) {
                position = searchNum(nums, tar, 0, nums.length - 1);
                return position;
            }
            if (nums[pivot] == tar) {
                return pivot;
            }


            if (nums[0] <= tar) {
                position = searchNum(nums, tar, 0, pivot - 1);
                return position;

            }
            position = searchNum(nums, tar, pivot + 1, nums.length - 1);
            return position;



        }
        int findPivot(int[] arr)
        {
            int start=0;
            int end=arr.length-1;
            int pivot;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(mid < end && arr[mid]>arr[mid+1])
                {
                    return mid;
                }
                if( mid > start && arr[mid]<arr[mid-1])
                {
                    return mid-1;
                }
                if(arr[start]>=arr[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }

            }


            return -1;
        }

        int searchNum(int[] arr, int target, int start, int end){

            while(start<=end){
                int mid=start+(end-start)/2;
                if(target>arr[mid]){
                    start=mid+1;
                }
                else if(target<arr[mid]){
                    end=mid-1;
                }
                else{
                    return mid;
                }
            }
            return -1;
        }
    }
}
