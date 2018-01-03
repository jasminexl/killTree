package dongxin.flowbilling.channel.entity;

/**
 * 渠道备用金实体类
 *
 * @author yusongyuan
 * @create 2017-12-05 20:13
 **/

public class byjChannel {

    private String chcode; //渠道编码
    private double runmoney; //实时备用金
    private double minalarmmoney;
    private double maxalarmmoney; //授信金额
    private double bzjmoney; //保证金金额
    private int status; //状态 0：正常，1：停止
    private String inserttime;
    private String nameqc; //公司全称
    private String chname; //渠道名称

    @Override
    public String toString() {
        return "byjChannel{" +
                "chcode='" + chcode + '\'' +
                ", runmoney=" + runmoney +
                ", minalarmmoney=" + minalarmmoney +
                ", maxalarmmoney=" + maxalarmmoney +
                ", status=" + status +
                ", inserttime='" + inserttime + '\'' +
                ", nameqc='" + nameqc + '\'' +
                ", chname='" + chname + '\'' +
                '}';
    }

    public String getChcode() {
        return chcode;
    }

    public void setChcode(String chcode) {
        this.chcode = chcode;
    }

    public double getRunmoney() {
        return runmoney;
    }

    public void setRunmoney(double runmoney) {
        this.runmoney = runmoney;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    public String getNameqc() {
        return nameqc;
    }

    public void setNameqc(String nameqc) {
        this.nameqc = nameqc;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }
}
