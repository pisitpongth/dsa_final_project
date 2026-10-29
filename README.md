# 🎬 Netflix Console Edition: Next Episode & Auto-Play System

A console-based Netflix simulation project built to demonstrate the practical application of **Data Structures and Algorithms (DSA)** concepts, specifically focusing on **Doubly Linked Lists** for episode navigation and **Queues** for watch history management.

---

## 🏗️ 1. Suitable Data Structures

* **Doubly Linked List:** Ideal for representing a TV series structure where each node represents an "Episode."
  * `next` points to the following episode.
  * `prev` points to the previous episode.
  * Enables $O(1)$ constant time complexity for "Next" and "Previous" navigation.
* **Queue:** Utilized for **Watch History / Continue Watching**, managing the order of shows currently being watched by the user.

---

## 🧱 2. Object-Oriented Design (OOD)

The system is structured into 3 core classes:

* **`Episode` Class:** Stores individual episode details.
  * `episodeNumber` (int)
  * `title` (String)
  * `duration` (int, e.g., 45 minutes)
  * `next` (Pointer to the next episode)
  * `prev` (Pointer to the previous episode)
* **`Show` Class:** Manages details for a specific series.
  * `showTitle` (String)
  * `head` (Pointer to the first episode of the series)
  * `currentEpisode` (Pointer to the episode currently playing)
* **`NetflixSystem` Class:** Handles core logic, menu operations, and console UI rendering.

---

## ⚙️ 3. Core Operations

* `playShow(String showName)`: Selects a series and starts playback from the last watched episode or defaults to Episode 1.
* `playNextEpisode()`: Immediately skips to the next episode (`currentEpisode = currentEpisode.next`).
* `playPreviousEpisode()`: Reverts to the previous episode (`currentEpisode = currentEpisode.prev`).
* `autoPlayTrigger()`: Simulates the end of an episode, initiates a 5-second countdown, and automatically calls `playNextEpisode()`.
* `displayConsole()`: Renders the mock User Interface (UI) in the console.

---

## 🖥️ 4. Console UI Design

```text
========================================
       NETFLIX - CONSOLE EDITION
========================================
[Now Playing] Stranger Things: Season 1
> Episode 2: "The Weirdo" (Duration: 52 mins)
----------------------------------------
[Status]: Playing... [ 00:45 / 52:00 ]

--- Auto-play Next Episode in 5s ---

Menu:
1. Play Next Episode (>> Next)
2. Play Previous Episode (<< Prev)
3. Select Specific Episode
4. Exit
----------------------------------------
Enter your choice:
