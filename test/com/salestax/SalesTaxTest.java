package com.salestax;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class SalesTaxTest {

    @Test
    public void shouldAddTaxForAllImportedGoods() {
        String input = "1 imported box of chocolates at 10.00";
        ArrayList inputList = new ArrayList();
        inputList.add(input);
        SalesTax salesTax = new SalesTax(inputList);

        salesTax.calculateTax();
        ArrayList outputList = new ArrayList();
        outputList.add("1 imported box of chocolates: 10.50");
        assertEquals(outputList, salesTax.getOutputList());
    }

    @Test
    public void shouldCalculateTaxForAllImportedGoodsForMoreThanOneItemAndGiveTotalTax() {
        ArrayList inputList = new ArrayList();
        String input1 = "1 imported box of chocolates at 10.00";
        String input2 = "1 imported box of chocolates at 47.50";
        inputList.add(input1);
        inputList.add(input2);
        SalesTax salesTax = new SalesTax(inputList);

        salesTax.calculateTax();
        ArrayList outputList = new ArrayList();
        outputList.add("1 imported box of chocolates: 10.50");
        outputList.add("1 imported box of chocolates: 49.88");
        outputList.add("Sales Taxes: 2.88");
        outputList.add("Total: 60.38");

        assertEquals(outputList, salesTax.getOutputList());
    }

    @Test
    public void shouldCalculateTaxForAllImportedGoodsOtherThanFoodForMoreThanOneItemAndGiveTotalTax() {
        ArrayList inputList = new ArrayList();
        String input1 = "1 imported box of chocolates at 10.00";
        String input2 = "1 imported bottle of perfume at 47.50";
        inputList.add(input1);
        inputList.add(input2);
        SalesTax salesTax = new SalesTax(inputList);

        salesTax.calculateTax();
        ArrayList outputList = new ArrayList();
        outputList.add("1 imported box of chocolates: 10.50");
        outputList.add("1 imported bottle of perfume: 54.63");
        outputList.add("Sales Taxes: 7.63");
        outputList.add("Total: 65.13");

        assertEquals(outputList, salesTax.getOutputList());
    }
}
