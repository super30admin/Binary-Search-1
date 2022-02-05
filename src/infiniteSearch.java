// Operation:            search
// Time Complexity:      O(logn)
// Space Complexity:     O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

package src;

interface ArrayReader
{
    int get(int index) ;
}

public class infiniteSearch
{
    public int search(ArrayReader reader, int target)
    {
        int s = 0, e = 1 ;
        while(reader.get(e) < target)                       // getting least index e for value which is greater than target
        {
            e *= 2 ;                                        // multiplying e with 2 every time
        }
        s = (e/2)+1 ;                                       // putting s to just right of the previous e

        while(s < e)                                        // Binary Search on the final sub-array
        {
            int mid = s + (e-s)/2 ;

            if(reader.get(mid) == target)
                return mid ;
            else if(reader.get(mid) > target)
                e = mid - 1 ;
            else
                s = mid + 1 ;
        }
        return -1 ;
    }
}
