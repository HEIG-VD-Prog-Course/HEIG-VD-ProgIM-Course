package ch.comem.serie5_Suite;

import java.util.Random;

public class ProgrammeBoggle {
    public static void main(String[] args) {
        String[][] boggle = rendBoggle();
        secoue(boggle);
    }

    public static String[][] rendBoggle() {
        String[][] boggle = {
                {"ETUKNO","EVGTIN","DECAMP","IELRUW"},
                {"EHIFSE","RECALS","ENTDOS","OFXRIA"},
                {"NAVEDZ","EIOATA","GLENYU","BMAQJO"},
                {"TLIBRA","SPULTE","AIMSOR","ENHRIS"}
        };
        return boggle;
    }

    private static char[][] secoue(String[][] boggle) {
        boolean voirDes = false; // pour voir les dés, mettre à : true
        Random rnd = new Random();
        int nbDes = boggle.length * boggle[0].length;
        for (int i = nbDes - 1; i > 0; i--) {
            int index = rnd.nextInt(i);
            int iLgn = i / boggle[0].length;
            int iCol = i - iLgn * boggle[0].length;
            int iLgnRnd = index / boggle[0].length;
            int iColRnd = index - iLgnRnd * boggle[0].length;
            String tmp = boggle[iLgn][iCol];
            boggle[iLgn][iCol] = boggle[iLgnRnd][iColRnd];
            boggle[iLgnRnd][iColRnd] = tmp;
        }
        char[][] facesVisibles = new char[boggle.length][boggle[0].length];
        String infoDes = "";
        for (int iLgn=0; iLgn<boggle.length; iLgn++) {
            for (int iCol=0; iCol<boggle[0].length; iCol++) {
                String de=boggle[iLgn][iCol];
                infoDes += de + " ";
                char faceVisibleDuDe = de.charAt(rnd.nextInt(de.length()));
                System.out.print(faceVisibleDuDe);
                System.out.print("  ");
                facesVisibles[iLgn][iCol] = faceVisibleDuDe;
            }
            infoDes+="\n";
            System.out.println();
        }
        if (voirDes) System.out.println(infoDes);
        return facesVisibles;
    }
}