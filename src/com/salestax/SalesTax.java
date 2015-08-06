package com.salestax;

import java.util.ArrayList;


public class SalesTax {
    private ArrayList<String> inputList;
    private ArrayList<String> outputList;
    private double totalTax = 0;
    private double totalPrice = 0;
    private Input inputTaxChecker;
    public SalesTax(ArrayList inputList) {
        this.inputList = inputList;
        this.outputList = new ArrayList<>();
        inputTaxChecker = new Input();
    }

    public ArrayList<String> getOutputList() {
        return outputList;
    }

    public void calculateTax() {
        for (int i = 0; i < inputList.size(); i++) {
            String goods = inputList.get(i);
            String[] input = goods.split(" ");
            int index = input.length;
            double tax = 0;
            double price = Double.parseDouble(input[index-1]);
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
            if (goods.contains("imported") && !(inputTaxChecker.isTaxable(goods))) {
                tax += price * 0.05;
            }
            else if ( (goods.contains("imported")) && inputTaxChecker.isTaxable(goods)){
                tax += price * 0.15;
            }
            else if (inputTaxChecker.isTaxable(goods)){
                tax += price * 0.10;
            }
            else {
                tax += 0.0;
            }
            totalTax += tax;
            String finalPrice = roundOffTo2DecPlaces((float) (tax + price));
            double priceNew = Double.parseDouble(finalPrice);
            totalPrice += priceNew;
            result.append(finalPrice);
            String mynewstring = result.toString();
            outputList.add(mynewstring);
        }
        outputList.add("Sales Taxes: " + roundOffTo2DecPlaces((float) totalTax));
        outputList.add("Total: " + roundOffTo2DecPlaces((float) totalPrice));
    }

    private String roundOffTo2DecPlaces(float val)
    {
        return String.format("%.2f", val);
    }
}
