import java.util.HashMap;
import java.util.ArrayList;

class Random
{
    public static void main(String[] args)
    {
        ArrayList<String[]> list = new ArrayList<String[]>();
        
        list = testCase();        

        for(String[] item: list)
        {
            System.out.println(item[0] + " in " + item[1] + ": " + makeFrom(item[0],item[1]));
        }

    }

    private static HashMap<Character,Integer> countCharacters(String msg)
    {
        HashMap<Character,Integer> count = new HashMap<Character,Integer>();
        for(Character character: msg.toLowerCase().toCharArray())
        {
            try
            {
                count.put(character,count.get(character) + 1);
            }
            catch(Exception e)
            {
                count.put(character,1);
            }

        }
        return count;
    }

    private static Boolean makeFrom(String target, String source)
    {
        HashMap<Character,Integer> targetCount = countCharacters(target);
        HashMap<Character,Integer> sourceCount = countCharacters(source);
        for(Character key: targetCount.keySet())
        {
            try
            {
                if(targetCount.get(key) > sourceCount.get(key))
                {
                    return false;
                }
            }
            catch(Exception e)
            {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<String[]> testCase()
    {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] test1 = {"",""};
        String[] test2 = {"a",""};
        String[] test3 = {"","a"};
        String[] test4 = {"a","a"};
        String[] test5 = {"A","a"};
        String[] test6 = {"A","A"};
        String[] test7 = {"B","a"};
        String[] test8 = {"b","a"};
        String[] test9 = {"aa","a"};
        String[] test10 = {"a","aa"};
        String[] test11 = {"ab","a"};
        String[] test12 = {"a","ab"};

        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test6);
        list.add(test7);
        list.add(test8);
        list.add(test9);
        list.add(test10);
        list.add(test11);
        list.add(test12);

        return list;
    }
}