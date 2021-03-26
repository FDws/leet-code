package org.fdws.lc.medium;

/**
 * @author FDws
 * @version Created on 2021/3/18 22:47
 */

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
