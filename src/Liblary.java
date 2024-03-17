import java.util.Scanner;
import java.util.ArrayList;

public class Liblary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int action;
        ArrayList <Reader> readers = new ArrayList<>(10);
        ArrayList <Book> libraryBooks = new ArrayList<>(100);
        int rId = 0;

        do {
            System.out.println();
            System.out.println("Вибирите, пожалуйста: ");
            System.out.println("1 -- Добавить читателя");
            System.out.println("2 -- Читатель хочет взять книгу");
            System.out.println("3 -- Читатель хочет вернуть кнгу");
            System.out.println("4 -- статус читателя");
            System.out.println("5 -- напечатать статус всех читателей");
            System.out.println("6 -- выход из программы");
            System.out.println();
            System.out.println("Сделайте выбор: ");

            action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1: {
                    boolean isFull = true;
                    for (int i = 0; i < readers.size(); i++) {
                        if (rId < 10) {
                            System.out.println("Введите данные");
                            System.out.println("Полное имя: ");
                            String fullN = scanner.nextLine();
                            System.out.println("Номер телефона");
                            int rNum = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println(" Факультет - ");
                            String fac = scanner.nextLine();
                            System.out.println("Дата рождения DD-MM-YYYY формат");
                            String dOfB = scanner.nextLine();
                            System.out.println("Номер телефона");
                            String phoneN = scanner.nextLine();
                            readers.add(new Reader(fullN, rNum, fac, dOfB, phoneN));
                            System.out.println("Читатель был успешно добавлен");
                            System.out.println();
                            isFull = false;
                            rId += 1;
                            break;
                        }
                    }

                    if (isFull) {
                        System.out.println("Достигнут максимум читателей");
                    }
                    break;
                }

                case 2: {
                    int b;
                    System.out.println("Введите информацию о книге");
                    System.out.println("Введите название книги"); // add info about book
                    //create book
                    String nameOfBook = scanner.nextLine();
                    System.out.println("Введите имя автора");
                    String authorOfBook = scanner.nextLine();
                    libraryBooks.add(new Book(nameOfBook, authorOfBook));

                    System.out.println("Введите номер читательского билета");
                    int number = scanner.nextInt();
                    boolean found = false;
                    for (Reader r : readers) {
                        if (r.getReaderNumber() == number) {
                            r.takeBook(libraryBooks.get(libraryBooks.size() - 1));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Читателя нет");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Введите название книги");
                    String takenBookName = scanner.nextLine();
                    System.out.println("Введите номер читательского билета");
                    int number = scanner.nextInt();
                    boolean found = false;
                    for (Reader r: readers) {
                        if (r.getReaderNumber() == number) {
                            //reader return a book
                            r.returnBook(takenBookName);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Читателя нет");
                    }
                    break;
                }

                case 4: {
                    System.out.println("Пожалуйста введите номер билета");
                    int number = scanner.nextInt();
                    boolean found = false;
                    for (Reader r: readers) {
                        if (r.getReaderNumber() == number) {
                            r.printStatus();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Читателя нет");
                    }
                    break;
                }

                case 5:{
                    for (Reader r : readers) {
                        if (r != null) {
                            r.printStatus();
                            System.out.println();
                        }
                    }
                    break;
                }

                case 6:{
                    System.out.println("Выход из программы");
                    break;
                }

                default:{
                    System.out.println("Нет такой команды, сделайте еще попытку");
                    System.out.println();
                }
            }
        } while (action != 6);
    }
}