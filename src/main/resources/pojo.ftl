package ${packageName};

import java.io.Serializable;
import java.util.Date;

public class ${table.className} implements Serializable {

            <#list table.filedList as field>
                 private ${field.filedType} ${field.filedName};
            </#list>

            <#list table.filedList as field>
            public void set${field.upperfiledName} (${field.filedType}  id){
                this.${field.filedName}=${field.filedName};
            }

            public  ${field.filedType} get${field.upperfiledName}(){
                return this.${field.filedName};
            }
            </#list>
}
