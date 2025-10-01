package ch.comem.serie5_Suite;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import ch.comem.Clavier;

public class ProgrammeProblemeCavalier {
    // Juste pour éviter les problèmes d'affichage d'accents ;-)
    static {
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    private static final char CAVALIER = 'C';
    private static final char LIBRE = ' ';

    public static void main(String[] args) {
        problemeDuCavalier();
    }

    public static void problemeDuCavalier() {
        String deplacements = "";
        boolean stop;
        int[][] echiquier = rendEchiquier();
        final boolean AVEC_NOM_CASES = true;
        afficheEchiquierWaouhVersionProblemeCavalier(echiquier, AVEC_NOM_CASES, "");
        String pos = saisiPosOuS("Où désires-tu placer le cavalier ? ([S-s]=>stop) : ");
        stop = pos.equals("STOP");
        if (!stop) {
            deplacements+=pos+", ";
            placePiece(CAVALIER, echiquier, pos);
            afficheEchiquierWaouhVersionProblemeCavalier(echiquier, true, pos);
            String newPos;
            boolean ok = false;
            int no = 1;
            do {
                do {
                    newPos = saisiPosOuS("Où désires-tu déplacer le cavalier ? ([S,s]=>stop) : ");
                    stop = newPos.equals("S");
                    if (!stop) {
                        ok = deplaceCavalier(pos, newPos, echiquier);
                        if (ok) {
                            deplacements+=newPos+", ";
                            placeNo(-no, pos, echiquier);
                            afficheEchiquierWaouhVersionProblemeCavalier(echiquier, true, newPos);
                            no++;
                            pos = newPos;
                        } else {
                            System.out.println("Cette position n'est pas possible !");
                        }
                    }
                } while (!stop && !ok);
            } while (!stop && no <= 64);
            System.out.println((deplacements.substring(0, deplacements.length()-2)));
        }
    }

    public static boolean deplaceCavalier(String pos, String newPos, int[][] echiquier) {
        boolean aEteDeplace = false;
        if (posOk(pos) && posOk(newPos)) {
            aEteDeplace = deplaceCavalier(rendCol(pos), rendLgn(pos), rendCol(newPos), rendLgn(newPos), echiquier);
        }
        return aEteDeplace;
    }

    public static boolean deplaceCavalier(char col, int lgn, char newCol, int newLgn, int[][] echiquier) {
        boolean aEteDeplace = false;
        if (colOk(col) && lgnOk(lgn) &&
                colOk(newCol) && lgnOk(newLgn)) {
            int iLgn = rendIndexLgn(lgn);
            int iCol = rendIndexCol(col);
            if (echiquier[iLgn][iCol] == CAVALIER) {
                String posOk = rendPosPossiblesCavalier(col, lgn);
                String newPos = ("" + newCol) + newLgn;
                if (posOk.contains(newPos)) {
                    aEteDeplace = placePiece(CAVALIER, echiquier, newCol, newLgn);
                    if (aEteDeplace) {
                        enlevePiece(echiquier, col, lgn);
                    }
                }
            }
        }
        return aEteDeplace;
    }

    public static boolean placePiece(int piece, int[][] echiquier, String pos) {
        boolean aEtePlace = false;
        if (posOk(pos)) {
            aEtePlace = placePiece(piece, echiquier, rendCol(pos), rendLgn(pos));
        }
        return aEtePlace;
    }

    private static boolean placeNo(int no, String pos, int[][] echiquier) {
        boolean aEtePlace = false;
        if (posOk(pos)) {
            int iLgn = rendIndexLgn(rendLgn(pos));
            int iCol = rendIndexCol(rendCol(pos));
            echiquier[iLgn][iCol] = no;
        }
        return aEtePlace;
    }

    public static boolean placePiece(int piece, int[][] echiquier, char col, int lgn) {
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

    public static void enlevePiece(int[][] echiquier, String pos) {
        if (posOk(pos)) {
            enlevePiece(echiquier, rendCol(pos), rendLgn(pos));
        }
    }

    public static void enlevePiece(int[][] echiquier, char col, int lgn) {
        if (lgnOk(lgn) && colOk(col)) {
            int iLgn = rendIndexLgn(lgn);
            int iCol = rendIndexCol(col);
            echiquier[iLgn][iCol] = LIBRE;
        }
    }

    public static int[][] rendEchiquier() {
        return new int[][]{
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

    public static boolean lgnOk(int lgn) {
        return lgn >= 1 && lgn <= 8;
    }

    public static boolean colOk(char col) {
        return col >= 'A' && col <= 'H';
    }

    public static int rendIndexLgn(int lgn) {
        return 8 - lgn;
    }

    public static int rendIndexCol(char col) {
        return col - 'A';
    }

    public static int rendLgn(int iLgn) {
        return 8 - iLgn;
    }

    public static char rendCol(int iCol) {
        char col = 'A';
        col += iCol;
        return col;
    }

    public static String rendPosPossiblesCavalier(String pos) {
        String posPossibles = "";
        if (posOk(pos)) {
            posPossibles = rendPosPossiblesCavalier(rendCol(pos), rendLgn(pos));
        }
        return posPossibles;
    }

    public static String rendPosPossiblesCavalier(char col, int lgn) {
        String posPossibles = "";
        if (colOk(col) && lgnOk(lgn)) {
            int[] dLgn = {-2, -2, -1, +1, +2, +2, -1, +1};
            int[] dCol = {-1, +1, +2, +2, -1, +1, -2, -2};
            int iLgn = rendIndexLgn(lgn);
            int iCol = rendIndexCol(col);
            int newiLgn;
            int newiCol;
            for (int i = 0; i < dLgn.length; i++) {
                newiLgn = iLgn - dLgn[i];
                newiCol = iCol - dCol[i];
                if ((newiLgn >= 0 && newiLgn < 8) &&
                        (newiCol >= 0 && newiCol < 8)) {
                    posPossibles += rendCol(newiCol);
                    posPossibles += rendLgn(newiLgn) + ", ";
                }
            }
            if (posPossibles.length() > 0) {
                posPossibles = posPossibles.substring(0, posPossibles.length() - 2);
            }
        }
        return posPossibles;
    }

    public static void afficheEchiquierWaouhVersionProblemeCavalier(int[][] echiquier, boolean avecNomCases, String posCavalier) {
        final String FOND_NOIR = "\u001B[40m";
        final String FOND_JAUNE = "\u001B[43m";
        final String FOND_GRIS = "\u001B[47m";
        final String FOND_VERT = "\u001B[42m";
        final String RESET = "\u001B[0m";
        final String TXT_NOIR = "\u001B[30m";
        final String TXT_BLANC = "\u001B[37m";

        String posPossibles = rendPosPossiblesCavalier(posCavalier);

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
                String pos = "" + col + lgn;
                if (posPossibles.contains(pos)) {
                    if (echiquier[iLgn][iCol] == LIBRE) {
                        System.out.print(FOND_VERT);
                        System.out.print(TXT_NOIR);
                    } else if (cmpt % 2 == 0) {
                        System.out.print(FOND_NOIR);
                        System.out.print(TXT_BLANC);
                    } else {
                        System.out.print(FOND_GRIS);
                        System.out.print(TXT_NOIR);
                    }
                } else if (echiquier[iLgn][iCol] == CAVALIER) {
                    System.out.print(FOND_JAUNE);
                    System.out.print(TXT_NOIR);
                } else if (cmpt % 2 == 0) {
                    System.out.print(FOND_NOIR);
                    System.out.print(TXT_BLANC);
                } else {
                    System.out.print(FOND_GRIS);
                    System.out.print(TXT_NOIR);
                }
                if (echiquier[iLgn][iCol] < 0)
                    System.out.print(String.format("%02d", -echiquier[iLgn][iCol]));
                else {
                    System.out.print(" ");
                    System.out.print((char)(echiquier[iLgn][iCol]));
                }
                System.out.print(" ");
                cmpt++;
                System.out.print(RESET);
            }
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

    private static void afficheNomsCols() {
        System.out.print("  ");
        for (char col = 'A'; col <= 'H'; col++) {
            System.out.print(" " + col + " ");
        }
        System.out.println();
    }

    public static String saisiPosOuS(String message) {
        boolean ok;
        String position;
        do {
            System.out.print(message);
            position = Clavier.rend_String("").toUpperCase();
            if (!position.equals("S")) {
                ok = posOk(position);
                if (!ok) {
                    System.out.println("Cette position n'existe pas !");
                }
            } else {
                ok = true;
            }
        } while (!ok);
        return position;
    }

    public static boolean posOk(String pos) {
        boolean estOk = false;
        if (pos != null && pos.length() == 2) {
            estOk = colOk(pos.charAt(0)) && lgnOk(pos.charAt(1) - '0');
        }
        return estOk;
    }
}