public class STATION implements DATENELEMENT
{
    private String name;

    public STATION(String name)
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
