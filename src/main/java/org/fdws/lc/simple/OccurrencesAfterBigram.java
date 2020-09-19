package org.fdws.lc.simple;

import java.util.ArrayList;

/**
 * @author FDws
 * @version Created on 2020/9/19 15:43
 */

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        final var words = text.split(" ");
        if (words.length <= 2) return new String[0];

        var step = first.equals(second) ? 1 : 2;
        var result = new ArrayList<String>();

        for (int i = 0; i < words.length - 2; ) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                result.add(words[i + 2]);
                i += step;
            } else {
                i += (words[i + 1].equals(first) ? 1 : 2);
            }

        }
        return result.toArray(new String[0]);
    }
}
