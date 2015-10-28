package pl.waw.stojaki.android.stojakiwawpl;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Created by Mon on 2015-02-04.
 */
public class FileXMLparse {

    public ArrayList<BikeRack> list;
    private InputStream asset;
    public String message;

    public FileXMLparse(InputStream in) throws IOException {
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            this.asset = in;
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(asset,null);
            parseXML(parser);
           // message ="I did parse";

        } catch (XmlPullParserException e) {
            message = "Did not parse";
            e.printStackTrace();
        }



    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        this.list = null;
        int eventType = parser.getEventType();
        BikeRack currentBike = null;
        InfoClass buffInfo = null;
        Facilities buffFace = null;
        while (eventType !=XmlPullParser.END_DOCUMENT ){
            String name = null;
            switch(eventType){
                case XmlPullParser.START_DOCUMENT:
                    list = new ArrayList<BikeRack>();
                    //message = "i started the document";
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    //message = name;
                    if("info".equals(name)){
                        buffInfo = new InfoClass();
                        message = "i started infoclass";
                    } else if(buffInfo != null){
                        if (name.equals("author")){
                            buffInfo.author = parser.nextText();
                        } else if(name.equals("website")){
                            buffInfo.website = parser.nextText();
                        } else if(name.equals("lastupdate")){
                            buffInfo.date = parser.nextText();
                        }
                    }
                    if("rack".equals(name)){
                       // message = "zrobilem racka";
                        currentBike = new BikeRack();
                    }else if(currentBike != null){
                        if (name.equals("district")){
                           currentBike.setDistrict(parser.nextText());
                           //message = "dodalem dzielnice";
                        } else if(name.equals("name")){
                            currentBike.setName(parser.nextText());
                        } else if(name.equals("description")){
                            currentBike.setDescription(parser.nextText());
                        } else if(name.equals("number")) {
                            currentBike.setNumberOf(parser.nextText());
                        } else if(name.equals("latitude")){
                            currentBike.setLat(Double.parseDouble(parser.nextText()));
                        } else if(name.equals("longitude")){
                            currentBike.setLng(Double.parseDouble(parser.nextText()));
                        } else if(name.equals("facilities")){
                            this.message = "robilem facility";
                            buffFace = new Facilities();
                        } else if(buffFace!=null&&name.equals("bikelane")) {
                            //this.message = "wszedlem w bikelane";
                            if (parser.nextText().equals("yes")) {
                                buffFace.setBikelane(true);
                            }
                        }else if(buffFace!=null&&name.equals("roof")) {
                            if (parser.nextText().equals("yes")) {
                                buffFace.setRoof(true);
                            }
                        }else if(buffFace!=null&&name.equals("monitoring")) {
                            String next = parser.nextText();
                            message = next + ' ' + name;
                            if (next.equals("yes")) {
                                buffFace.setMonitoring(true);
                                this.message = "zmienilem roof";
                            }
                        }else if(buffFace!=null&&name.equals("wrench")) {
                            if (parser.nextText().equals("yes")) {
                                buffFace.setWrench(true);
                            }
                        }else if(name.equals("limit")){
                            if(parser.nextText().equals("yes")){
                                currentBike.setLimit(true);
                            } else{
                                currentBike.setLimit(false);
                            }

                        } else if(name.equals("status")){
                            if(parser.nextText().equals("verified")){
                                currentBike.setStatus(true);
                            } else{
                                currentBike.setStatus(false);
                            }
                        } else if(name.equals("photo")){
                            this.message = "dodalem photo ty kurwo jebana";
                        }
                    }
                break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if(name.equalsIgnoreCase("rack")&&currentBike!=null){
                        list.add(currentBike);

                    }else if(name.equalsIgnoreCase("facilities")&&currentBike!=null){
                        currentBike.setFacilities(buffFace);
                        this.message = "dodalem facilki";
                        this.message = buffFace.toString();
                    }

            }
            eventType = parser.next();
        }
        int n = list.size();
        message = "lista obiektow : " + n;

    }



}
