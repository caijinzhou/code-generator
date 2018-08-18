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
                public static final String ${field.cloumnName} = "${field.oldFiledName}";
                private ${field.filedType} ${field.newFiledName};

            </#list>

            <#list table.filedList as field>
            public void set${field.upperfiledName} (${field.filedType}  ${field.newFiledName}){
                this.${field.newFiledName}=${field.newFiledName};
            }

            public  ${field.filedType} get${field.upperfiledName}(){
                return this.${field.newFiledName};
            }
            </#list>
}
