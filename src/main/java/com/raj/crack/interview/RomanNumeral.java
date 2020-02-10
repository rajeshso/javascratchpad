package com.raj.crack.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RomanNumeral {

  private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

  enum RomanNumeralEnum {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private int value;

    RomanNumeralEnum(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public static List<RomanNumeralEnum> getReverseSortedValues() {
      return Arrays.stream(values())
          .sorted(Comparator.comparing((RomanNumeralEnum e) -> e.value).reversed())
          .collect(Collectors.toList());
    }
  }

  static {

    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");

  }



  public static int toArabic(String input) {
    String romanNumeral = input.toUpperCase();
    int result = 0;

    List<RomanNumeralEnum> romanNumerals = RomanNumeralEnum.getReverseSortedValues();

    int i = 0;

    while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
      RomanNumeralEnum symbol = romanNumerals.get(i);
      if (romanNumeral.startsWith(symbol.name())) {
        result += symbol.getValue();
        romanNumeral = romanNumeral.substring(symbol.name().length());
      } else {
        i++;
      }
    }

    if (romanNumeral.length() > 0) {
      throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
    }

    return result;
  }


  public final static String toRoman(int number) {
    int l = map.floorKey(number);
    if (number == l) {
      return map.get(number);
    }
    return map.get(l) + toRoman(number - l);
  }

  public static void main(String[] args) {
  //  System.out.println(toRoman(4200));
    System.out.println(toArabic("MMMCC"));
  }

}
