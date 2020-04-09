package ch.course223.advanced.UK.domainModells.Salary;

import java.util.List;

@FunctionalInterface
public interface SalaryHandler {
    public List<Integer> assessSalaries (List<Integer> salaryList);
}
