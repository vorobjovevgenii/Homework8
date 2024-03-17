public class Book {
    String name;
    String authorName;
    String text;

    public Book (String name, String authorName){
        this.name = name;
        this.authorName = authorName;
    }


    @Override
    public String toString (){
        return "Book {" + "name = " + name + " / " +
                "authorName = " + authorName + "}";

    }

}