package BehavioralDesignPattern.ChainOfResponsibility.pattern;

import BehavioralDesignPattern.ChainOfResponsibility.pattern.handler.DirectorHandler;
import BehavioralDesignPattern.ChainOfResponsibility.pattern.handler.ExpenseHandler;
import BehavioralDesignPattern.ChainOfResponsibility.pattern.handler.ManagerHandler;
import BehavioralDesignPattern.ChainOfResponsibility.pattern.handler.TeamLeadHandler;
import BehavioralDesignPattern.ChainOfResponsibility.pattern.model.ExpenseRequest;

public class Main {
    public static void main(String[] args) {
        ExpenseHandler managerHandler = new ManagerHandler();
        ExpenseHandler teamLeadHandler = new TeamLeadHandler();
        ExpenseHandler directorHandler = new DirectorHandler();

        teamLeadHandler.setNextHandler(managerHandler);
        managerHandler.setNextHandler(directorHandler);

        ExpenseRequest expenseRequest = new ExpenseRequest("Arjun", 5000);
        teamLeadHandler.approveExpense(expenseRequest);

        System.out.println();

        ExpenseRequest expenseRequest1 = new ExpenseRequest("Madhav",29000);
        teamLeadHandler.approveExpense(expenseRequest1);

        System.out.println();

        ExpenseRequest expenseRequest2 = new ExpenseRequest("Rahul",70000);
        teamLeadHandler.approveExpense(expenseRequest2);
    }
}
