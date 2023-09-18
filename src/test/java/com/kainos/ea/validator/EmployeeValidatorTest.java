package com.kainos.ea.validator;

import com.kainos.ea.exception.BankNumberLengthException;
import com.kainos.ea.exception.NinLengthException;
import com.kainos.ea.exception.SalaryTooLowException;
import com.kainos.ea.model.EmployeeRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidatorTest {

    EmployeeValidator employeeValidator = new EmployeeValidator();

    EmployeeRequest employeeRequest1= new EmployeeRequest(
            25000F,"John","Doe","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","32225253255","123"
    );
    @Test
    public void isValidEmployee_shouldReturnTrue_whenValidEmployee() throws SalaryTooLowException, BankNumberLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertTrue(employeeValidator.isValidEmployee(employeeRequest));
    }

    @Test
    public void isValidEmployee_shouldThrowSalaryTooLowException_whenSalaryTooLow() {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                10000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertThrows(SalaryTooLowException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

    /*
    Unit Test Exercise 1

    Write a unit test for the isValidEmployee method

    When the bank number is less than 8 characters

    Expect BankNumberLengthException to be thrown

    This should pass without code changes
     */

    @Test
    public void isValidEmployee_shouldThrowBankNumberLengthException_whenBankNumberIsLessThan8Characters() throws BankNumberLengthException, SalaryTooLowException {
       EmployeeRequest employeeRequest= new EmployeeRequest(
               25000F,"John","Doe","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","1234567","123"
       );

       assertThrows(BankNumberLengthException.class,
               ()-> {employeeValidator.isValidEmployee(employeeRequest);
       });
    }

    /*
    Unit Test Exercise 2

    Write a unit test for the isValidEmployee method

    When the bank number is more than 8 characters

    Expect BankNumberLengthException to be thrown

    This should pass without code changes
     */

    @Test
    public void isValidEmployee_shouldThrowBankNumberLengthExceptionWhenBankNumberIsLongerThan8Characters(){
        EmployeeRequest employeeRequest= new EmployeeRequest(
                25000F,"John","Doe","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","123456789","123"
        );

        assertThrows(BankNumberLengthException.class,
                ()-> {employeeValidator.isValidEmployee(employeeRequest);
                });
    }

    /*
    Unit Test Exercise 3

    Write a unit test for the isValidEmployee method

    When the first name more than 50 characters

    Expect false to be returned

    This should fail, make code changes to make this test pass
     */

    @Test
    public void isValidEmployee_shouldReturnFalse_whenFistNameIsLongerThan50Characters() throws BankNumberLengthException, SalaryTooLowException, NinLengthException {
        EmployeeRequest employeeRequest= new EmployeeRequest(
                25000F,"John12345678901234567890123456789012345678901234567890","Doe","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","12345678","123"
        );

        boolean result = employeeValidator.isValidEmployee(employeeRequest);

        assertFalse(result);
    }

    /*
    Unit Test Exercise 4

    Write a unit test for the isValidEmployee method

    When the last name more than 50 characters

    Expect false to be returned

    This should fail, make code changes to make this test pass
     */

    @Test
    public void isValidEmployee_shouldReturnFalse_whenLastNameIsLongerThan50Characters() throws BankNumberLengthException, SalaryTooLowException, NinLengthException {
        EmployeeRequest employeeRequest= new EmployeeRequest(
                25000F,"John","D12345678901234567890123456789012345678901234567890","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","12345678","123"
        );

        boolean result = employeeValidator.isValidEmployee(employeeRequest);

        assertFalse(result);
    }

    /*
    Unit Test Exercise 5

    Write a unit test for the isValidEmployee method

    When the nin is more than 8 characters

    Expect NinLengthException to be thrown

    This should fail, make code changes to make this test pass
     */
    @Test
    public void isValidEmployee_shouldThrowNinLengthException_whenNinIsLongerThan8Character() throws BankNumberLengthException, SalaryTooLowException {
        EmployeeRequest employeeRequest= new EmployeeRequest(
                25000F,"John","Doe","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","12345678","123456789"
        );


        assertThrows(NinLengthException.class,
                ()->{employeeValidator.isValidEmployee(employeeRequest);
        });
    }

    /*
    Unit Test Exercise 6

    Write a unit test for the isValidEmployee method

    When the nin is less than 8 characters

    Expect NinLengthException to be thrown

    This should fail, make code changes to make this test pass
     */

    @Test
    public void isValidEmployee_shouldThrowNinLengthException_whenNinLengthIsLessThan8Characters(){
        EmployeeRequest employeeRequest= new EmployeeRequest(
                25000F,"John","Doe","email@2m.com","123","456","Gdańsk","pom","80-123","Poland","12312314","12345678","1234567"
        );

        assertThrows(NinLengthException.class,
                ()->{employeeValidator.isValidEmployee(employeeRequest);
                });

    }
}