public class MATRIX {   
    int zeilen = 2;
    int spalten = 3;
    int mat[][];


    public MATRIX( ) {
        mat = new int[zeilen][spalten];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;
    }

    public void ausgeben(){
        for(int i = 0; i< zeilen; i++){   
            for(int j = 0; j<spalten; j++){
                System.out.print("mat[" + i + "] [" + j + "] = " + mat[i][j]+"    ");
            }
            System.out.println();
        }
    }

    public boolean suchen(int zahl){
        for(int i = 0; i< zeilen; i++){   
            for(int j = 0; j<spalten; j++){
                
                if(mat[i][j]== zahl)
                {
                    System.out.println("mat[" + i + "] [" + j + "] = " + mat[i][j]);
                    return true;
                }                
            }
        }
        System.out.println("Der Eintrag wurde nicht gefunden");
        return false;
    }
}
