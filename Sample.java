
/*
Search a 2D Matrix
approach
1. row elements are sorted which clearly indicates to use a binary search
2. we can compare the target with the last element of first row and find which row the target could be and
call binary search on that row


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0) return false;

        int l = 0, high = matrix.length-1;
        int cols = matrix[0].length-1;
        while(l<high){
            int m = l+(high-l)/2;

            if(matrix[m][cols]==target) return true;
            if(target<matrix[m][cols]&& target>=matrix[m][0]) {
                return binarySearch(matrix[m], target, 0, cols);
            }
            else if(target>matrix[m][cols]) {
                l = m+1;
            }
            else
                high = m;
        }
        return false;
    }

    public boolean binarySearch(int[] row, int target, int l, int h) {

        while(l<h) {
            int m = (h+l)/2;
            if(row[m]==target) {
                return true;
            }
            if(target<row[m]) h=m;
            else l=m+1;
        }
        return false;

    }
}
public class Sample {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};


        System.out.println(solution.searchMatrix(a, 1));
    }
}

Search in Rotated Sorted Array
time complexity: O(log N)
space: O(1)
approach:
1. my intial thought was to find the pivot and then perform bst based on pivot
2. but that came out to be O(n+log N) and required is O(log N)
3. so, a different approach, which is, calculate middle index, check if middle is target, if not,
check if abs(target-(m-1)) or abs(target-(m+1)) is smaller, most likely, if former is smaller then target will be on left of m,
else on the right side of m

but this approach is not true in some cases, my solution passed 175/195 test cases.


class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int l, int h) {
        if(l<=h) {
            int m = (l+h)/2;
            if(nums[m]==target) return m;

            if(m-1>=l) {
                if (m + 1 <= h) {
                    if (Math.abs(target - nums[m - 1]) < Math.abs(target - nums[m + 1])) {
                        return binarySearch(nums, target, l, m - 1);
                    }
                    else
                        return binarySearch(nums, target, m+1, h);
                }
                else {
                    return binarySearch(nums, target, l, m - 1);
                }
            }
            else
                return binarySearch(nums, target, m+1, h);
        }
        return -1;
    }

}

public class Sample {
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 3;
        System.out.println("index "+solution.search(nums, 3));
    }
}


Search in Sorted Array of unknown size
thought process:
1. we only know the first element and the target
2. initial thought was to try to find the size, my approach was, assume target as the size, check if arr[size] element exists,
if yes, increase the size by size+target, else, decrease size by size-target. we repeat this process until arr[size+1] is out of bounds.
3. now that we know size, we can apply binary search

 after lecture approach below:
 time: O(log N)
 space: O(1)


class Solution {
    public int search(int[] nums, int target){
        int l=0,h=1;

        while (nums[h]<=target) {
            l = h;
            h = h*2;
        }

        return binarySearch(nums, l, h, target);

    }

    private int binarySearch(int[] nums, int l, int h, int target){

        while (l<=h) {
            int m = (l+h)/2;

            if (nums[m]==target) return m;

            if(target<nums[m]) h=m;
            else l = m+1;
        }
        return -1;
    }

}
public class Sample {
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 3;
        System.out.println("index "+solution.search(nums, 3));
    }
}


 */
