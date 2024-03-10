using System;

namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
            p.SearchMatrix(new int[][] { new int[] { 1,3, 5, 7 },
                                         new int[] { 10,11,16,20 },
                                         new int[] { 23,30,34,50} }, 
                               11);

            p.Search(new int[] { 4, 5, 6, 7, 0, 1, 2}, 0);
        }

        public bool SearchMatrix(int[][] matrix, int target)
        {
            int len = matrix.Length;
            int wid = matrix[0].Length;
            int low = 0, high = len - 1;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (matrix[mid][0] == target) return true;
                if (matrix[mid][0] < target)
                {
                    if (mid == len - 1 || matrix[mid + 1][0] > target)
                    {
                        low = mid;
                        break;
                    }
                    low = mid + 1;
                }
                else
                {
                    if (mid == 0 || matrix[mid - 1][0] <= target)
                    {
                        low = mid == 0 ? 0 : mid - 1;
                        break;
                    }
                    high = mid - 1;
                }
            }
            int idx = low;
            low = 0;
            high = wid - 1;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (matrix[idx][mid] == target) return true;
                if (matrix[idx][mid] < target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return false;
        }
        public int Search(int[] nums, int target)
        {
            int high = nums.Length - 1;
            int low = 0;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) return mid;
                if (nums[low] <= nums[mid])
                {
                    if (nums[low] <= target && nums[mid] > target)
                    {
                        high = mid - 1;
                    }
                    else
                    {
                        low = mid + 1;
                    }
                }
                else
                {
                    if (nums[mid] < target && nums[high] >= target)
                    {
                        low = mid + 1;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }

        public int Search(ArrayReader reader, int target)
        {
            if (reader.get(0) == int.MaxValue) return -1;
            if (reader.get(1) == int.MaxValue) return reader.get(0) == target ? 0 : -1;
            int high = 1;
            int low = 0;
            while (reader.get(high) <= target)
            {
                low = high;
                high *= 2;
            }

            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (reader.get(mid) == target) return mid;
                if (reader.get(mid) < target) low = mid + 1;
                else high = mid - 1;
            }
            return -1;
        }
    }
    class ArrayReader
    {
       public int get(int index) { return 0; }
   }
}
