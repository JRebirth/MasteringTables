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

import org.jrebirth.af.api.resource.font.FontExtension;
import org.jrebirth.af.core.resource.font.FontEnum;

/**
 * The MTFonts enumeration providing all fonts.
 */
public enum MTFonts implements FontEnum {

    // @formatter:off

    /** The font used to display expression. */
    EXPRESSION {{ real(MTFontNames.NYALA, 130.0, FontExtension.TTF); }},

    /** The font used to display counter values. */
    COUNTER {{ real(MTFontNames.NYALA, 50.0, FontExtension.TTF); }};

}
