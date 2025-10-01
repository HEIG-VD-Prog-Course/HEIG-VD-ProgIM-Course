package ch.comem.serie5_Suite;

public class ProgrammePlacePion {
    private static final char LIBRE = ' ';
    private static final char PION = 'P';

    public static void main(String[] args) {
        char[][] echiquier = rendEchiquier();
        placePiece(PION,echiquier,"D5");
        afficheEchiquierWaouh(echiquier,true);
    }

    public static char[][] rendEchiquier() {
        return new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
    }

    public static int rendIndexLgn(int lgn) {
        return 8 - lgn;
    }

    public static int rendIndexCol(char col) {
        return col - 'A';
    }

    private static void afficheNomsCols() {
        System.out.print("  ");
        for (char col = 'A'; col <= 'H'; col++) {
            System.out.print(" " + col + " ");
        }
        System.out.println();
    }

    public static void afficheEchiquierWaouh(char[][] echiquier, boolean avecNomCases) {
        final String FOND_NOIR = "\u001B[40m";
        final String FOND_GRIS = "\u001B[47m";
        final String RESET = "\u001B[0m";
        final String TXT_NOIR = "\u001B[30m";
        final String TXT_BLANC = "\u001B[37m";

        int cmpt = 1;
        if (avecNomCases) {
            afficheNomsCols();
        }
        for (int lgn = 8; lgn >= 1; lgn--) {
            if (avecNomCases) {
                System.out.print(lgn + " ");
            }
            for (char col = 'A'; col <= 'H'; col++) {
                int iLgn = rendIndexLgn(lgn);
                int iCol = rendIndexCol(col);
                if (cmpt % 2 == 0) {
                    System.out.print(FOND_NOIR);
                    System.out.print(TXT_BLANC);
                } else {
                    System.out.print(FOND_GRIS);
                    System.out.print(TXT_NOIR);
                }
                System.out.print(" ");
                System.out.print(echiquier[iLgn][iCol]);
                System.out.print(" ");
                cmpt++;
            }
            System.out.print(RESET);
            if (avecNomCases) {
                System.out.print(" ");
                System.out.print(lgn);
            }
            System.out.println();
            cmpt++;
        }
        if (avecNomCases) {
            afficheNomsCols();
        }
    }

    public static boolean placePiece(char piece, char[][] echiquier, char col, int lgn) {
        boolean aEtePlace = false;
        if (lgnOk(lgn) && colOk(col)) {
            int iLgn = rendIndexLgn(lgn);
            int iCol = rendIndexCol(col);
            if (echiquier[iLgn][iCol] == LIBRE) {
                echiquier[iLgn][iCol] = piece;
                aEtePlace = true;
            }
        }
        return aEtePlace;
    }

    public static boolean placePiece(char piece, char[][] echiquier, String pos) {
        boolean aEtePlace = false;
        if (posOk(pos)) {
            aEtePlace = placePiece(piece, echiquier, rendCol(pos), rendLgn(pos));
        }
        return aEtePlace;
    }

    public static boolean posOk(String pos) {
        boolean estOk = false;
        if (pos != null && pos.length() == 2) {
            estOk = colOk(pos.charAt(0)) && lgnOk(pos.charAt(1) - '0');
        }
        return estOk;
    }

    public static boolean lgnOk(int lgn) {
        return lgn >= 1 && lgn <= 8;
    }

    public static boolean colOk(char col) {
        return col >= 'A' && col <= 'H';
    }

    public static char rendCol(String pos) {
        char col = ' ';
        if (posOk(pos)) {
            return pos.charAt(0);
        }
        return col;
    }

    public static int rendLgn(String pos) {
        int lgn = 0;
        if (posOk(pos)) {
            return pos.charAt(1) - '0';
        }
        return lgn;
    }
}
