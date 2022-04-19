package cn.library.student;

public class Logquanbu {
    private int st_id;
    private int bk_id;
    private String bk_name;
    private String status;
    private String creact_time;

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public int getBk_id() {
        return bk_id;
    }

    public void setBk_id(int bk_id) {
        this.bk_id = bk_id;
    }

    public String getBk_name() {
        return bk_name;
    }

    public void setBk_name(String bk_name) {
        this.bk_name = bk_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreact_time() {
        return creact_time;
    }

    public void setCreact_time(String creact_time) {
        this.creact_time = creact_time;
    }

    @Override
    public String toString() {
        return "Logquanbu{" +
                "st_id=" + st_id +
                ", bk_id=" + bk_id +
                ", bk_name='" + bk_name + '\'' +
                ", status='" + status + '\'' +
                ", creact_time='" + creact_time + '\'' +
                '}';
    }
}
