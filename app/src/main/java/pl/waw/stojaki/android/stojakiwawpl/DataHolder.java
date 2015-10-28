package pl.waw.stojaki.android.stojakiwawpl;

import java.util.ArrayList;

/**
 * Created by Mon on 2015-02-05.
 */
public class DataHolder {
    private ArrayList<BikeRack> data;

    public ArrayList<BikeRack> getData() {return data;}
    public void setData(ArrayList<BikeRack> data){this.data = data;}

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}

}
