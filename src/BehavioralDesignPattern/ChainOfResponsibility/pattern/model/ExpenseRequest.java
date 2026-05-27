package BehavioralDesignPattern.ChainOfResponsibility.pattern.model;

public class ExpenseRequest {
    private String employeeName;
    private double amount;

    public ExpenseRequest(String employeeName, double amount) {
        this.employeeName = employeeName;
        this.amount = amount;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public double getAmount(){
        return amount;
    }
}
