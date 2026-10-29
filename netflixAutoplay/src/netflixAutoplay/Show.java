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

	public void addEpisode(int episodeNumber, String title, int duration) {
		Episode newEp = new Episode(episodeNumber, title, duration);
		episodeList.addEpisode(newEp);
		// ถ้าเป็นตอนแรกสุด ให้เซ็ตเป็นตอนที่กำลังเล่น
		if (currentEpisode == null) {
			currentEpisode = newEp;
		}
	}

	public void playNextEpisode() {
		// Edge Case: เช็คว่านี่คือตอนสุดท้ายหรือไม่
		if (currentEpisode != null && currentEpisode.next != null) {
			currentEpisode = currentEpisode.next;
			System.out.println("\n>> [System] ข้ามไปเล่นตอนถัดไป: Episode " + currentEpisode.episodeNumber);
		} else {
			System.out.println("\n>> [System] แจ้งเตือน: นี่คือตอนสุดท้ายของซีรีส์แล้ว! (End of List)");
		}
	}

	public void playPreviousEpisode() {
		// Edge Case: เช็คว่านี่คือตอนแรกสุดหรือไม่
		if (currentEpisode != null && currentEpisode.previous != null) {
			currentEpisode = currentEpisode.previous;
			System.out.println("\n>> [System] ย้อนกลับไปตอนก่อนหน้า: Episode " + currentEpisode.episodeNumber);
		} else {
			System.out.println("\n>> [System] แจ้งเตือน: นี่คือตอนแรกสุดของซีรีส์ ไม่สามารถย้อนกลับได้!");
		}
	}

	public void selectEpisode(int epNum) {
		Episode temp = episodeList.head;
		while (temp != null) {
			if (temp.episodeNumber == epNum) {
				currentEpisode = temp;
				System.out.println("\n>> [System] เลือกเล่นตอนที่ " + epNum + " สำเร็จ");
				return;
			}
			temp = temp.next;
		}
		System.out.println("\n>> [System] ข้อผิดพลาด: ไม่พบตอนที่ " + epNum);
	}
}