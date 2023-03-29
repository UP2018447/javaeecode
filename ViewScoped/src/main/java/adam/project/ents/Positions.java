/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adam.project.ents;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adamt
 */
public class Positions {

    private static Map<String, String> positions = null;

    public Positions() {
        init();
    }

    private void init() {
        if (positions == null) {
            positions = new HashMap<>();
            positions.put("QB", "QB");
            positions.put("RB", "RB");
            positions.put("FB", "FB");
            positions.put("WR", "WR");
            positions.put("TE", "TE");
            positions.put("OL", "OL");
            positions.put("C", "C");
            positions.put("G", "G");
            positions.put("LG", "LG");
            positions.put("RG", "RG");
            positions.put("T", "T");
            positions.put("LT", "LT");
            positions.put("RT", "RT");
            positions.put("K", "K");
            positions.put("KR", "KR");
            positions.put("DL", "DL");
            positions.put("DE", "DE");
            positions.put("DT", "DT");
            positions.put("NT", "NT");
            positions.put("LB", "LB");
            positions.put("ILB", "ILB");
            positions.put("OLB", "OLB");
            positions.put("MLB", "MLB");
            positions.put("DB", "DB");
            positions.put("CB", "CB");
            positions.put("FS", "FS");
            positions.put("SS", "SS");
            positions.put("S", "S");
            positions.put("P", "P");
            positions.put("PR", "PR");
        }
    }

    public Map<String, String> getPositions() {
        return positions;
    }

    public void setPositions(Map<String, String> positions) {
        Positions.positions = positions;
    }

}
