package com.rayjackson.ood.sorttypes;

/**
 * Created by rayjackson on 30.09.2017.
 */
public enum SortType {
    SHELL_SORT("shell"), RADIX_SORT("radix"), QUICK_SORT("quick"), MERGE_SORT("merge");
    private final String type;

    SortType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
