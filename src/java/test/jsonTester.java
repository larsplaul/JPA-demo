package test;

import facades.jsonAssembler;
import javax.persistence.Persistence;


public class jsonTester {
  
  public static void main(String[] args) {
    jsonAssembler assembler = new jsonAssembler();
    System.out.println(assembler.getUser(1));
  }
 
}
