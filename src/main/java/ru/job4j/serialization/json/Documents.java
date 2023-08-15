package ru.job4j.serialization.json;

public class Documents {
    private final String passId;
    private final String contractId;

    public Documents(String passId, String contractId) {
        this.passId = passId;
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "Documents{"
                + "passId='" + passId + '\''
                + ", contractId='" + contractId + '\''
                + '}';
    }
}
