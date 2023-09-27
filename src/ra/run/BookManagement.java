package ra.run;

import java.util.Scanner;
import ra.bussiness.Book;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[100]; // Maximum of 100 books
        int bookCount= 0;

        while (true) {
            System.out.println("****************MENU***************");
            System.out.println("Chọn một chức năng (1-7): ");
            System.out.println("1. Nhập số sách cần them moi");
            System.out.println("2. Hiển thị thông tin tất cả sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("==========================================");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (bookCount < 100) {
                        System.out.print("Nhập số lượng sách mới: ");
                        int numBooks = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < numBooks; i++) {
                            System.out.println("Nhập thông tin cho sách thứ " + (i + 1) + ":");
                            books[bookCount] = new Book();
                            books[bookCount].inputData();
                            bookCount++;
                        }
                    } else {
                        System.out.println("Thư viện đã đạt giới hạn tối đa.");
                    }
                    break;

                case 2:
                    System.out.println("Thông tin tất cả sách trong thư viện:");
                    for (int i = 0; i < bookCount; i++) {
                        books[i].displayData();
                        System.out.println();
                    }
                    break;

                case 3:

                    for (int i = 0; i < bookCount - 1; i++) {
                        for (int j = 0; j < bookCount - i - 1; j++) {
                            if (books[j].getInterest() > books[j + 1].getInterest()) {
                                Book temp = books[j];
                                books[j] = books[j + 1];
                                books[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần.");
                    break;

                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int bookIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    boolean bookFound = false;

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookId() == bookIdToDelete) {
                            for (int j = i; j < bookCount - 1; j++) {
                                books[j] = books[j + 1];
                            }
                            bookCount--;
                            bookFound = true;
                            System.out.println("Sách có mã " + bookIdToDelete + " đã bị xóa.");
                            break;
                        }
                    }

                    if (!bookFound) {
                        System.out.println("Không tìm thấy sách có mã " + bookIdToDelete);
                    }
                    break;

                case 5:
                    System.out.print("Nhập chuỗi tìm kiếm: ");
                    String searchQuery = scanner.nextLine().toLowerCase();

                    System.out.println("Kết quả tìm kiếm:");
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookName().toLowerCase().contains(searchQuery)
                                || books[i].getDescriptions().toLowerCase().contains(searchQuery)) {
                            books[i].displayData();
                            System.out.println();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Nhập mã sách cần thay đổi thông tin: ");
                    int bookIdToEdit = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    bookFound = false;

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookId() == bookIdToEdit) {
                            books[i].inputData();
                            bookFound = true;
                            System.out.println("Thông tin sách đã được cập nhật.");
                            break;
                        }
                    }

                    if (!bookFound) {
                        System.out.println("Không tìm thấy sách có mã " + bookIdToEdit);
                    }
                    break;

                case 7:
                    System.out.println("Thoát khỏi chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}
