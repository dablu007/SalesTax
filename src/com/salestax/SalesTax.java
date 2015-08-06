package com.salestax;

import java.util.ArrayList;


public class SalesTax {
    private ArrayList<String> inputList;
    private ArrayList<String> outputList;
    private double tax;
    public SalesTax(ArrayList inputList) {
        this.inputList = inputList;
        this.outputList = new ArrayList<>();
    }

    public ArrayList<String> getOutputList() {
        return outputList;
    }

    public void calculateTax() {
        for (int i = 0; i < inputList.size(); i++) {
            String goods = inputList.get(i);
            String[] input = goods.split(" ");
            double price = Double.parseDouble(input[6]);
            StringBuffer result = new StringBuffer();
            for (int j = 0; j < input.length - 2; j++) {
                if (j == 0)
                    result.append( input[j]);
                else
                    result.append(" " + input[j]);
            }
            result.append(": ");

            String output = null;
            for (int j = 0; j < input.length -1; j++){
                output +=  input[j] + " ";
            }
            if (goods.contains("imported")) {
                tax += price * 0.05;
            }
            String finalPrice = roundOffTo2DecPlaces((float) (tax + price));
            result.append(finalPrice);
            String mynewstring = result.toString();
            outputList.add(mynewstring);
            System.out.println(mynewstring);
        }
    }

    private String roundOffTo2DecPlaces(float val)
    {
        return String.format("%.2f", val);
    }
}
