package BehavioralDesignPattern.ChainOfResponsibility.pattern.handler;

import BehavioralDesignPattern.ChainOfResponsibility.pattern.model.ExpenseRequest;

public abstract class ExpenseHandler {
    protected ExpenseHandler nextHandler;

    public void setNextHandler(ExpenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void approveExpense(ExpenseRequest expenseRequest);
}
