import java.util.ArrayList;   // fuer Breitensuche

public class GRAPH
{
    private int anzahlKnoten;
    private KNOTEN[] knotenliste;
    private int [][] matrix;
    private int maxAnzahl;

    // fuer Breiten- und Tiefensuche
    private boolean [] besucht;

    public GRAPH(int m)
    {
        anzahlKnoten=0;
        knotenliste = new KNOTEN[m];
        matrix = new int [m][m];
        maxAnzahl = m;
        besucht = new boolean[m];

       for(int i=0; i<m; i++)
       {
            for(int j=0; j<m; j++)
            {
                matrix[i][j]=-1;
            }
       }

    }

    public void knotenEinfuegen(String name)
    {
        if(knotenSchonVorhanden(name)==false)
        {
            if(anzahlKnoten<maxAnzahl)
            {
                STATION s = new STATION(name);
                knotenliste[anzahlKnoten]= new KNOTEN(s,anzahlKnoten);
                matrix[anzahlKnoten][anzahlKnoten]=0;
                anzahlKnoten++;
            }
            else
            {
                System.out.println("Der Graph kann keine Knoten mehr aufnehmen!");
            }
        }
        else
        {
            System.out.println("Der Graph enthält bereits diesen Knoten!");
        }

    }

    public void kanteEinfuegen(String von, String nach, int dist)
    {
        KNOTEN vonK = nameZuKnoten(von);
        KNOTEN nachK = nameZuKnoten(nach);
        
        if((vonK !=null)&&(nachK != null))
        {
            int vonNr = vonK.nummerGeben();
            int nachNr = nachK.nummerGeben();
            matrix[vonNr][nachNr]=dist;
            matrix[nachNr][vonNr]=dist;
        }
        else
        {
            System.out.println("Einer oder beide Knoten existieren nicht!");
        }

    }

    private KNOTEN nameZuKnoten(String name)
    {
        KNOTEN k = null;
        
        for(int i=0; i<anzahlKnoten; i++)
        {
            if(name == ((STATION)knotenliste[i].datenGeben()).nameGeben())
            {
                k = knotenliste[i];
            }
        }
        return k;
    }

    private boolean knotenSchonVorhanden(String name)
    {
        boolean test = false;
        
        for(int i=0; i<anzahlKnoten; i++)
        {
            if(name == ((STATION)knotenliste[i].datenGeben()).nameGeben())
            {
                test = true;
            }
        }
        return test;
    }
    
    public void tiefenSuche(String startKnoten)
    {
        if(knotenSchonVorhanden(startKnoten))
        {
            int startNummer = nameZuKnoten(startKnoten).nummerGeben();
            for(int i = 0; i< anzahlKnoten; i++)
            {
                besucht[i]=false;
            }

            besuchenT(startNummer);

        }else
        {
            System.out.println("Der gewuenschte Startknoten existiert nicht!!!");
        }

    }

    private void besuchenT(int knotenNr)
    {
        besucht[knotenNr] = true;

        knotenliste[knotenNr].datenGeben().infoGeben();

        for(int i = 0; i<anzahlKnoten; i++)
        {
            if((matrix[knotenNr][i] > 0)&&(besucht[i] == false))
            {
                besuchenT(i);
            }
        }
    }

    public void breitenSuche(String startKnoten)
    {
        if(knotenSchonVorhanden(startKnoten))
        {
            int startnummer = nameZuKnoten(startKnoten).nummerGeben();

            for(int i = 0; i<maxAnzahl; i++)
            {
                besucht[i]=false;
            }
            
            besuchenB(startnummer);
        }
        else
        {
            System.out.println("Der gewuenschte Startknoten existiert nicht!!!");
        }

    }

    private void besuchenB(int knotenNr)
    {
        besucht[knotenNr] = true;
        knotenliste[knotenNr].datenGeben().infoGeben();

        ArrayList<KNOTEN> liste;
        liste = new ArrayList<KNOTEN>();

        liste.add(knotenliste[knotenNr]);

        while(!liste.isEmpty())
        {            
            KNOTEN k = liste.remove(0);
            for(int i = 0; i < anzahlKnoten; i++)
            {
                if(matrix[k.nummerGeben()][i] > 0 && besucht[i]==false)
                {   
                    liste.add(knotenliste[i]);
                    knotenliste[i].datenGeben().infoGeben();
                    besucht[i]=true;
                }
            }
        }
    }
}