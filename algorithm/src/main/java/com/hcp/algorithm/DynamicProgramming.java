package com.hcp.algorithm;

public class DynamicProgramming {

    /**
     * 斐波那契数列
     *
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     *
     * 输入：n = 5
     * 输出：5
     *
     * @author hcp
     * @date 2021/9/26 16:45
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        final int mod = 1000000007;
        int f1 = 0, f2 = 0, result = 1;
        for (int i = 2; i <= n; i++) {
            f1 = f2;
            f2 = result;
            result = (f1 + f2) % mod;
        }
        return result;
    }

    /**
     * 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     *
     * @author hcp
     * @date 2021/9/26 17:04
     */
    public static int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        final int mod = 1000000007;
        int f1 = 0, f2 = 0, result = 1;
        for (int i = 1; i <= n; i++) {
            f1 = f2;
            f2 = result;
            result = (f1 + f2) % mod;
        }
        return result;
    }

    /**
     * 股票的最大利润
     *
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @author hcp
     * @date 2021/9/26 17:21
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        System.out.println(fib(8));
//        System.out.println(numWays(8));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
