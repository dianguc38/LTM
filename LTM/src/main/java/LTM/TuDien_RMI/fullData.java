package LTM.TuDien_RMI;

import java.security.PublicKey;
import java.util.StringTokenizer;

public class fullData {
    public String eng;
    public String viet;
    public String mean;

    public fullData(String eng, String viet,String mean){
        this.eng = eng;
        this.viet = viet;
        this.mean = mean;
    }
    public fullData(){}

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }


}
