package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 300);
        Book book2 = new Book("Second", 400);
        Book book3 = new Book("Third", 350);
        Book book4 = new Book("Forth", 500);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book bk : books) {
            System.out.println("Book's name: " + bk.getName() + " number of pages: " + bk.getCount());
        }
        books[2] = book1;
        books[0] = book3;
        for (Book bk : books) {
            System.out.println("Book's name: " + bk.getName() + " number of pages: " + bk.getCount());
        }
        for (Book bk : books) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println("Book's name with Clean code title: " + bk.getName() + " number of pages: " + bk.getCount());
            }
        }
    }
}
