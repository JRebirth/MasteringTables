/**
 * @author Sébastien Bordes
 */

import org.jrebirth.af.api.module.ModuleStarter;
import org.jrebirth.demo.masteringtables.MasteringtablesModuleStarter;

open module org.jrebirth.demo.masteringtables {

    requires org.jrebirth.af.core;
    requires org.jrebirth.af.component;
    
    requires org.slf4j;
    
    provides ModuleStarter with MasteringtablesModuleStarter;
}
