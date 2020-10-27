package ru.vsu.cs.lazutkina;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        startProgram();
    }

    private static void startProgram()
    {
        System.out.print("Enter a positive number: ");
        int number = readPositiveNumber();
        printResult(number, sumPrimeNumbers(number));
        System.out.print("Enter 1 if you want to enter a new number or 0 if you want to end the program: ");
        restartProgram(readPositiveNumber());
    }

    private static int readPositiveNumber()
    {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        if (number < 0)
        {
            reportError();
            return readPositiveNumber();
        }
        return number;
    }

    private static boolean checkPrimeNumber(int number)
    {
        if (number == 0 || number == 1)
        {
            return false;
        }
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    private static int sumPrimeNumbers(int number)
    {
        int sum = 0;
        for (int i = 1; i <= number; i++)
        {
            if (checkPrimeNumber(i))
            {
                sum += i;
            }
        }
        return sum;
    }

    private static void printResult(int number, int sum)
    {
        System.out.printf("Sum of the first %d primes = %d\n", number, sum);
    }

    private static void reportError()
    {
        System.out.print("You entered the wrong number. Try again: ");
    }

    private static void restartProgram(int num)
    {
        if (num == 1)
        {
            startProgram();
        }
        else if (num == 0)
        {
            return;
        }
        else
        {
            reportError();
            restartProgram(readPositiveNumber());
        }
    }
}

