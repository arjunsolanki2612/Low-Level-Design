package BehavioralDesignPattern.ChainOfResponsibility.pattern.handler;

import BehavioralDesignPattern.ChainOfResponsibility.pattern.model.ExpenseRequest;

public class DirectorHandler extends ExpenseHandler{
    @Override
    public void approveExpense(ExpenseRequest expenseRequest) {
        if(expenseRequest.getAmount()<=90000){
            System.out.println("Director approved the expense request");
        }else{
            System.out.println("Director cannot approve the expense request");
        }
    }
}
