package javaBasicDemo.stream;

/**
 * @author JHMI on 2020/4/27.
 */
public class Result {

    private String cityCode;

    private int cNum;

    private int aNum;

    private int bNum;


    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public int getaNum() {
        return aNum;
    }

    public void setaNum(int aNum) {
        this.aNum = aNum;
    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }

    @Override
    public String toString() {
        return "Result{" +
                "cityCode='" + cityCode + '\'' +
                ", cNum=" + cNum +
                ", aNum=" + aNum +
                ", bNum=" + bNum +
                '}';
    }
}
