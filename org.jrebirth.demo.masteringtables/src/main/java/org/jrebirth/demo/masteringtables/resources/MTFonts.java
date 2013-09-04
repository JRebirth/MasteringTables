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

import org.jrebirth.core.resource.font.FontItem;
import org.jrebirth.core.resource.font.RealFont;

/**
 * The MTFonts interface providing all fonts.
 */
public interface MTFonts {

    /** The font used to display expression. */
    FontItem EXPRESSION = create(new RealFont(MTFontNames.NYALA, 130.0));

    /** The font used to display counter values. */
    FontItem COUNTER = create(new RealFont(MTFontNames.NYALA, 50.0));

}
