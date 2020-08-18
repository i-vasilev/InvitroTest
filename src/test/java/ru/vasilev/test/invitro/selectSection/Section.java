package ru.vasilev.test.invitro.selectSection;

public enum Section {
    PATIENTS("PATIENTS"), DOCTOR("DOCTOR"),
    FRANCHCHISING("FRANCHCHISING"), CORP_CLIENT("CORP_CLIENT"),
    PRESS("PRESS");
    private final String value;

    private Section(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
