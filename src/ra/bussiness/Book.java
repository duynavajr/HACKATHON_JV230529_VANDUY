package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;

    // Constructor mặc định
    public Book() {
        // Khởi tạo giá trị mặc định cho các thuộc tính
        this.bookId = 0;
        this.bookName = "";
        this.author = "";
        this.descriptions = "";
        this.importPrice = 0.0;
        this.exportPrice = 0.0;
        this.interest = 0.0f;
    }

    // Getter và Setter cho các thuộc tính
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName != null && !bookName.trim().isEmpty()) {
            this.bookName = bookName;
        } else {
            System.out.println("Tên sách không hợp lệ.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Tên tác giả không hợp lệ.");
        }
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        if (descriptions != null && descriptions.length() >= 10) {
            this.descriptions = descriptions;
        } else {
            System.out.println("Mô tả không hợp lệ. Mô tả phải có ít nhất 10 ký tự.");
        }
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            System.out.println("Giá nhập không hợp lệ.");
        }
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        if (exportPrice > 1.2 * importPrice) {
            this.exportPrice = exportPrice;
        } else {
            System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập.");
        }
    }

    public float getInterest() {
        return interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    // Phương thức để nhập thông tin sách từ bàn phím và tính lợi nhuận
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên sách: ");
        setBookName(scanner.nextLine());

        System.out.print("Nhập tác giả: ");
        setAuthor(scanner.nextLine());

        System.out.print("Nhập mô tả sách (ít nhất 10 ký tự): ");
        setDescriptions(scanner.nextLine());

        System.out.print("Nhập giá nhập: ");
        setImportPrice(scanner.nextDouble());

        System.out.print("Nhập giá xuất: ");
        setExportPrice(scanner.nextDouble());

        // Tính lợi nhuận
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    // Phương thức để hiển thị thông tin sách
    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tác giả: " + author);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái: " + (bookStatus ? "Còn hàng" : "Hết hàng"));
    }
}