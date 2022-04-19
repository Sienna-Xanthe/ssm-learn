package cn.library.student;

public class Logs {
    private String bk_name;
    private String status;
    private String creact_time;

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
        return "Logs{" +
                "bk_name='" + bk_name + '\'' +
                ", status='" + status + '\'' +
                ", creact_time='" + creact_time + '\'' +
                '}';
    }
}
