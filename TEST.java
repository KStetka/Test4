
public class TEST
{
    private GRAPH g;

    public TEST()
    {
        g = new GRAPH(9);
    }

    public void graphErzeugen()
    {
        g.knotenEinfuegen("Altenmarkt");
        g.knotenEinfuegen("Passau");
        g.knotenEinfuegen("Schalding");
        g.knotenEinfuegen("Patriching");
        g.knotenEinfuegen("Salzweg");
        g.knotenEinfuegen("Freinberg");
        g.knotenEinfuegen("Schardenberg");
        g.knotenEinfuegen("Pfennigbach");
        g.knotenEinfuegen("Fuerstenzell");
        
        g.kanteEinfuegen("Salzweg", "Passau", 9);
        g.kanteEinfuegen("Patriching", "Passau", 7);
        g.kanteEinfuegen("Schalding", "Passau", 10);
        g.kanteEinfuegen("Freinberg", "Passau", 5);
        g.kanteEinfuegen("Schardenberg", "Passau", 8);
        g.kanteEinfuegen("Pfennigbach", "Passau", 8);
        g.kanteEinfuegen("Altenmarkt", "Passau", 11);
        g.kanteEinfuegen("Altenmarkt", "Fuerstenzell", 5);
        g.kanteEinfuegen("Fuerstenzell", "Pfennigbach", 5);     

    }

    public void tiefenSucheDurchfuehren()
    {
        g.tiefenSuche("Passau");
    }

    public void breitenSucheDurchfuehren()
    {
        g.breitenSuche("Passau");
    }
    
}
