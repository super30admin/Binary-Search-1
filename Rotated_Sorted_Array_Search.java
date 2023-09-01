class Rotated_Sorted_Array_Search {
    //1D Array is in asc order initially before rotation and have distinct elements.
    //Assuming at least one side of the array will remain in sorted order after rotation.
    //We can directly do linear search but that will not take O(log n) time. So we will do binary search.
    //Time complexity is O(log n)
    //Space complexity is O(n)
    public int search(int[] nums, int target) {
        if(nums==null ||nums.length==0){ //Condn to check if the array is empty
            return -1;   //If yes then return -1
        }

        int low=0; //lower bound of the array.
        int high=nums.length-1; //upper bound of the array.


        while(low<=high){
            int mid = low +(high-low)/2;    //we do high-low in order to avoid the interger overflow situation
            if(nums[mid]==target){          //Condn to check if target is at middle index
                return mid;                 //if yes, then return mid index as target is found
            }

            if(nums[low]<= nums[mid]){     //if target is not found at mid element and nums[low]<nums[mid], as one side is sorted we'll check on left side first.
                if(target>= nums[low] && target <= nums[mid]){ //Cond to check if target lies between low and mid
                    high = mid-1; //then high will change to mid-1
                }
                else{
                    low=mid+1;  //then it lies on the other side of the array.
                }
            }
            else{              //If it is not on left side we'll check on right side of the array.
                if(target>=nums[mid] && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;         //If not present in the array then return -1

    }

    public static void main(String[] args){
        Rotated_Sorted_Array_Search rot_arr= new Rotated_Sorted_Array_Search();
        int[] nums= {4,5,6,7,0,1,2};
        int target= 7;
        System.out.println(rot_arr.search(nums,target));
    }
}