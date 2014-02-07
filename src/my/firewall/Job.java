package my.firewall;
//basic job class with getters and setters we may need
//must have port and hash for firewall statefull inspection and port blocking
public class Job {
    private int num;
    private int port;
    private int hash;

    public Job(int num, int port, int hash) {
        this.num = num;
        this.port = port;
        this.hash = hash;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int getNum() {
        return num;
    }

    public int getPort() {
        return port;
    }

    public int getHash() {
        return hash;
    }

    public String toString() {
        return num + " " + port + " " + hash;
    }
}