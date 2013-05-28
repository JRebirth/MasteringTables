package org.jrebirth.demo.masteringtables.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Game {

    private final IntegerProperty successCount = new SimpleIntegerProperty(0);

    private final IntegerProperty failureCount = new SimpleIntegerProperty(0);

    public IntegerProperty successCountProperty() {
        return this.successCount;
    }

    public int getSuccessCount() {
        return this.successCount.get();
    }

    public void setSuccessCount(final int successCount) {
        this.successCount.set(successCount);
    }

    public IntegerProperty failureCountProperty() {
        return this.failureCount;
    }

    public int getFailureCount() {
        return this.failureCount.get();
    }

    public void setFailureCount(final int failureCount) {
        this.failureCount.set(failureCount);
    }

}
