package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Magazine {

    //attributes
    private String title;
    private String publisher;
    private Date publishDate;
    private int issueNumber;
    private int pages;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //constructor
    public Magazine(String title, String publisher, String publishDate, int issueNumber, int pages) throws ParseException {
        this.title = title;
        this.publisher = publisher;
        this.publishDate = setPublishDate(publishDate);
        this.issueNumber = issueNumber;
        this.pages = pages;
    }

    //getAge method
    public int getAge() {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(new Date()));
        int d2 = Integer.parseInt(formatter.format(this.publishDate));
        int age = (d1 - d2) / 10000;
        return age;
    }

    //getter & setter
    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public Date setPublishDate(String publishDate) throws ParseException {
        return sdf.parse(publishDate);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    //toString
    @Override
    public String toString() {
        return String.format("%-20s | %-20s | %-10s | %-10d | %-10d",
                this.title,
                this.publisher,
                sdf.format(publishDate),
                this.issueNumber,
                this.pages
        );
    }
}
