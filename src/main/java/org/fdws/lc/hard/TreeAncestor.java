package org.fdws.lc.hard;
////dp倍增法 by：bennu
////如果将一个点的所有祖先保存为一个列表，根据题目最大有5*10^4，在预处理阶段就会超时
////参考题解学会了一个牛逼的思路，dp倍增术！
////我们只记录一个点的0、1、2、4、8、..祖先，这样最多就记录16个
////dp[i][j]表示j的2^i号祖先，所以dp[i][j] = dp[i-1][dp[i-1][j]]
////dp[i-1][j]是j的2^(i-1)号祖先，它的2^(i-1)号祖先就是j的2^(i-1)+2^(i-1)号祖先
////就是j的2^i号祖先。处理过程中注意-1
////dp数组得到了，怎么求具体的，比如求(3,7)
////因为7=4+2+1，所以先得到3的4号祖先i，再得到i的2号祖先j，在得到j的祖先即可
//
////预先得到2的幂次方，方便后面计算
//    int[] base = {0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
//            int[][] dp;
//
//public TreeAncestor(int n, int[] parent) {
//        dp = new int[17][n];
//        dp[1] = parent;
//        for (int i = 2; i < dp.length; i++) {
//        for (int j = 0; j < n; j++) {
//        if (dp[i - 1][j] == -1) {
//        //如果前面已经是-1了，那么也是-1
//        dp[i][j] = -1;
//        } else {
//        dp[i][j] = dp[i - 1][dp[i - 1][j]];
//        }
//        }
//        }
//        }
//
//public int getKthAncestor(int node, int k) {
//        for (int i = 16; i > 0; i--) {
//        if (k >= base[i]) {
//        //如果大于某个2的幂次方，求出新的节点
//        node = dp[i][node];
//        if (node == -1) {
//        return -1;
//        }
//        k -= base[i];
//        }
//        }
//        return node;
//        }

import java.util.Arrays;

/**
 * @author FDws
 * @version Created on 2020/10/28 23:44
 * <p>
 * 1 2 4 8 16
 * 1 2 4 8 16
 */

public class TreeAncestor {
    int[] mul = new int[17];
    int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][17];
        mul[0] = 1;
        for (int i = 1; i < mul.length; i++) {
            mul[i] = mul[i - 1] << 1;
        }

        Arrays.fill(dp[0], -1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = parent[i];

            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i][j - 1] >= 0 ? dp[dp[i][j - 1]][j - 1] : -1;
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for (int i = mul.length - 1; i >= 0; i--) {
            if (node == -1) {
                return -1;
            }

            if (k >= mul[i]) {
                node = dp[node][i];
                k = k - mul[i];
            }

            if (k == 0) {
                return node;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        var demo = new TreeAncestor(7, new int[]{-1, 0, 1, 2, 3, 4, 5});
        var demo = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(demo.getKthAncestor(3, 1));
        System.out.println(demo.getKthAncestor(5, 2));
        System.out.println(demo.getKthAncestor(6, 3));
    }
}
