package cn.cjz;

import cn.cjz.pojo.Table;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2017/7/4.
 */
public class CodeMain {

    private Configuration configuration = new Configuration();

    //1.初始化配置
    public void init() {
        try {
            String path = this.getClass().getClassLoader().getResource("").getPath();
            //设置模板所在文件夹
            configuration.setDirectoryForTemplateLoading(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2.获取模板生成相应数据
    public void process(Map<String, Object> param, String tempName, String fileDir) {
        try {
            Template template = configuration.getTemplate(tempName);
            FileOutputStream stream=new FileOutputStream(fileDir);
            template.process(param,new OutputStreamWriter(stream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CodeMain codeMain=new CodeMain();
        codeMain.init();
        List<Table> tableList=TableHandler.queryDataTables();
        for (Table table:tableList){
            Map<String,Object> param=new HashMap<>();
            param.put("table",table);
            param.put("packageName","cn.cjz.pojo");
            codeMain.process(param,"pojo.ftl","H:\\code\\"+table.getClassName()+".java");

        }
    }
}
