package javaBasicDemo.stream;

/**
 * @author JHMI on 2020/4/27.
 */
public class ActDto {

    private String cityCode;
    private int num;
    private int rentNum;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRentNum() {
        return rentNum;
    }

    public void setRentNum(int rentNum) {
        this.rentNum = rentNum;
    }

    @Override
    public String toString() {
        return "ActDto{" +
                "cityCode='" + cityCode + '\'' +
                ", num=" + num +
                ", rentNum=" + rentNum +
                '}';
    }
}
