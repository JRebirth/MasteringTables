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

import org.jrebirth.af.core.resource.color.ColorEnum;

/**
 * The MTColors interface providing all colors.
 */
public enum MTColors implements ColorEnum {

    // @formatter:off

    /** The result ratio background color. */
    RESULT_RATIO {
        {
            web("bdccd4");
        }
    },

    /** The result time background color. */
    RESULT_TIME {
        {
            web("fbb03b");
        }
    },

    /** The result success background color. */
    RESULT_SUCCESS {
        {
            web("95cd8b");
        }
    },

    /** The result ratio background color. */
    RESULT_FAILURE {
        {
            web("e7685d");
        }
    },

    /** The bean shadow color. */
    BEAN_SHADOW {
        {
            web("4c4945");
        }
    };

}
