package com.mycompany.studentspendingplanner;

public class monthaccounts extends month {
    double travel;
    double groceries;
    double utilities;
    double overhead;
    double phonecontract;
    double miscellaneous;
    double hours;
    double payrate;
    double loan;
    double insurance;

    long hello;

    public monthaccounts(String Monthname, double Income, double Expenses, double Travel, double Groceries, double Utilities, double Overhead, double Phonecontract, double Miscellaneous, double Hours, double Payrate, double Loan, double Insurance){ super( Monthname, Income, Expenses);
        travel = Travel;
        groceries = Groceries;
        utilities = Utilities;
        overhead = Overhead;
        phonecontract = Phonecontract;
        miscellaneous = Miscellaneous;
        insurance = Insurance;

        hours = Hours;
        payrate = Payrate;
        loan = Loan;

        this.incomedifference = ((hours*payrate)+ loan)-(travel + groceries + utilities + overhead + phonecontract + miscellaneous +insurance);
        this.income = (hours*payrate)+ loan;
        this.expenses = travel + groceries + utilities + overhead + phonecontract + miscellaneous +insurance;
    }

    public void setIncome() {
        this.income = (hours*payrate)+ loan;
    }

    public void setExpenses() {
        this.expenses = travel + groceries + utilities + overhead + phonecontract + miscellaneous +insurance;
    }

    public void setIncomedifference(){
        this.incomedifference = ((hours*payrate)+ loan)-(travel + groceries + utilities + overhead + phonecontract + miscellaneous +insurance);
    }

    public void setTravel(double newValue) {travel = newValue;}

    public void setGroceries(double newValue) {groceries = newValue;}

    public void setUtilities(double newValue) {utilities = newValue;}

    public void setOverhead(double newValue) {overhead = newValue;}

    public void setMiscellaneous(double newValue) {miscellaneous = newValue;}

    public void setHours(double newValue) {hours = newValue;}

    public void setPayrate(double newValue) {payrate = newValue;}

    public void setLoan(double newValue) {loan = newValue;}

    public void setInsurance(double newValue) {insurance = newValue;}

}
