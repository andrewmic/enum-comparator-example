package lt.itacademy.example.comparator;

import lt.itacademy.example.domain.LoanRiskType;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SwitchlessMappedValueBasedLoanRiskComparator implements Comparator<LoanRiskType> {

    //This is a statically ("{{ ... }}") initialized constants map, which holds "LoanRiskType" ranks.
    //Pretty neat stuff, won't you agree? :)

    private final Map<LoanRiskType, Integer> LOAN_RISK_TYPE_RANKS = new HashMap<LoanRiskType, Integer>() {{
        put(LoanRiskType.LOW_RISK, 0);
        put(LoanRiskType.NORMAL_RISK, 1);
        put(LoanRiskType.HIGH_RISK, 2);
    }};


    @Override
    public int compare(LoanRiskType loanRiskTypeToCompare, LoanRiskType loanRiskTypeToCompareWith) {

        //
        //PLEASE SEE "MappedValueBasedLoanRiskComparator" FIRST
        //
        //This is same as "MappedValueBasedLoanRiskComparator", but with switch statement usage removed.
        //This is my favorite comparator of the bunch.
        //

        return getRank(loanRiskTypeToCompare).compareTo(getRank(loanRiskTypeToCompareWith));
    }

    private Integer getRank(LoanRiskType loanRiskType) {
        Integer rank = LOAN_RISK_TYPE_RANKS.get(loanRiskType);
        if (rank == null) {
            throw new IllegalArgumentException("LoanRiskType = " + loanRiskType + " not implemented yet!");
        }
        return rank;
    }
}
