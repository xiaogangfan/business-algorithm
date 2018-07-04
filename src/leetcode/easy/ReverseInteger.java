package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 *
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21

 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [?231,  231 ? 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 ˼·��
 1�������Ҫ�����ͱ߽�ֵcase��
 2���������⣬�����⣬��ֻ���������ĳ���������Ǹ���������ʱ����-1���ɡ�
 3������˼·��
    ������ɣ�A���õ�ÿ�����Ͷ�Ӧ��������Ȼ�����¼�ֵ
    ��δ��ɣ�B��ת����String��Ȼ������ת����Integer��Note��caseû�н��

 * created by xiaogangfan
 * on 2018/6/19.
 */
public class ReverseInteger {
    /**
     * A ���� ʱ�临�Ӷȣ�O(2n),����n�����ֵĳ���
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean isPositive = true;
        if(x < 0 ){
            x = -x;
            isPositive = false;
        }
        int result = 0;
        Map<Integer,Integer> map = new HashMap();
        int index = 1;

        while(x > 0){
            map.put(index,x%10);
            x = x/10;
            index++ ;
        }

        for(int i = 1;i<=map.size();i++){
            result += map.get(i)*Math.pow(10,map.size()-i);
        }

        // ��result = isPositive?result:-result; ˳���ܱ�
        if(result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE ){
            return 0;
        }

        result = isPositive?result:-result;

        return result;
    }


    /**
     * B ���� ʱ�临�Ӷȣ�O(n),����n�����ֵĳ���
     * @param x
     * @return
     */
    public int reverseB(int x) {
        boolean isPositive = true;
        if(x < 0 ){
            x = -x;
            isPositive = false;
        }
        int result = 0;
        StringBuilder temp = new StringBuilder();
        boolean isZero = true;
        for (int i = 0; i < (""+x).length() ; i++) {
            if((""+x).charAt((""+x).length()-1-i) == '0' && isZero){
                continue;
            }else {
                isZero = false;
            }
            temp.append((""+x).charAt((""+x).length()-1-i));
        }
        if(!temp.toString().equals("")){
            result = Integer.parseInt(temp.toString());
        }

        return isPositive?result:-result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
//        System.out.println(ri.reverse(-321));
//        System.out.println(ri.reverse(321));
//        System.out.println(ri.reverse(320));
        System.out.println(ri.reverseB(-321));
        System.out.println(ri.reverseB(321));
//        System.out.println(ri.reverseB(3020));
        Integer.parseInt("23232");
    }
}
