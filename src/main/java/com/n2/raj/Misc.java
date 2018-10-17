package com.n2.raj;

import static java.lang.String.format;

public class Misc {
  public static void main(String[] args) {
    String base = "My name is %s and I am %d years old";
    String formatted = format(base, "Rajesh", 25);
    System.out.println(formatted);
  }
}
