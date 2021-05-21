public class STADT implements DATENELEMENT
{
    private String name;
    private int einwohnerzahl;

    public STADT(String name)
    {
        this.name = name;
    }

    public String nameGeben()
    {
        return name;
    }

    public void infoGeben()
    {
        System.out.println("Name: "+name);
    }

}
