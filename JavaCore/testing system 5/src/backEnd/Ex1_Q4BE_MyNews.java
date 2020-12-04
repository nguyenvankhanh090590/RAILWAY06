package backEnd;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Q4.Ex1.News;

public class Ex1_Q4BE_MyNews {
	ArrayList<News> ListOfNews = new ArrayList<News>();

	public void insertNews() {
		System.out.println("Tạo mới một tin tức");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập title:");
		String title = sc.nextLine();
		System.out.println("Mời nhập publish date:");
		String publishDate = sc.nextLine();
		System.out.println("Mời nhập tác giả:");
		String author = sc.nextLine();
		System.out.println("Mời nhập nội dung:");
		String content = sc.nextLine();
		News nws = new News(title, publishDate, author, content);

		nws.Calculate();
		ListOfNews.add(nws);
	}

	public void viewListNews() {
		for (News nws : ListOfNews) {
			nws.Display();
		}
	}

	public void rate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập lựa chọn phương pháp tìm kiếm\n1.Title, 2.ID");
		int pp = sc.nextInt();
		sc.nextLine();
		switch (pp) {
		case 1:
			boolean case1 = false;
			do {

				System.out.println("Mời nhập title:");
				String title = sc.nextLine();
				for (News nws : ListOfNews) {
					if (nws.getTitle().equals(title)) {
						nws.Calculate();
						case1 = true;
					}
				}
				if (case1 == false) {
					System.out.println("Title không tồn tại!");
				}
				System.out.println("\n1.Tiếp tục tìm kiếm và đánh giá, 2. Thoát");
				int c1 = sc.nextInt();
				if (c1 == 1) {
					case1 = false;
				} else if (c1 == 2) {
					case1 = true;
				}
			} while (case1 == false);
			break;
		case 2:

			boolean case2 = false;
			do {

				System.out.println("Mời nhập ID:");
				int id = sc.nextInt();
				for (News nws : ListOfNews) {
					if (nws.getId() == id) {
						nws.Calculate();

					} else {
						System.out.println("ID không tồn tại!");

					}
				}
				System.out.println("1.Tiếp tục tìm kiếm và đánh giá, 2. Thoát");
				int c2 = sc.nextInt();
				if (c2 == 1) {
					case2 = false;
				} else {
					case2 = true;
				}
			} while (case2 == false);
			break;
		default:
			System.out.println("Nhập không hợp lệ");
		}
	}
	
	public void menuFunction() {
		boolean f1 = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời nhập chức năng:\n1. Insert news\n2. View list news\n3.Average rate");
			int pp = sc.nextInt();
			switch(pp) {
			case 1:
				insertNews();
				break;
			case 2:
				viewListNews();
				break;
			case 3:
				rate();
				break;
			default:
				System.out.println("Nhập không hợp lệ");
			}
			System.out.println("\n1. Chọn chức năng khác\n2. Thoát");
			int ppp = sc.nextInt();
			if (ppp == 1) {
				f1 = false;
			} else {
				f1 = true;
			}
			
		} while (f1 == false);
		
	}
}
