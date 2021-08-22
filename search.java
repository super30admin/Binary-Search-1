//702. Search in a Sorted Array of Unknown Size
interface ArrayReader
{

    int get(int index);
}

public class search
{

    public int search(ArrayReader reader, int target)
    {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target)
        {
            low = high;
            high = high * 2;
        }

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target)
            {
                return mid;
            }
            else if (reader.get(mid) < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}
