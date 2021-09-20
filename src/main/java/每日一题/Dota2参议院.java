package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: Dota2参议院
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-11
 */
public class Dota2参议院 {
    public String predictPartyVictoryMy(String senate) {
        StringBuilder str = new StringBuilder(senate);
        int dIndex = 0;
        int rIndex = 0;
        int len;
        while (true) {
            len = str.length();
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == 'R') {
                    rIndex = i + 1 == len ? 0 : i + 1;
                    while ( rIndex != i && (str.charAt(rIndex) == 'R' || str.charAt(rIndex) == 'N')) {
                        rIndex++;
                        if (rIndex == len) {
                            rIndex = 0;
                        }
                    }
                    if (str.charAt(rIndex) == 'D') {
                        str.setCharAt(rIndex, 'N');
                    }
                }
                if (str.charAt(i) == 'D') {
                    dIndex = i + 1 == len ? 0 : i + 1;
                    while (dIndex != i && (str.charAt(dIndex) == 'D' || str.charAt(dIndex) == 'N')) {
                        dIndex++;
                        if (dIndex == len) {
                            dIndex = 0;
                        }
                    }
                    if (dIndex != i) {
                        str.setCharAt(dIndex, 'N');
                    }
                }
            }
            int j = 0;
            StringBuilder tmp = new StringBuilder(str);
            str = new StringBuilder();
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) != 'N') {
                    str.append(tmp.charAt(i));
                }
            }
            if (str.length() == 1) {
                break;
            }
            int rCount = 0;
            int dCount = 0;
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == 'R') {
                    rCount++;
                } else {
                    dCount++;
                }
            }
            if (rCount == str.length() || dCount == str.length()) {
                break;
            }
        }
        return str.charAt(0) == 'D' ? "Dire" : "Radiant";
    }


    public String predictPartyVictory(String senate){
        LinkedList<Integer> dire = new LinkedList<>();
        LinkedList<Integer> radiant = new LinkedList<>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
            if (senate.charAt(i) == 'D') {
                dire.addLast(i);
            } else {
                radiant.addLast(i);
            }
        }
        while (!dire.isEmpty() && !radiant.isEmpty()) {
            int d = dire.removeFirst();
            int r = radiant.removeFirst();
            if (d < r) {
                dire.addLast(d + len);
            } else {
                radiant.addLast(r + len);
            }
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Dota2参议院 res = new Dota2参议院();
        String senate = "DRRDRDRDRDDRDRDRDRRDRDRDRDDRDRDRDRRDRDRDRDDRDRDRDRRDRDRDRDDRDRDRDRRDRDRDRDDRDRDRDRRDRDRDRDDRDRDRDRRDRDRDRDDRDRDR";
        long t1 = System.currentTimeMillis();
        System.out.println(res.predictPartyVictory(senate));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        long t3 = System.currentTimeMillis();
        System.out.println(res.predictPartyVictoryMy(senate));
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }
}

