package BinarySearch1;

public class Rotated_2Pass {

    int [] nums;
    int target;

    public int find_keyof_rotation(int left, int right) {
        if (nums[left] < nums[right])
            return 0;
        /*
    Binary search 1 to find key of rotation i.e., the smallest element index for which subarrays are sorted on both sides
    */
        while(left <= right){
            int mid = (left+right)/2;
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            else{
                if(nums[mid] > nums[left])
                    left = mid;
                else
                    right = mid;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
         /*
    Binary search 2 comparing
    */
        while (left <= right) {
            int key = (left + right)/ 2;
            if(nums[key] == target)
                return key;
            else {
                if (nums[key] < target)
                    left = key + 1;
                else
                    right = key - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int l = nums.length;
        // single element in array
        if ( l == 1)
            return this.nums[0] == target ? 0 : -1;

        int index_of_rotation = find_keyof_rotation(0, l -1);

        // if target is the smallest
        if(nums[index_of_rotation] == target)
            return index_of_rotation;
        // array is not rotated
        if(index_of_rotation == 0)
            return search(0, l-1);
        //rotated array
        if(target < nums[0])
            return search(index_of_rotation, l-1);
        else
            return search(0, index_of_rotation);

    }

    public static void main(String[] args) {
        Rotated_2Pass object = new Rotated_2Pass();
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        // {4, 5, 6, 7, 0, 1, 2}, target = 5
        int result = object.search(rotatedArray,5);
        System.out.println("result = "+result);
    }

}


