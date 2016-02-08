package Arrays.Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * author: Nicholas James Cook
 * package Arrays.Sort;
 * class: Sort
 * description: 
 *
 *
 * @param <T>
 */

public class Sort<T extends Comparable<? super T>> 
{
    @SafeVarargs
    static <T> T[] newArray(int length, T... array)
    {
        return Arrays.copyOf(array, length);
    }
    
    public <T extends Comparable<? super T>> T[] mergeSort(T[] a, boolean isAscending)
    {
        if (a.length == 1)
            return a;
        else
        {
            T[] b = newArray(a.length/2);
            T[] c = newArray(a.length - a.length/2);
            for(int i = 0; i < a.length; i++)
            {
                if(i < a.length / 2)
                {
                    b[i] = a[i];
                }
                else
                {
                    c[i - a.length / 2] = a[i];
                }
            }
            return combine(mergeSort(b,isAscending),
                    mergeSort(c,isAscending), isAscending);
        }
    }
  
    
    private <T extends Comparable<? super T>> T[] combine(T[] b, T[] c, boolean isAscending) 
    {
        T[] a;
        a = newArray(b.length + c.length); 
        for(int i = 0, j = 0, k = 0; i < a.length; i++)
        {
            if (j < b.length && k < c.length)
            {
                if(b[j].compareTo(c[k]) == 1)
                {
                    if(isAscending)
                    {
                        a[i] = c[k];
                        k ++;
                    }
                    else
                    {
                        a[i] = b[j];
                        j ++;
                    }
                }
                else
                {
                    if(isAscending)
                    {
                        a[i] = b[j];
                        j ++;
                    }
                    else
                    {
                        a[i] = c[k];
                        k ++;
                    }
                }
                
            }
            else if (j < b.length)
            {
                a[i] = b[j];
                j ++;
            }
            else 
            {
                a[i] = c[k];
                k ++;
            }
        }
        return a;
    }
    
    private static void copy(Object[] a, Comparable[] b)
    {
        
        for(int i = 0; i < a.length ; i ++)
        {
            a[i] = (Object)b[i];
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Sort<Integer> sort = new Sort<>();
        Integer[] list = {5,3,4,7,4,1,3,5,6};        
        copy(list,sort.mergeSort(list,true));

        System.out.println(Arrays.toString(list));
        
        Sort<Double> sort2 = new Sort<>();
        Double[] list2 = {5.0,3.0,4.0,7.0,4.0,1.0,3.0,5.0,6.0};
        copy(list2,sort.mergeSort(list2,true));
        //System.out.println((Integer)((Object)sort.mergeSort(list,true)).getClass());
        
        System.out.println(Arrays.toString(list2));
        
        // TODO code application logic here
    }

}
