/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.demo.masteringtables.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * The Class Game.
 */
public class Game {

    /** The success count. */
    private final IntegerProperty successCount = new SimpleIntegerProperty(0);

    /** The failure count. */
    private final IntegerProperty failureCount = new SimpleIntegerProperty(0);

    /**
     * Success count property.
     * 
     * @return the integer property
     */
    public IntegerProperty successCountProperty() {
        return this.successCount;
    }

    /**
     * Gets the success count.
     * 
     * @return the success count
     */
    public int getSuccessCount() {
        return this.successCount.get();
    }

    /**
     * Sets the success count.
     * 
     * @param successCount the new success count
     */
    public void setSuccessCount(final int successCount) {
        this.successCount.set(successCount);
    }

    /**
     * Failure count property.
     * 
     * @return the integer property
     */
    public IntegerProperty failureCountProperty() {
        return this.failureCount;
    }

    /**
     * Gets the failure count.
     * 
     * @return the failure count
     */
    public int getFailureCount() {
        return this.failureCount.get();
    }

    /**
     * Sets the failure count.
     * 
     * @param failureCount the new failure count
     */
    public void setFailureCount(final int failureCount) {
        this.failureCount.set(failureCount);
    }

}
