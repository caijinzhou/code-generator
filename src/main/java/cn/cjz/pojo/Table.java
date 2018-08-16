package cn.cjz.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shang-pc on 2017/7/4.
 */
public class Table {

    private String className;

    private List<Field> filedList = new ArrayList<Field>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Field> getFiledList() {
        return filedList;
    }

    public void addFiledList(Field field) {
        this.filedList.add(field);
    }
}
