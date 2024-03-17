import java.util.ArrayList;

public class Reader {
    private String fullName;
    private int readerNumber;
    private String faculty;
    private String birthday;
    private String phone;
    ArrayList<Book> takenBooks = new ArrayList<>(10);

    public Reader() {
    }

    public Reader(String fullName, int readerNumber, String faculty, String birthday, String phone) {
        this.fullName = fullName;
        this.readerNumber = readerNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = phone;
    }

    public void printStatus(){
        System.out.println("Читатель - " + getFullName()
                + " взял следующее количество книг: " + takenBooks.size()
        );
        for (Book b : takenBooks) {
            System.out.println(b.name);
        }
    }

    public void takeBook(Book b){
        if(takenBooks.size()<10){
            takenBooks.add(b);
            System.out.println("Читатель - " + getFullName() + " Взял : " + b.name);
            System.out.println();
        }else{
            System.out.println("Достигнут лимит 10 книг" +
                    "верните некоторые книги");
        }
    }

    int searchCounter = 0;
    Book bookForDelete;

    public void returnBook(String name){
        for(Book b:takenBooks){
            if(name.equals(b.name)){
                searchCounter++;
                bookForDelete=b;
            }else {
                System.out.println(getFullName() + " не вернул книгу - "
                        + name);
                System.out.println();
                break;
            }
        }
        if(searchCounter==1){
            takenBooks.remove(bookForDelete);
            System.out.println(getFullName() + " вернул книгу: "
                    + name);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public int getReaderNumber() {
        return readerNumber;
    }


    public String getFaculty() {
        return faculty;
    }


    public String getBirthday() {
        return birthday;
    }


    public String getPhone() {
        return phone;
    }


}