package com.raj.generics;

//Given the type of the TaxPayer, Calculate the tax
public class TaxPayer {
    public static final int COMPANY = 0;
    public static final int EMPLOYEE = 1;
    public static final int TRUST = 2;
    private static final double COMPANY_RATE = 0.2;
    private static final double EMPLOYEE_RATE = 0.3;
    private static final double TRUST_RATE = 0.4;

    private final int type;
    private double income;

    public TaxPayer(int type, double income) {
        this.type = type;
        this.income = income;
    }

    public double getIncome() {
        return this.income;
    }

    public double extortCash() {
        switch (type) {
            case COMPANY : return income * COMPANY_RATE;
            case EMPLOYEE : return income * EMPLOYEE_RATE;
            case TRUST : return income * TRUST_RATE;
            default : throw new IllegalArgumentException();
        }
    }
}
