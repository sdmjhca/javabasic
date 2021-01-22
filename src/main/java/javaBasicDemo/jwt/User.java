package javaBasicDemo.jwt;

/**
 * @author JHMI on 2019/3/20.
 */
public class User {
    private String name;
    private String remark;
    private String phone;

    public User(String name, String remark, String phone) {
        this.name = name;
        this.remark = remark;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
