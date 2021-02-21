package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FDws
 * @version Created on 2021/2/21 19:15
 */

public class FilterRestTest {
    // [idi, ratingi, veganFriendlyi, pricei, distancei]
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(e -> {
                    return e[3] <= maxPrice && e[4] <= maxDistance && (veganFriendly == 1 ? e[2] == 1 : true);
                }).sorted(Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]).reversed()).map(e -> e[0]).collect(Collectors.toList());
    }

    @Test
    void test() {
        assertEquals(List.of(4, 5),
                filterRestaurants(new int[][]{
                                {1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}},
                        0,
                        30,
                        3)
        );

        assertEquals(List.of(3, 1, 5),
                filterRestaurants(new int[][]{
                        {1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 1, 50, 10
                ));
    }
}
