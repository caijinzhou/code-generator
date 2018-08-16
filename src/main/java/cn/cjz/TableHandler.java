package cn.cjz;

import cn.cjz.pojo.Field;
import cn.cjz.pojo.Table;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zezhong.shang on 17-6-5.
 */
public class TableHandler {

    private static String DBDRIVER = PropertiesUtils.get("database.properties", "driver");

    private static String DBURL = PropertiesUtils.get("database.properties", "url");

    private static String DBUSER = PropertiesUtils.get("database.properties", "user");

    private static String DBPASS = PropertiesUtils.get("database.properties", "password");

    public static List<Table> queryDataTables() {
        DatabaseMetaData dmd = null;
        Connection conn = null;
        List<Table> tables = new ArrayList<>();
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                Table table=new Table();
                table.setClassName(captureName(putOffUnderline(tableName)));
                ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
                while (rs.next()) {
                    String cloumnName=rs.getString("COLUMN_NAME");
                    String cloumnType=rs.getString("TYPE_NAME");
                    Field field=new Field();
                    field.setUpperfiledName(captureName(cloumnName));
                    field.setFiledName(cloumnName);
                    field.setFiledType(switchType(cloumnType));
                    table.addFiledList(field);
                }
                tables.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tables;
    }

    public static String putOffUnderline(String columnName) {
        StringBuffer fieldNameBuffer = null;
        String tempNameArray[] = columnName.split("_");
        for (int i = 0; i < tempNameArray.length; i++) {
            if (i == 0) {
                fieldNameBuffer = new StringBuffer(tempNameArray[i]);
            } else {
                fieldNameBuffer.append(captureName(tempNameArray[i]));
            }
        }
        return fieldNameBuffer.toString();
    }

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    public static String switchType(String cloumnType){
        String fieldType=null;

        if(cloumnType.equals("VARCHAR")){
            fieldType="String";
        }else if(cloumnType.equals("BIGINT")){
            fieldType="Long";
        }else if(cloumnType.equals("INT")){
            fieldType="Integer";
        }else if(cloumnType.equals("DATETIME")){
            fieldType="Date";
        }else{
            fieldType="String";
        }
        return fieldType;
    }

    public static void main(String args[]){
        TableHandler th=new TableHandler();
        th.queryDataTables();
    }
}
