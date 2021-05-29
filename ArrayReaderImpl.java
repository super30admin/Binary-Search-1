import java.util.ArrayList;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader{

    private List<Integer> list;
    ArrayReaderImpl(List<Integer> list)
    {
      this.list=new ArrayList<>(list);
  
    }   
      @Override
      public int get(int index) {
          return list.get(index);
          
      }
      
  }