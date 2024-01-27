package Entities;

public class Book {
    private static int id;
    private int Id;
    private String Name;
    private String Author;
    private String Language;
    private int Price;
    private int Count;

    //No id given
    public Book( String Name, String Author, String Language, int Price, int Count)
    {
        id++;
        Id=id;
        this.Name=Name;
        this.Author=Author;
        this.Language=Language;
        this.Price=Price;
        this.Count=Count;
    }



    //id given by user
    public Book(int id, String Name, String Author, String Language, int Price, int Count)

    {
     this.Id=id;
     this.Name=Name;
     this.Author=Author;
     this.Language=Language;
     this.Price=Price;
     this.Count=Count;
    }

    public int getId()
    {
        return this.Id;
    }
    public void increaseCount(int additionalCount) {
        this.Count += additionalCount;
    }

    public String getName() {
        return Name;
    }

    public int getCount() {
        return Count;
    }
    public void FullInfo()
    {
        System.out.println("Id: "+Id);
        System.out.println("Name: "+Name);
        System.out.println("Author: "+Author);
        System.out.println("Language: "+Language);
        System.out.println("Price: "+Price);
        System.out.println("Count: "+Count);
        System.out.println("\n");
    }

    public String getAuthor() {
        return this.Author;
    }

    public void setCount(int newCount) {
        this.Count=newCount;
    }

    public void setPrice(int newPrice) {
        this.Price=newPrice;
    }
}
