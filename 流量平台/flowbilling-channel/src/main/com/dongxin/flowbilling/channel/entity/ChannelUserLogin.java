package dongxin.flowbilling.channel.entity;

/**
 * 登陆用户信息实体类
 *
 * @author yusongyuan
 * @create 2017-12-05 15:39
 **/
public class ChannelUserLogin {

    private int id;
    private String username;
    private String password;
    private int status;
    private String chname; //人员所属供应商名称

    @Override
    public String toString() {
        return "ChannelUserLogin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", chname='" + chname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }
}
