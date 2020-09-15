package org.fdws.lc.hard;

/**
 * @author FDws
 * @version Created on 2020/9/13 21:04
 */

public class RestoreTheArray {
    public static int numberOfArrays(String s, int k) {
        if (s.length() < 1) return 1;
        var mod = 1000000007;
        var chars = s.toCharArray();
        var dp = new long[chars.length + 1];
        dp[chars.length] = 1;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') continue;

            var tmp = 0L;
            for (int j = i; j < chars.length; j++) {
                tmp = tmp * 10 + chars[j] - '0';
                if (tmp > k) break;
                dp[i] += dp[j + 1];
            }

            if (dp[i] >= mod) {
                dp[i] = dp[i] % mod;
            }
        }
        return (int) dp[0];
    }

    public static void main(String[] args) {
        System.out.println("Value: " + numberOfArrays("1000", 10000));
        System.out.println("Value: " + numberOfArrays("1234", 10000));
        System.out.println("Value: " + numberOfArrays("1000", 10));
        System.out.println("Value: " + numberOfArrays("1317", 2000));
        System.out.println("Value: " + numberOfArrays("2020", 30));
        System.out.println("Value: " + numberOfArrays("1234567890", 90));
    }
}
