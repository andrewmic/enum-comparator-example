package lt.itacademy.example.comparator;

import lt.itacademy.example.domain.IndexedLoanRiskType;

import java.util.Comparator;

public class ComparableEnumFieldBasedLoanRiskTypeComparator implements Comparator<IndexedLoanRiskType> {

    @Override
    public int compare(IndexedLoanRiskType indexedLoanRiskTypeToCompare,
                       IndexedLoanRiskType indexedLoanRiskTypeToCompareWith) {

        //
        //PLEASE SEE "NaiveLoanRiskTypeComparator" FIRST
        //
        //Instead of calling compareTo(...) directly on an Enum we are using a "IndexedLoanRiskType" field ("index")
        // instead. "index" field value represents rank/priority of associated "IndexedLoanRiskType" value
        // (LOW_RISK = 0, NORMAL_RISK = 2, HIGH_RISK = 3).
        //
        //If "IndexedLoanRiskType" value order would change, it won't affect comparison/sorting result.
        //
        //Problem with this approach, though, it violates SINGLE RESPONSIBILITY PRINCIPLE. "LoanRiskType" should not
        // know how it is being compared/sorted. "LoanRiskType" should only store loan risk relevant information and
        // and sorting details should be covered by a comparator implementation.
        //

        return indexedLoanRiskTypeToCompare.getIndex().compareTo(indexedLoanRiskTypeToCompareWith.getIndex());
    }
}
