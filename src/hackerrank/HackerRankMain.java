/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author sametdumankaya
 */
public class HackerRankMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(palindromeIndex("baa"));
        
                
        
    }
    
    //warmups
    public static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
        int[] ret = new int[2];
        
        int b = 0, a = 0;
        
        if(a0 < b0)
        {
            b++;
        }
            
        if(a0 > b0)
        {
            a++;
        }
        
        if(a1 < b1)
        {
            b++;
        }
            
        if(a1 > b1)
        {
            a++;
        }
        
        if(a2 < b2)
        {
            b++;
        }
            
        if(a2 > b2)
        {
            a++;
        }
        
        ret[0] = a;
        ret[1] = b;
        
        return ret;
    }
   
    public static long aVeryBigSum(int n, long[] ar) 
    {
        long a = 0;
        
        for(long i : ar)
        {
            a += i;
        }
        
        return a;
    }
    
    public static int diagonalDifference(int n ,String[][] matrix)
    {
        int n1 = 0;
        int n2 = n - 1;
        int sum1 = 0, sum2 = 0;
        
        while(n1 < n - 1)
        {
            sum1 += Integer.parseInt(matrix[n1][n1]);
            sum2 += Integer.parseInt(matrix[n2][n1]);
            
            n1++;
            n2--;
        }
        
        return Math.abs(sum1-sum2);
    }
    
    
    //implementation
    public static int sockMerchant(int n, int[] ar) 
    {
        int result = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        
        for (int i : ar)
        {
            if(!map.containsKey(i))
            {
                map.put(i, 1);
            }
            else
            {
                map.remove(i);
                result++;
            }
        }
        
        return result;
    }
    
    public static int countingValleys(int n, String s)
    {
        int result = 0;
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) 
        {
            String sub = s.substring(i,i+1);
            
            if(sub.equals("D"))
            {
                if(!stack.isEmpty() && stack.peek().equals("U"))
                {
                    stack.pop();
                }
                else
                {
                    stack.push("D");
                }
            }
            else
            {
                if(!stack.isEmpty() && stack.peek().equals("D"))
                {
                    stack.pop();

                    if(stack.isEmpty())
                    {
                        result++;
                    }
                }
                else
                {
                    stack.push("U");
                }
            }
        }
        
        return result;
    }
    
    //strings
    public static int camelCaseCount(String s)
    {
        int result = 1;
        
        for(char c : s.toCharArray())
        {
            if(Character.isUpperCase(c))
            {
                result++;
            }
        }
        
        return result;
    }
    
    public static int sosCount(String s)
    {   
        int result = 0;
        
        for(int i = 0; i < s.length(); i+=3)
        {
            if(s.charAt(i) != 'S')
            {
                result++;
            }
            
            if(s.charAt(i+1) != 'O')
            {
                result++;
            }
            
            if(s.charAt(i+2) != 'S')
            {
                result++;
            }
        } 
        
        return result;
    }

    public static void isPangram(String s)
    {
        char[] arr = s.toLowerCase().toCharArray();
        HashMap<Character,Integer> hashtable = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) 
        {
            if(arr[i] == ' ')
            {
                continue;
            }
            
            if(!hashtable.containsKey(arr[i]))
            {
                hashtable.put(arr[i], 1);
            }
            else
            {
                hashtable.put(arr[i], hashtable.get(arr[i]) + 1);
            }
        }
        
        if(hashtable.size() == 26)
        {
            System.out.println("pangram");
        }
        else
        {
            System.out.println("not pangram");
        }
   }

    public static int alternatingCharacters(String s)
    {
        int result = 0;
        
        for (int i = 0; i < s.length() - 1; i++) 
        {
            String current = s.substring(i, i+1);
            String next = s.substring(i+1, i+2);
            
            if(current.equals(next))
            {
                result++;
            }
        }
        
        return result;
    }

    public static int palindromeIndex(String s)
    {
        int result = -1;
        String reverse = new StringBuilder(s).reverse().toString();
        
        if(reverse.equals(s))
        {
            return -1;
        }
        
        for (int i = 0; i < s.length(); i++) 
        {
            String s1 = s.substring(i, i+1);
            String s2 = reverse.substring(i, i+1);
            
            if(!s1.equals(s2))
            {
                String resultstr = new StringBuilder(s).replace(i, i+1, "").toString();
                String resultstr2 = new StringBuilder(reverse).replace(i, i+1, "").toString();
                
                
                if(resultstr.equals(new StringBuilder(resultstr).reverse().toString()))
                {
                    return i;
                }
                else if(resultstr2.equals(new StringBuilder(resultstr2).reverse().toString()))
                {
                    return s.length() - i - 1;
                }
                else
                {
                    return -1;
                }
            }
        }
        
        return result;
    }

    public static String twoStrings(String s1, String s2)
    {
        String small = s1.length() < s2.length() ? s1 : s2;
        String big =   s1.length() > s2.length() ? s1 : s2;
        
        for (int i = 0; i < small.length(); i++) 
        {
            String sub = small.substring(i, i+1);
            
            if(big.contains(sub))
            {
                return "YES";
            }
        }
        
        return "NO";
        
    }
    
    
}
