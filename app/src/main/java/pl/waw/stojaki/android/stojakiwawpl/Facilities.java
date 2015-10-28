package pl.waw.stojaki.android.stojakiwawpl;

/**
 * Created by Mon on 2015-02-03.
 */
public class Facilities {


    @Override
    public String toString() {
        return  "bikelane:" + Facilities.bolString(bikelane)+"\n" +
                ",roof:" + Facilities.bolString(roof) + "\n" +
                ",monitoring:" + Facilities.bolString(monitoring) + "\n"+
                ",wrench:" + Facilities.bolString(wrench) +"\n";

    }

    public Facilities() {
        this.bikelane = false;
        this.monitoring = false;
        this.roof = false;
        this.wrench = false;
    }
    public static String bolString(boolean var){
        if (!var){
            return "NO";
        }else{
            return "YES";
        }
    }
    public boolean isBikelane() {
        return bikelane;
    }

    public void setBikelane(boolean bikelane) {
        this.bikelane = bikelane;
    }

    public boolean isRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public boolean isMonitoring() {
        return monitoring;
    }

    public void setMonitoring(boolean monitoring) {
        this.monitoring = monitoring;
    }

    public boolean isWrench() {
        return wrench;
    }

    public void setWrench(boolean wrench) {
        this.wrench = wrench;
    }



    private boolean bikelane;
    private boolean roof;
    private boolean monitoring;
    private boolean wrench;
}
