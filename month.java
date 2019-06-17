package com.mycompany.studentspendingplanner;

public class month{
    String monthname;
    double income;
    double expenses;
    double incomedifference;

    public month(String Monthname, double Income, double Expenses){
        monthname = Monthname;
        income = Income;
        expenses = Expenses;
        incomedifference = (Income-Expenses);
    }

    public void setincome(double newValue) {
        income = newValue;
        incomedifference = (income-expenses);
    }

    public void setexpenses(double newValue) {
        income = newValue;
        incomedifference = (income-expenses);
    }

}
