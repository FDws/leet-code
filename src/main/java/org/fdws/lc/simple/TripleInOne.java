package org.fdws.lc.simple;

import java.util.Arrays;

/**
 * @author FDws
 * @version Created on 2020/11/8 14:02
 */

public class TripleInOne {
    final int[] stack;
    final int[] idx;
    final int size;

    public TripleInOne(int stackSize) {
        size = stackSize;
        stack = new int[stackSize * 3];
        idx = new int[3];
        Arrays.fill(idx, -1);
    }

    public void push(int stackNum, int value) {
        if (idx[stackNum] < size - 1) {
            idx[stackNum] += 1;
            stack[idx[stackNum] + size * stackNum] = value;
        }
    }

    public int pop(int stackNum) {
        if (idx[stackNum] >= 0) {
            var value = stack[stackNum * size + idx[stackNum]];
            idx[stackNum] -= 1;
            return value;
        }
        return -1;
    }

    public int peek(int stackNum) {
        if (idx[stackNum] >= 0) {
            return stack[stackNum * size + idx[stackNum]];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return idx[stackNum] < 0;
    }

    public static void main(String[] args) {
        var o = new TripleInOne(1);
        o.push(0, 1);
        o.push(0, 2);
        System.out.println(o.pop(0));
        System.out.println(o.pop(0));
        System.out.println(o.pop(0));
        System.out.println(o.isEmpty(0));

    }
}
