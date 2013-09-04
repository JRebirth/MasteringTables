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
package org.jrebirth.demo.masteringtables.resources;

import static org.jrebirth.core.resource.Resources.create;

import org.jrebirth.core.resource.color.ColorItem;
import org.jrebirth.core.resource.color.WebColor;

/**
 * The MTColors interface providing all colors.
 */
public interface MTColors {

    /** The result ratio background color. */
    ColorItem RESULT_RATIO = create(new WebColor("bdccd4"));

    /** The result time background color. */
    ColorItem RESULT_TIME = create(new WebColor("fbb03b"));

    /** The result success background color. */
    ColorItem RESULT_SUCCESS = create(new WebColor("95cd8b"));

    /** The result ratio background color. */
    ColorItem RESULT_FAILURE = create(new WebColor("e7685d"));

    /** The bean shadow color. */
    ColorItem BEAN_SHADOW = create(new WebColor("4c4945"));
}
