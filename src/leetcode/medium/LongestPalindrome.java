package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * created by xiaogangfan
 * on 2018/6/22.
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 1 || s.length() == 0){
            return "";
        }
        int left = 0,right = 0,maxLength = 0;
        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c)!=null && (i-map.get(c) > maxLength)){
                left = map.get(c);
                right = i;
                maxLength = right-left;
                continue;
            }
            map.put(c,i);
        }
        if(left == 0 && right==0){
            return null;
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println("asv".substring(1,3));
    }

}
