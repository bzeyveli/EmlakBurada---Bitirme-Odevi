package com.patika.emlakburada.model.enums;

public enum Status {

    ACTIVE("Aktif"),
    PASSIVE("Pasif"),
    INREVIEW("İncelemede");

    private final String key;

    Status(final String key) {
        this.key = key;
    }

    public static Status get(Integer ordinal) {
        if (ordinal != null) {
            if (ordinal == 0) {
                return Status.ACTIVE;
            } else if (ordinal == 1) {
                return Status.PASSIVE;
            } else if(ordinal == 2){
                return Status.INREVIEW;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return key;
    }
}
