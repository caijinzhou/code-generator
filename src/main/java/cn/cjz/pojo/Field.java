package cn.cjz.pojo;

/**
 * Created by shang-pc on 2017/7/4.
 * modify by cjz on 2018/8/18
 */
public class Field {
    public String getOldFiledName() {
        return oldFiledName;
    }

    public void setOldFiledName(String oldFiledName) {
        this.oldFiledName = oldFiledName;
    }

    public String getNewFiledName() {
        return newFiledName;
    }

    public void setNewFiledName(String newFiledName) {
        this.newFiledName = newFiledName;
    }

    private String cloumnName;

    private String filedType;

    private String oldFiledName;

    private String newFiledName;

    public String getCloumnName() {
        return cloumnName;
    }

    public void setCloumnName(String cloumnName) {
        this.cloumnName = cloumnName;
    }

    private String upperfiledName;

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }



    public String getUpperfiledName() {
        return upperfiledName;
    }

    public void setUpperfiledName(String upperfiledName) {
        this.upperfiledName = upperfiledName;
    }
}
