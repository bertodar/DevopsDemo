package ch.zhaw.iwi.devops.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzConverterTest {

    @Test
    public void fizzBuzzConverter1() {

        FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();
        Assertions.assertEquals("1", fizzBuzz.convert(1));

    }

    @Test
    public void fizzBuzzConvertor2() {

        FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();
        Assertions.assertEquals("2", fizzBuzz.convert(2));

    }

    @Test
    public void fizzBuzzConvertor3() {

        FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();

        Assertions.assertEquals("Fizz", fizzBuzz.convert(3));
    }
    
    @Test
    public void fizzBuzzConvertorMultiplesOfThree() {

        FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();

        Assertions.assertEquals("Fizz", fizzBuzz.convert(6));
    }

    @Test
    void fizzBuzzConvertorMultiplesOfSeven() {

        FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();

        Assertions.assertEquals("Buzz", fizzBuzz.convert(7));
    }

    @Test
    void fizzBuzzConvertorMultiplesOfThreeAndSeven() {
        FizzBuzzConverter fizzBuzz = new FizzBuzzConverter();
        Assertions.assertNotEquals("FizzBuzz", fizzBuzz.convert(14));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.convert(21));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.convert(42));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.convert(63));
    }

}