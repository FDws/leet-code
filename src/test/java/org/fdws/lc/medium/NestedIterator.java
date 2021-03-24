package org.fdws.lc.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author FDws
 * @version Created on 2021/3/24 22:04
 */

public class NestedIterator implements Iterator<Integer> {

  // 原始数据
  private final LinkedList<NestedInteger> list;
  // 当前迭代器
  private NestedIterator currentIter;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.list = new LinkedList<>(nestedList);
  }

  @Override
  public Integer next() {
    NestedIterator other = this;
    // 消除函数递归调用
    while (true) {
      if (other.currentIter == null || !other.currentIter.hasNext()) {
        if (other.list.isEmpty()) {
          throw new NoSuchElementException("Empty List");
        }

        var first = other.list.removeFirst();
        return first.getInteger();
      }

      other = other.currentIter;
    }
  }

  @Override
  public boolean hasNext() {
    if (currentIter != null && currentIter.hasNext()) {
      return true;
    }

    while (!list.isEmpty()) {
      // 单个值直接返回true
      NestedInteger item = list.peekFirst();
      if (item.isInteger()) {
        return true;
      }

      // 列表需要移除, 值放迭代器
      list.removeFirst();

      currentIter = new NestedIterator(item.getList());
      if (currentIter.hasNext()) {
        return true;
      }
    }
    return false;
  }

  private static class NestedInteger {
    private int value;
    private List<NestedInteger> values;

    private NestedInteger(int value) {
      this.value = value;
    }

    private NestedInteger(List<NestedInteger> values) {
      this.values = new ArrayList<>(values);
    }

    public boolean isInteger() {
      return values == null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
      return value;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
      return Collections.unmodifiableList(values);
    }
  }
}