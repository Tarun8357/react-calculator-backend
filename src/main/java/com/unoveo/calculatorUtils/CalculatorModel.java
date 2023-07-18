package com.unoveo.calculatorUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CalculatorModel {

  public static Float calculation(String calculatorLogs) {
    Gson gson = new Gson();

    ArrayList<CalculatorDTO> paramList = gson.fromJson(calculatorLogs, new TypeToken<ArrayList<CalculatorDTO>>(){}.getType());
    Float firstNumber = null;
    String operator = null;

    for (int i = 0; i < paramList.size(); i++) {

      if (paramList.get(i).getType().equals("NUMBER")) {
        if (firstNumber == null) {
          firstNumber = Float.valueOf(paramList.get(i).getValue());
          System.out.println(firstNumber);


        } else {

          System.out.println(firstNumber);
          firstNumber=operations(firstNumber,operator,Float.parseFloat(paramList.get(i).getValue()));

        }

      } else if (paramList.get(i).getType().equals("OPERATOR")) {
        operator = String.valueOf(paramList.get(i).getValue());
        System.out.println(operator);
      }
    }
    return firstNumber;
  }
  public static Float operations(float firstNumber, String operator,float secondNumber){
    System.out.println("IN Operation method");
    Float result = null;
    switch(operator){
      case "ADD":  result = firstNumber+secondNumber;
        System.out.println(result);
        break;

      case "SUBTRACT":  result =firstNumber-secondNumber;
        System.out.println(result);
        break;

      case "MULTIPLY":  result =firstNumber*secondNumber;
        System.out.println(result);
        break;
      case "DIVIDE":  result =firstNumber/secondNumber;
        System.out.println(result);
        break;

    }
    return result;

  }
}
