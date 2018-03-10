package lt.itacademy.example.comparator;

import lt.itacademy.example.domain.LoanRiskType;

import java.util.Comparator;

public class NaiveLoanRiskTypeComparator implements Comparator<LoanRiskType> {

    //Comparator compares two Enum objects by simply calling Enum.compareTo(...)
    //Problem with this approach is that if value order inside Enum would change, this comparator will fail working
    // according our expectations.

    @Override
    public int compare(LoanRiskType loanRiskTypeToCompare, LoanRiskType loanRiskTypeToCompareWith) {
        //Here is how you can switch comparison order easily
        //return loanRiskTypeToCompare.compareTo(loanRiskTypeToCompareWith);  -  1. For ascending order
        //return loanRiskTypeToCompareWith.compareTo(loanRiskTypeToCompare);  -  2. For descending order
        //return -loanRiskTypeToCompare.compareTo(loanRiskTypeToCompareWith); -  3. Also for descending order.
        //                                                                          Same as (1), but with "-" in front (-1 * comparison result)

        return loanRiskTypeToCompare.compareTo(loanRiskTypeToCompareWith);
    }
}
