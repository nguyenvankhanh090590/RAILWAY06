package entity.Q4.Ex1;

import java.util.Scanner;

import backEnd.INews;

public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float avgRate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAvgRate() {
		return avgRate;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", publishDate=" + publishDate + ", author=" + author + ", content=" + content
				+ ", avgRate=" + avgRate + "]";
	}

	@Override
	public void Display() {
		System.out.println("News [title=" + this.title + ", publishDate=" + this.publishDate + ", author=" + this.author
				+ ", content=" + this.content + ", avgRate=" + this.avgRate + "]");
	}

	@Override
	public void Calculate() {
		int[] rates = new int[3];
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời nhập điểm đánh giá thứ nhất:");
		rates[0] = sc.nextInt();
		System.out.print("Mời nhập điểm đánh giá thứ hai:");
		rates[1] = sc.nextInt();
		System.out.print("Mời nhập điểm đánh giá thứ ba:");
		rates[2] = sc.nextInt();
		int n = 0;
		
		this.avgRate = (float)(rates[0]+rates[1]+rates[2])/3;
		
		
	}

	public News(String title, String publishDate, String author, String content) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
	}

}
