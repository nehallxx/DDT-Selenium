package org.practice.utils;

import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert {

   public static CustomSoftAssertion softAssertion=new CustomSoftAssertion();
   public static void customAssertAll(){
       try{
           softAssertion.assertAll("custom assert all");

       }catch(Exception e){
           System.out.println("custom soft assertion fails");
       }
   }

}
