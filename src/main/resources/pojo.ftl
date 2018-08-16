package ${packageName};

import java.io.Serializable;
<#if table.hasDate>
import java.util.Date;
</#if>

public class ${table.className} implements Serializable {

            <#list table.filedList as field>
                <#if field.remarks != "">
                // ${field.remarks}
                </#if>
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
