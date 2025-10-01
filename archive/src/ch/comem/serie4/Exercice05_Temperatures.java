package ch.comem.serie4;

public class Exercice05_Temperatures {
    
    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
            
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    public static void main(String[] args) {
        double[] tabTemp = new double[12];
        // Remplissage du tableau
        tabTemp[0] = 0.7;
        tabTemp[1] = 2;
        tabTemp[2] = 5.5;
        tabTemp[3] = 9;
        tabTemp[4] = 13;
        tabTemp[5] = 16.3;
        tabTemp[6] = 18.1;
        tabTemp[7] = 17.6;
        tabTemp[8] = 14.8;
        tabTemp[9] = 10.1;
        tabTemp[10] = 5;
        tabTemp[11] = 2.3;
        int index;
        double min;
        
        min = tabTemp[0];
        double max;
        
        max = tabTemp[0];
        double somme;
        
        somme = tabTemp[0];
        for (index = 1; index <= tabTemp.length - 1; index++) {
            somme = somme + tabTemp[index];
            if (tabTemp[index] < min) {
                min = tabTemp[index];
            }
            if (tabTemp[index] > max) {
                max = tabTemp[index];
            }
        }
        double moyenne;
        
        moyenne = somme / tabTemp.length;
        double diff;
        double sommeDiff;
        
        sommeDiff = 0;
        
        // Calcul de la d�viation moyenne
        for (index = 0; index <= tabTemp.length - 1; index++) {
            diff = Math.abs(tabTemp[index] - moyenne);
            sommeDiff = sommeDiff + diff;
        }
        double deviationMoyenne;
        
        deviationMoyenne = sommeDiff / tabTemp.length;
        System.out.println("Moyenne des temp�ratures : " + moyenne);
        System.out.println("Etendue : " + (max - min));
        System.out.println("Déviation moyenne : " + deviationMoyenne);
        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
    }
}