package dongxin.flowbilling.channel.entity;

/**
 * 渠道备用金实体类
 *
 * @author yusongyuan
 * @create 2017-12-05 20:13
 **/

public class RunLogChannelInfo {

    private String chcode;
    private double initmoney;
    private double totalmoney;
    private double minalarmmoney;
    private double maxalarmmoney;
    private double bzjmoney;
    private int status;
    private String updatetime;
    private String nameqc; //公司全称
    private String chname; //渠道名称

    @Override
    public String toString() {
        return "RunLogChannelInfo{" +
                "chcode='" + chcode + '\'' +
                ", initmoney=" + initmoney +
                ", totalmoney=" + totalmoney +
                ", minalarmmoney=" + minalarmmoney +
                ", maxalarmmoney=" + maxalarmmoney +
                ", bzjmoney=" + bzjmoney +
                ", status=" + status +
                ", updatetime='" + updatetime + '\'' +
                ", nameqc='" + nameqc + '\'' +
                ", chname='" + chname + '\'' +
                '}';
    }

    public String getNameqc() {
        return nameqc;
    }

    public void setNameqc(String nameqc) {
        this.nameqc = nameqc;
    }

    public String getChcode() {
        return chcode;
    }

    public void setChcode(String chcode) {
        this.chcode = chcode;
    }

    public double getInitmoney() {
        return initmoney;
    }

    public void setInitmoney(double initmoney) {
        this.initmoney = initmoney;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public double getMinalarmmoney() {
        return minalarmmoney;
    }

    public void setMinalarmmoney(double minalarmmoney) {
        this.minalarmmoney = minalarmmoney;
    }

    public double getMaxalarmmoney() {
        return maxalarmmoney;
    }

    public void setMaxalarmmoney(double maxalarmmoney) {
        this.maxalarmmoney = maxalarmmoney;
    }

    public double getBzjmoney() {
        return bzjmoney;
    }

    public void setBzjmoney(double bzjmoney) {
        this.bzjmoney = bzjmoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }
}
