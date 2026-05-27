package BehavioralDesignPattern.ChainOfResponsibility.pattern.handler;

import BehavioralDesignPattern.ChainOfResponsibility.pattern.model.ExpenseRequest;

public class ManagerHandler extends ExpenseHandler{
    @Override
    public void approveExpense(ExpenseRequest expenseRequest) {
        if(expenseRequest.getAmount()<=30000){
            System.out.println("Manager approved the expense request");
        }else{
            System.out.println("Manager cannot approve the expense request");
            nextHandler.approveExpense(expenseRequest);
        }
    }
}
