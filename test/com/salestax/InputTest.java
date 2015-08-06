package com.salestax;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class InputTest {

    @Test
    public void shouldCheckThatTheGoodsIsFoodOrMedicalorBooks() {
        Input input = new Input();
        input.generateInput();

        assertFalse(input.isTaxable("1 book at 12.49"));
    }
}
