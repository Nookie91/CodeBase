package Arrays.Search;

/**
 * author: Nicholas James Cook
 * package Arrays.Search;
 * class: List
 * description: 
 *
 *
 */

public class List<T extends Comparable> 
{
    public int linearSearch(T a[],T item)
    {
        for(int i =0;i < a.length; i++)
        {
            if(a[i].equals(item))
                return i;
        }
        return -1;
    }
    
    public int binarySearchA(T a[], T item)
    {
        int low = 0;
        int high = a.length;
        int mid;
        
        while(low < high)
        {
            mid = (low + high)/2;
            if(a[mid].compareTo(item) == 0)
            {
                return mid;
            }
            else if (a[mid].compareTo(item) == 1)
                high = mid;                      
            else
                low = mid;
        }
        return -1;
    }
    public int binarySearchD(T a[], T item)
    {
        int low = 0;
        int high = a.length;
        int mid;
        
        while(low < high)
        {
            mid = (low + high)/2;
            if(a[mid].compareTo(item) == 0)
            {
                return mid;
            }
            else if (a[mid].compareTo(item) == -1)
                high = mid;                      
            else
                low = mid;
        }
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Integer> search = new List<>();
        Integer[] list = {1,2,3,4,5};
        System.out.println(search.linearSearch(list,4));
        System.out.println(search.binarySearchA(list,2));
        // TODO code application logic here
    }

}
