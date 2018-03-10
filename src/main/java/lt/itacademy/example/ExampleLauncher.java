package lt.itacademy.example;

import lt.itacademy.example.comparator.ComparableEnumFieldBasedLoanRiskTypeComparator;
import lt.itacademy.example.comparator.MappedValueBasedLoanRiskComparator;
import lt.itacademy.example.comparator.NaiveLoanRiskTypeComparator;
import lt.itacademy.example.comparator.SwitchlessMappedValueBasedLoanRiskComparator;
import lt.itacademy.example.domain.IndexedLoanRiskType;
import lt.itacademy.example.domain.LoanRiskType;

import java.util.*;

public class ExampleLauncher {
    public static void main(String[] args) {
        LoanRiskType[] loanRiskTypes = LoanRiskType.values(); // Enum.values() returns all values (in declaration order)
        IndexedLoanRiskType[] indexedLoanRiskTypes = IndexedLoanRiskType.values();

        //Let's see how our comparators works
        sortAndPrint(loanRiskTypes, new NaiveLoanRiskTypeComparator()); //Uh oh, something went wrong :) See comments in "NaiveLoanRiskTypeComparator"
        sortAndPrint(indexedLoanRiskTypes, new ComparableEnumFieldBasedLoanRiskTypeComparator());
        sortAndPrint(loanRiskTypes, new MappedValueBasedLoanRiskComparator());
        sortAndPrint(loanRiskTypes, new SwitchlessMappedValueBasedLoanRiskComparator());
    }

    private static <T> void sortAndPrint(T[] loanRiskTypes, Comparator<T> loanRiskTypeComparator) {
        List<T> sortedLoanRiskTypes = new ArrayList<>(Arrays.asList(loanRiskTypes));
        Collections.sort(sortedLoanRiskTypes, loanRiskTypeComparator);
        System.out.println(sortedLoanRiskTypes);
    }
}
