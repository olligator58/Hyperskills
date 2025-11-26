class CalculatorTests {

    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);

        Assertions.assertEquals(5, result);
    }
}

