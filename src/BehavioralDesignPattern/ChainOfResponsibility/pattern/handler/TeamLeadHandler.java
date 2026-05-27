package BehavioralDesignPattern.ChainOfResponsibility.pattern.handler;

import BehavioralDesignPattern.ChainOfResponsibility.pattern.model.ExpenseRequest;

public class TeamLeadHandler extends ExpenseHandler{
    @Override
    public void approveExpense(ExpenseRequest expenseRequest) {
        if(expenseRequest.getAmount()<=7000){
            System.out.println("Team Lead approved the expense request");
        }else{
            System.out.println("Team Lead cannot approve the expense request");
            nextHandler.approveExpense(expenseRequest);
        }
    }
}
