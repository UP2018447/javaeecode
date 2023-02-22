/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.converter;

import tutorial.learnprogramming.form4.ent.TimeData;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author adamt
 */

@FacesConverter("com.converter.TimeConverter")
public class TimeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String time) {
        String[] splitTime;
        if (time.contains("'")){
            splitTime = time.split("'");
        }
        else if (time.contains(".")){
            splitTime = time.split(".");
        }
        else if (time.contains(";")){
            splitTime = time.split(";");
        }
        else if (time.contains(":")){
            splitTime = time.split(":");
        }
        else if (time.contains("-")){
            splitTime = time.split("-");
        }
        else {
            splitTime = time.split("_");
        }
        //String minutes = array[0];
        //String seconds = array[1];
        //int minutes2 = Integer.parseInt(minutes);
        //int seconds2 = Integer.parseInt(seconds);
        //int minutesToSeconds = minutes2 * 60;
        //int totalTime = minutesToSeconds + seconds2;
        //String timeRemaining = Integer.toString(totalTime);
        String min = splitTime[0];
        String secs = splitTime[1];
        int mins = Integer.parseInt(min);
        int sec = Integer.parseInt(secs);
        int minsToSecs = mins * 60;
        sec = sec + minsToSecs;
        String totalSeconds = Integer.toString(sec);
        TimeData data = new TimeData();
        data.setSeconds(sec);
        return data;
        //String[] array;
        //if(time.contains("'")){
            //array = time.split("'");
        //}
        //else if(time.contains(".")){
            //array = time.split(".");
        //}
        //else if(time.contains(":")){
            //array = time.split(":");
        //}
        //else if(time.contains(";")){
            //array = time.split(";");
        //}
        //else if(time.contains(",")){
            //array = time.split(",");
        //}
        //else {
            //array = time.split("0");
        //}
        //String min = array[0];
        //String secs = array[1];
        //int mins = Integer.parseInt(min);
        //int sec = Integer.parseInt(secs);
        //int minsToSecs = mins * 60;
        //sec = sec + minsToSecs;
        //String totalSeconds = Integer.toString(sec);
        //timeData time2 = new timeData(totalSeconds);
        //return time2;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        TimeData data = (TimeData) t;
        String seconds = t.toString();
        int secs = Integer.parseInt(seconds);
        int remainingSeconds = secs % 60;
        secs = secs - remainingSeconds;
        int minutes = secs / 60;
        String mins = Integer.toString(minutes);
        String secsRemaining = Integer.toString(remainingSeconds);
        String time = mins + "'" + secsRemaining;
        return time;
        //String seconds = t.toString();
        //int secs = Integer.parseInt(seconds);
        //int remainingSeconds = secs % 60;
        //secs = secs - remainingSeconds;
        //int minutes = secs / 60;
        //String mins = Integer.toString(minutes);
        //String secsRemaining = Integer.toString(remainingSeconds);
        //String time = mins + "'" + secsRemaining;
        //return time;
    }


    
}
