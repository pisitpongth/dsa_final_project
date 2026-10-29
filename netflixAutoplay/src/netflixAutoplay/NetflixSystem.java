package netflixAutoplay;

import java.util.ArrayList;
import java.util.Scanner;

public class NetflixSystem {

	public static void main(String[] args) {
		// 1. สร้าง Data Structure (ArrayList) เพื่อเก็บซีรีส์ทั้งหมดในระบบ
		ArrayList<Show> allShows = new ArrayList<>();

		// ==========================================
		// Series 1 - Stranger Things (8 ตอน)
		// ==========================================
		Show strangerThings = new Show("Stranger Things");
		strangerThings.addEpisode(1, "The Vanishing of Will Byers", 49);
		strangerThings.addEpisode(2, "The Weirdo on Maple Street", 52);
		strangerThings.addEpisode(3, "Holly, Jolly", 51);
		strangerThings.addEpisode(4, "The Body", 50);
		strangerThings.addEpisode(5, "The Flea and the Acrobat", 53);
		strangerThings.addEpisode(6, "The Monster", 46);
		strangerThings.addEpisode(7, "The Bathtub", 42);
		strangerThings.addEpisode(8, "The Upside Down", 54);
		allShows.add(strangerThings);

		// ==========================================
		// Series 2 - Invincible (8 ตอน)
		// ==========================================
		Show invincible = new Show("Invincible");
		invincible.addEpisode(1, "It's About Time", 43);
		invincible.addEpisode(2, "Here Goes Nothing", 44);
		invincible.addEpisode(3, "Who You Calling Ugly?", 43);
		invincible.addEpisode(4, "Neil Armstrong, Eat Your Heart Out", 45);
		invincible.addEpisode(5, "That Actually Hurt", 42);
		invincible.addEpisode(6, "You Look Kinda Dead", 44);
		invincible.addEpisode(7, "We Need to Talk", 46);
		invincible.addEpisode(8, "Where I Really Come From", 48);
		allShows.add(invincible);

		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;

		// กำหนดให้ตอนเริ่มระบบ เล่นซีรีส์เรื่องแรก (Stranger Things)
		Show currentShow = allShows.get(0);

		while (isRunning) {
			displayConsole(currentShow);
			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				currentShow.playNextEpisode();
				break;
			case "2":
				currentShow.playPreviousEpisode();
				break;
			case "3":
				System.out.print("Enter Episode Number (1-8): ");
				try {
					int epNum = Integer.parseInt(scanner.nextLine());
					currentShow.selectEpisode(epNum);
				} catch (NumberFormatException e) {
					System.out.println("\n>> [System] กรุณาป้อนตัวเลขให้ถูกต้อง");
				}
				break;
			case "4":
				// ฟังก์ชันสลับซีรีส์
				System.out.println("\n--- Select a Series ---");
				for (int i = 0; i < allShows.size(); i++) {
					System.out.println((i + 1) + ". " + allShows.get(i).showTitle + " ("
							+ getEpisodeCount(allShows.get(i)) + " Episodes)");
				}
				System.out.print("Choose series to watch: ");
				try {
					int showIndex = Integer.parseInt(scanner.nextLine()) - 1;
					if (showIndex >= 0 && showIndex < allShows.size()) {
						currentShow = allShows.get(showIndex);
						System.out.println("\n>> [System] Changed to: " + currentShow.showTitle);
					} else {
						System.out.println("\n>> [System] ไม่พบซีรีส์ที่เลือก");
					}
				} catch (NumberFormatException e) {
					System.out.println("\n>> [System] กรุณาป้อนตัวเลขให้ถูกต้อง");
				}
				break;
			case "5":
				autoPlayTrigger(currentShow);
				break;
			case "6":
				System.out.println("\n>> [System] Exiting Netflix... Goodbye!");
				isRunning = false;
				break;
			default:
				System.out.println("\n>> [System] Invalid choice! Please try again.");
			}
		}
		scanner.close();
	}

	// Helper Method สำหรับนับจำนวนตอน (Optional)
	private static int getEpisodeCount(Show show) {
		int count = 0;
		Episode temp = show.episodeList.head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static void displayConsole(Show show) {
		if (show.currentEpisode == null)
			return;

		System.out.println("\n========================================");
		System.out.println("       NETFLIX - CONSOLE EDITION");
		System.out.println("========================================");
		System.out.println("[Now Playing] " + show.showTitle);
		System.out.println("> Episode " + show.currentEpisode.episodeNumber + ": \"" + show.currentEpisode.title
				+ "\" (Duration: " + show.currentEpisode.duration + " mins)");
		System.out.println("----------------------------------------");
		System.out.println("[Status]: Playing... [ 00:45 / " + show.currentEpisode.duration + ":00 ]");
		System.out.println("\nMenu:");
		System.out.println("1. Play Next Episode (>> Next)");
		System.out.println("2. Play Previous Episode (<< Prev)");
		System.out.println("3. Select Specific Episode");
		System.out.println("4. Change Series (Switch Show)");
		System.out.println("5. [Simulate] Finish Episode (Trigger Auto-play)");
		System.out.println("6. Exit");
		System.out.println("----------------------------------------");
		System.out.print("Enter your choice: ");
	}

	public static void autoPlayTrigger(Show show) {
		if (show.currentEpisode != null && show.currentEpisode.next != null) {
			System.out.println("\n[Status]: Episode " + show.currentEpisode.episodeNumber + " Finished.");

			for (int i = 5; i > 0; i--) {
				System.out.println("Auto-playing next episode in " + i + "s...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			show.playNextEpisode();
		} else {
			System.out.println("\n[Status]: Episode Finished.");
			System.out.println(">> [System] แจ้งเตือน: นี่คือตอนสุดท้ายของซีรีส์แล้ว!");
		}
	}
}