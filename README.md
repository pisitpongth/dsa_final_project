# 🎬 Netflix Console Edition: Next Episode & Auto-Play System

A console-based Netflix simulation project built to demonstrate the practical application of **Data Structures and Algorithms (DSA)** concepts, specifically focusing on **Doubly Linked Lists** for episode navigation and **ArrayLists** for managing the available shows.

---

## 🏗️ 1. Suitable Data Structures

* **Doubly Linked List:** Used to represent the episodes in a TV series, where each node represents an "Episode."
  * `next` points to the following episode.
  * `previous` points to the previous episode.
  * Enables $O(1)$ constant time complexity for moving to the next or previous episode when the current episode is known.
* **ArrayList:** Used to store the available shows so the user can switch between series.

---

## 🧱 2. Object-Oriented Design (OOD)

The system is structured into 4 core classes:

* **`Episode` Class:** Stores individual episode details.
  * `seasonNumber` (int)
  * `episodeNumber` (int)
  * `title` (String)
  * `duration` (int, e.g., 45 minutes)
  * `next` (Pointer to the next episode)
  * `previous` (Pointer to the previous episode)
* **`DoublyLinkedList` Class:** Stores the episodes for a show.
  * `head` (Pointer to the first episode)
  * `tail` (Pointer to the last episode)
* **`Show` Class:** Manages details and playback for a specific series.
  * `showTitle` (String)
  * `episodeList` (Doubly linked list of episodes)
  * `currentEpisode` (Pointer to the episode currently selected)
* **`NetflixSystem` Class:** Stores the available shows, handles menu operations, and renders the console UI.

---

## ⚙️ 3. Core Operations

* `addEpisode(int seasonNumber, int episodeNumber, String title, int duration)`: Adds an episode to a show's doubly linked list. The first added episode becomes the current episode.
* `playNextEpisode()`: Moves to the next episode (`currentEpisode = currentEpisode.next`) when one is available.
* `playPreviousEpisode()`: Moves to the previous episode (`currentEpisode = currentEpisode.previous`) when one is available.
* `selectEpisode(int seasonNum, int epNum)`: Searches for an episode by season and episode number, then selects it.
* `autoPlayTrigger(Show show)`: Simulates finishing the current episode, starts a 5-second countdown, and then plays the next episode if one is available. This is triggered by choosing the corresponding menu option.
* `displayConsole(Show show)`: Renders the mock User Interface (UI) in the console. The playback status time shown is illustrative and does not track real playback.

---

## 🖥️ 4. Console UI Design

```text
========================================
       NETFLIX - CONSOLE EDITION
========================================
[Now Playing] Stranger Things
> Season 1 Episode 1: "The Vanishing of Will Byers" (Duration: 49 mins)
----------------------------------------
[Status]: Playing... [ 00:45 / 49:00 ]

Menu:
1. Play Next Episode (>> Next)
2. Play Previous Episode (<< Prev)
3. Select Specific Episode
4. Change Series (Switch Show)
5. [Simulate] Finish Episode (Trigger Auto-play)
6. Exit
----------------------------------------
Enter your choice:
```
