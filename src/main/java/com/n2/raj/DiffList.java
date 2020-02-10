package com.n2.raj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import org.apache.commons.collections4.CollectionUtils;

public class DiffList {

  public static void main(String[] args) {
    List<String> oldKeys = Arrays.asList("key0","key1","key2","key5");
    List<String> newKeys = Arrays.asList("key0","key2","key5", "key6");
  //  List<String> list = new ArrayList<>(CollectionUtils.disjunction(newKeys, oldKeys));
    List<String> diffList = new ArrayList<>(oldKeys);
    diffList.removeAll(newKeys);
    System.out.println(diffList);
  }
}
