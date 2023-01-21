/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.ent;

import java.util.Map;

/**
 *
 * @author adamt
 */
public class Positions {
    
    public Map<String,String> getPositions(Map<String,String> positionList){
        positionList.put("QB","QB");
        positionList.put("RB","RB");
        positionList.put("FB","FB");
        positionList.put("WR","WR");
        positionList.put("TE","TE");
        positionList.put("OL","OL");
        positionList.put("C","C");
        positionList.put("G","G");
        positionList.put("LG","LG");
        positionList.put("RG","RG");
        positionList.put("T", "T");
        positionList.put("LT", "LT");
        positionList.put("RT", "RT");
        positionList.put("K", "K");
        positionList.put("KR", "KR");
        positionList.put("DL", "DL");
        positionList.put("DE", "DE");
        positionList.put("DT", "DT");
        positionList.put("NT", "NT");
        positionList.put("LB", "LB");
        positionList.put("ILB", "ILB");
        positionList.put("OLB", "OLB");
        positionList.put("MLB", "MLB");
        positionList.put("DB", "DB");
        positionList.put("CB", "CB");
        positionList.put("FS", "FS");
        positionList.put("SS", "SS");
        positionList.put("S", "S");
        positionList.put("P", "P");
        positionList.put("PR", "PR");
        positionList.put("unknown", "unknown");
        positionList.put("Position","Position");
        return positionList;
    }
    
}
