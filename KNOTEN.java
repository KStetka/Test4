public class KNOTEN
{
    private DATENELEMENT daten;
    private int nummer;

    public KNOTEN(DATENELEMENT daten,int nummer)
    {
        this.daten = daten;
        this.nummer = nummer;
    }

    public DATENELEMENT datenGeben()
    {
        return daten;
    }

    public int nummerGeben()
    {
        return nummer;
    }
}
