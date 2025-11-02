package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        sc.nextLine();

        Library library = new Library(n);

        // Initialize with 2 documents
        library.add(new Novel("3icha 9ndicha", "idk", 320, 12.99));
        library.add(new Magazine("Science after tomorow", "October", 2024));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Document");
            System.out.println("2. Display Documents");
            System.out.println("3. Delete Document");
            System.out.println("4. Display Authors");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice =sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Select document type:");
                    System.out.println("1. Novel\n2. Textbook\n3. Magazine\n4. Dictionary");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    Document doc = null;
                    switch (type) {
                        case 1:
                            System.out.print("Author: ");
                            String author1 = sc.nextLine();
                            System.out.print("Pages: ");
                            int pages1 = sc.nextInt();
                            System.out.print("Price: ");
                            double price = sc.nextDouble();
                            doc = new Novel(title, author1, pages1, price);
                            break;
                        case 2:
                            System.out.print("Author: ");
                            String author2 = sc.nextLine();
                            System.out.print("Pages: ");
                            int pages2 = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Level: ");
                            String level = sc.nextLine();
                            doc = new Textbook(title, author2, pages2, level);
                            break;
                        case 3:
                            System.out.print("Month: ");
                            String month = sc.nextLine();
                            System.out.print("Year: ");
                            int year = sc.nextInt();
                            doc = new Magazine(title, month, year);
                            break;
                        case 4:
                            System.out.print("Language: ");
                            String lang = sc.nextLine();
                            doc = new Dictionary(title, lang);
                            break;
                    }

                    if(doc != null && library.add(doc))
                        System.out.println("Document added successfully!");
                    break;

                case 2:
                    library.displayDocuments();
                    break;

                case 3:
                    System.out.print("Enter record number to delete: ");
                    int num =sc.nextInt();
                    Document d = library.document(num);
                    if (d != null && library.delete(d))
                        System.out.println("Document deleted!");
                    else
                        System.out.println("Not found!");
                    break;

                case 4:
                    library.displayAuthors();
                    break;
            }
        } while(choice != 5);

        sc.close();
    }
}
