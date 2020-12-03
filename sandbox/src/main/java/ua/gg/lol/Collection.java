package ua.gg.lol;

import java.util.Arrays;
import java.util.List;

public class Collection {

  public static void main(String[] args){
    String[] langs = {"java","C#","Python","php"};

    List<String> languages = Arrays.asList("java","C#","Python","php");


    for (int i = 0; i < langs.length; i++){
      System.out.println("Я хочу выучить "+ langs[i]);

    }
    System.out.println(System.lineSeparator());
    for (String l : languages){
      System.out.println("Я хочу выучить "+ l);
    }
  }
}
