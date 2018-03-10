package lt.itacademy.example.comparator;

import lt.itacademy.example.domain.LoanRiskType;

import java.util.Comparator;

public class MappedValueBasedLoanRiskComparator implements Comparator<LoanRiskType> {

    @Override
    public int compare(LoanRiskType loanRiskTypeToCompare, LoanRiskType loanRiskTypeToCompareWith) {

        //
        //PLEASE SEE "ComparableEnumFieldBasedLoanRiskTypeComparator" FIRST
        //
        //This implementation is very similar to of "ComparableEnumFieldBasedLoanRiskTypeComparator", but in this
        // comparator we are doing "LoanRiskType" value to rank/priority convertion inside comparator instead of
        // backing-it-in Enum itself.
        //
        //This approach is best so far. We are not violating SSP. Rank/priority is 100% controlled by comparator itself.
        //
        //Only downside to this approach, comparator now became fragile to "LoanRiskType"'s expansion changes.
        // If some new "LoanRiskType" value would be added, this comparator would break. So "LoanRiskType" change will
        // require comparator change as well. BUT I THINK THIS IS GOOD ENOUGH :) We can live with that :)
        //

        return getRank(loanRiskTypeToCompare).compareTo(getRank(loanRiskTypeToCompareWith));
    }

    private Integer getRank(LoanRiskType loanRiskType) {
        switch (loanRiskType) {
            case LOW_RISK:
                return 0;
            case NORMAL_RISK:
                return 1;
            case HIGH_RISK:
                return 2;
        }
        throw new IllegalArgumentException("LoanRiskType = " + loanRiskType + " not implemented yet!");
    }
}
