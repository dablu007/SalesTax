package com.salestax;

import java.util.ArrayList;

public class Input {
    private ArrayList nonTaxableItems;
    public void generateInput() {
        nonTaxableItems = new ArrayList();
        nonTaxableItems.add("book");
        nonTaxableItems.add("chocolate");
        nonTaxableItems.add("pills");
    }

    public ArrayList getNonTaxableItems() {
        return nonTaxableItems;
    }

    public boolean isTaxable(String input) {
        for (int i = 0; i < nonTaxableItems.size(); i++) {
            if ( input.contains((CharSequence) nonTaxableItems.get(i)))
                return false;
        }
        return true;
    }
}
