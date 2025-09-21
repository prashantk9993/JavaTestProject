package designpatterns.creational.builder;

/*
  Steps to create builder
  1. create static nested class and copy all arguments from outer to Builder class
  2. Builder class should have a public constructor with all required attributes as params.
  3. Builder class should have methods to set optional params and it should return same builder object
  4. provide build method in builder class

  Main class should only have getters for instance variables
  Main class should have private constructor accepting Builder class object

 */

public class TestBuilderPattern {

    public static void main(String[] args) {

        Computer computer1 = new Computer.ComputerBuilder("500 GB","2 GB")
                .setGraphicsCardEnabled(true)
                .build();

        System.out.println(computer1);

    }
}
