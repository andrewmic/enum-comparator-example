package lt.itacademy.example.domain;

public enum IndexedLoanRiskType {
    HIGH_RISK(2),
    NORMAL_RISK(1),
    LOW_RISK(0);

    private final Integer index;

    IndexedLoanRiskType(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
