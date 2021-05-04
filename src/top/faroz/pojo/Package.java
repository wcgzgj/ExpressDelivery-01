package top.faroz.pojo;

import java.io.Serializable;

/**
 * @ClassName Package
 * @Description 快递实体类
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:11
 * @Version 1.0
 **/
public class Package implements Serializable {
    //柜子位置
    private Integer location;
    //快递单号
    private String id;
    //快递公司
    private String business;
    //6 位取件码
    private Integer getCode;

    public Package(Integer location, String id, String business, Integer getCode) {
        this.location = location;
        this.id = id;
        this.business = business;
        this.getCode = getCode;
    }

    public Package() {
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Integer getGetCode() {
        return getCode;
    }

    public void setGetCode(Integer getCode) {
        this.getCode = getCode;
    }

    @Override
    public String toString() {
        return "Package{" +
                "存储柜号:" + location +"\n"+
                ", 快递单号='" + id + '\'' +"\n"+
                ", 快递公司='" + business + '\'' +"\n"+
                ", 取件码=" + getCode +
                '}';
    }
}
