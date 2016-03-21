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

import org.jrebirth.af.api.resource.image.ImageExtension;
import org.jrebirth.af.core.resource.image.ImageEnum;

/**
 * The MTImages enumeration providing all images.
 */
public enum MTImages implements ImageEnum {

    // @formatter:off

    /** The application main title image. */
    MT_TITLE                {{  rel("Title", ImageExtension.PNG); }},

    /** The application main title image. */
    POWERED_BY              {{  rel("PoweredBy", ImageExtension.PNG); }},

    /** Monster used into Result page (Monster is reading a book). */
    RESULT_MONSTER          {{ rel("Result_Monster", ImageExtension.PNG); }},

    /** The success icon used to count a good answer. */
    RESULT_SUCCESS_ICON     {{ rel("Result_Success_Icon", ImageExtension.PNG); }},

    /** The failure icon used to count a bad answer. */
    RESULT_FAILURE_ICON     {{ rel("Result_Failure_Icon", ImageExtension.PNG); }};

}
