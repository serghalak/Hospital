package com.softserve.service;

/**
 * Created by Serg on 15.04.2018.
 */
public enum TimeVisit {

    P1("8-00",1),P2("8-30",2),P3("9-00",3),P4("9-30",4),
    P5("10-00",5),P6("10-30",6),P7("11-00",7),P8("11-30",8),
    P9("13-00",9),P10("13-30",10),P11("14-00",11),P12("14-30",12),
    P13("15-00",13),P14("15-30",14),P15("16-00",15),P16("16-30",16);

    private String _time;
    private int _nomerOrder;

    private TimeVisit(String time,int order){
        _time=time;
        _nomerOrder=order;
    }

    @Override
    public String toString() {
        return "TimeVisit{" +
                "time='" + _time + '\'' +
                ", your number=" + _nomerOrder +
                '}';
    }
}
