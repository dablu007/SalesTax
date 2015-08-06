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
        assertEquals(outputList.get(0), salesTax.getOutputList().get(0));
    }
}
