package com.soft1841.util;

/**
 * Integer类练习
 *
 * @author Yue Tang
 * 2019.3.12
 */
public class IntegerDemo {
    public static void main(String[] args) {
        int num = 31;
        //调用integer类方法，将num进行进制转换
        String str1 = Integer.toBinaryString(num);
        String str2 = Integer.toHexString(num);
        String str3 = Integer.toOctalString(num);
        String str4 = Integer.toString(num, 15);
        System.out.println("二进制：" + str1 + "   十六" + str2 + "  八" + str3 + "   十五" + str4);
        System.out.println("十六进制：" + str2);
        System.out.println("八进制：" + str3);
        System.out.println("十五进制：" + str4);
        System.out.println("--------------------------");
        String str5 = convet(76, 2);
        System.out.println("31转二进制：" + str5);
    }

    private static String convet(int num, int radix) {
        //num转为radix进制
        StringBuffer stringBuffer = new StringBuffer();
        while (num != 0) {
            //求余数
            int r = num % radix;
            //更新被除数为商
            num = num / radix;
            //余数加入字符串
            stringBuffer.append(r);
        }
        //反转输出
        return new StringBuffer(stringBuffer).reverse().toString();
    }

}
