package netflixAutoplay;

public class Show {
	String showTitle;
	DoublyLinkedList episodeList;
	Episode currentEpisode;

	public Show(String showTitle) {
		this.showTitle = showTitle;
		this.episodeList = new DoublyLinkedList();
		this.currentEpisode = null;
	}

	// เพิ่มรับค่า seasonNumber
	public void addEpisode(int seasonNumber, int episodeNumber, String title, int duration) {
		Episode newEp = new Episode(seasonNumber, episodeNumber, title, duration);
		episodeList.addEpisode(newEp);
		if (currentEpisode == null) {
			currentEpisode = newEp;
		}
	}

	public void playNextEpisode() {
		if (currentEpisode != null && currentEpisode.next != null) {
			currentEpisode = currentEpisode.next;
			System.out.println("\n>> [System] ข้ามไปเล่นตอนถัดไป: S" + currentEpisode.seasonNumber + " EP"
					+ currentEpisode.episodeNumber);
		} else {
			System.out.println("\n>> [System] แจ้งเตือน: นี่คือตอนสุดท้ายของซีรีส์เรื่องนี้แล้ว! (End of List)");
		}
	}

	public void playPreviousEpisode() {
		if (currentEpisode != null && currentEpisode.previous != null) {
			currentEpisode = currentEpisode.previous;
			System.out.println("\n>> [System] ย้อนกลับไปตอนก่อนหน้า: S" + currentEpisode.seasonNumber + " EP"
					+ currentEpisode.episodeNumber);
		} else {
			System.out.println("\n>> [System] แจ้งเตือน: นี่คือตอนแรกสุดของซีรีส์ ไม่สามารถย้อนกลับได้!");
		}
	}

	// ค้นหาโดยระบุทั้ง Season และ Episode
	public void selectEpisode(int seasonNum, int epNum) {
		Episode temp = episodeList.head;
		while (temp != null) {
			if (temp.seasonNumber == seasonNum && temp.episodeNumber == epNum) {
				currentEpisode = temp;
				System.out.println("\n>> [System] เลือกเล่น S" + seasonNum + " EP" + epNum + " สำเร็จ");
				return;
			}
			temp = temp.next;
		}
		System.out.println("\n>> [System] ข้อผิดพลาด: ไม่พบ S" + seasonNum + " EP" + epNum + " ในระบบ");
	}
}