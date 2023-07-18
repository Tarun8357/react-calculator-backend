package com.unoveo.calculatorUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");

    PrintWriter pw = resp.getWriter();
    pw.print("get method called");
    System.out.print("get method called");
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("Access-Control-Allow-Origin",  "*");
    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");

    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader bufferedReader = req.getReader();
    String line;
    while((line= bufferedReader.readLine())!=null){
      stringBuilder.append(line);
    }
    String payload = stringBuilder.toString();




    System.out.println("this is paramlist"+payload);

    out.print(CalculatorModel.calculation(payload));

  }


}
