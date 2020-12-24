package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2020/12/24 23:09
 */

public class RankTeamTest {
    public String rankTeams(String[] votes) {
        if (votes.length == 1 || votes[0].length() == 1) {
            return votes[0];
        }

        char[][] panel = new char[votes.length][votes[0].length()];
        for (int i = 0; i < votes.length; i++) {
            panel[i] = votes[i].toCharArray();
        }

        var sb = new StringBuilder();
        var has = new boolean[26];
        var rank = 0;

        for (int i = 0; i < panel[0].length; i++) {
            var row = new int[26];
            var maxGrade = 0;
            var hasMax = false;
            for (int j = 0; j < panel[0].length; j++) {
                for (char[] chars : panel) {
                    var c = chars[j];
                    var idx = c - 'A';
                    if (!has[idx] && row[idx] >= 0) {
                        row[idx] += 1;
                    }
                }

                var maxIndex = 0;
                var dupl = false;
                for (int k = 1; k < row.length; k++) {
                    if (row[k] > row[maxIndex]) {
                        maxIndex = k;
                        dupl = false;
                    } else if (row[k] == row[maxIndex]) {
                        dupl = true;
                    }
                }
                maxGrade = row[maxIndex];

                if (dupl) {
                    for (int k = 0; k < row.length; k++) {
                        if (row[k] < row[maxIndex]) {
                            row[k] = -1;
                        }
                    }
                } else {
                    has[maxIndex] = true;
                    sb.append((char) (maxIndex + 'A'));
                    rank += 1;
                    hasMax = true;
                    break;
                }
            }

            if (!hasMax) {

                for (int j = 0; j < row.length; j++) {
                    if (row[j] == maxGrade) {
                        sb.append((char) (j + 'A'));
                        rank += 1;
                        has[j] = true;
                    }
                }
            }
            if (rank >= panel[0].length) {
                break;
            }
        }
        return sb.toString();
    }

    @Test
    void test() {
        assertEquals("ACB", rankTeams("ABC,ACB,ABC,ACB,ACB".split(",")));
        assertEquals("XWYZ", rankTeams("WXYZ,XYZW".split(",")));
        assertEquals("ABC", rankTeams("BCA,CAB,CBA,ABC,ACB,BAC".split(",")));
        assertEquals("AXYB", rankTeams("AXYB,AYXB,AXYB,AYXB".split(",")));
    }
}
