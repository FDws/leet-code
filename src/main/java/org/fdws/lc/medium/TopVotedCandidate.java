package org.fdws.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2020/9/26 15:21
 */

public class TopVotedCandidate {
    private final int[] maxVotes;
    private final int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;

        maxVotes = new int[persons.length];
        var personVote = new int[persons.length + 1];
        var max = 0;
        var maxPerson = persons[0];

        for (int i = 0; i < persons.length; i++) {
            var p = persons[i];
            var preVote = personVote[p];
            personVote[p] = preVote + 1;

            if (personVote[p] >= max) {
                max = personVote[p];
                maxVotes[i] = p;
                maxPerson = p;
            } else {
                maxVotes[i] = maxPerson;
            }
        }
    }

    public int q(int t) {
        int begin = 0;
        int end = times.length;

        while (begin < end) {
            if (times[begin] == t || begin == end - 1) {
                return maxVotes[begin];
            } else {
                int mid = (begin + end) >> 1;
                if (t == times[mid]) {
                    return maxVotes[mid];
                } else if (t < times[mid]) {
                    end = mid;
                } else {
                    begin = mid;
                }
            }
        }
        return maxVotes[begin];
    }

    public int bs(int begin, int end, int t) {
        if (times[begin] == t || begin + 1 >= end) {
            return begin;
        } else {
            int mid = (begin + end) >> 1;
            if (t == times[mid]) {
                return mid;
            } else if (t < times[mid]) {
                return bs(begin, mid, t);
            } else {
                return bs(mid, end, t);
            }
        }
    }

    public static void main(String[] args) {
        var obj = new TopVotedCandidate(new int[]{0, 0, 1, 1, 2}, new int[]{0, 67, 69, 74, 87});

        var list = List.of(4, 62, 100, 88, 70, 73, 22, 75, 29, 10);

        var result = new ArrayList<String>(list.size());
        list.forEach(i -> result.add(obj.q(i) + ""));
        System.out.println(String.join(", ", result));
    }
}
