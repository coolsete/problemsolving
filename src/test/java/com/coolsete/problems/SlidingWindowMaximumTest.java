package com.coolsete.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SlidingWindowMaximumTest {
    private List<Integer> inputList = Arrays.asList(1, 5, 6, 3, 8, 7, 9);

    private Deque<Integer> stack = new ArrayDeque<>();

    public int getMaxOfMinimums(List<Integer> list, int x) {
        int windowCount = list.size() - x + 1;
        int result = 0;
        int k = 0;
        for (int i = 0; i < windowCount; i++) {
            for (int j = 0; j < x; j++) {
                if(!stack.isEmpty()) {
                    stack.push(Math.min(stack.pop(), list.get(k)));
                } else {
                    stack.push(Math.min(Integer.MAX_VALUE, list.get(k)));
                }
                k++;
            }
            result = Math.max(stack.pop(), result);
            if(x != 1) {
                k--;
            }
        }
        return result;

    }

    @Test
    public void getMaxOfMinimumsShouldReturnMaximum() {
        int actual = getMaxOfMinimums(inputList, 2);
        Assertions.assertEquals(7, actual);
    }

    @Test
    public void getMaxOfMinimumsShouldReturnMaximumWithXEqual1() {
        int actual = getMaxOfMinimums(inputList, 1);
        Assertions.assertEquals(9, actual);
    }

    @Test
    public void getMaxOfMinimumsShouldReturnMaximumWithXEqual7() {
        int actual = getMaxOfMinimums(inputList, 7);
        Assertions.assertEquals(1, actual);
    }
}
