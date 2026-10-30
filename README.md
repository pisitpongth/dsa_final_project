# Netflix Console Edition

A simple Java program that looks like Netflix in the console. It lets users watch a list of shows, move between episodes, and choose an episode. The project shows how data structures can be used in a program.

## Data Structures

### Doubly Linked List

Each show has a doubly linked list of episodes. Each episode has a link to the next episode and a link to the previous episode. This makes it easy to move forward or back when the current episode is known.

### Custom ArrayList

The program uses its own `ArrayList` class to store the shows. It starts with space for 10 shows. When it is full, it makes a larger array.

## Classes

The project has five classes:

* **`Episode`** stores the season number, episode number, title, duration in minutes, and links to the next and previous episodes.
* **`DoublyLinkedList`** stores episodes. It has a `head` for the first episode and a `tail` for the last episode.
* **`Show`** stores a show title, its episode list, and the current episode. It can add, select, and move between episodes.
* **`ArrayList`** stores shows in an array. It can add a show, return a show by its position, and report the number of shows.
* **`NetflixSystem`** starts the program, shows the menu, and handles the user's choices.

## Main Features

* **Add episodes:** Episodes are added to the end of a show's list. The first episode added becomes the current episode.
* **Play next or previous:** The program moves to the next or previous episode when one is available. At the start or end of the list, it shows a message.
* **Select an episode:** The user can enter a season number and an episode number. The program searches for that episode.
* **Change shows:** The user can choose a show from the list.
* **Auto-play demo:** The user can choose the finish episode option. The program shows a 5-second countdown, then moves to the next episode. If there is no next episode, it shows a message.
* **Console display:** The program shows the current show, episode, duration, and menu. The time shown in the status line is an example only. It does not measure real playback time.

## How to Use

Run `NetflixSystem`. Choose a menu number and follow the prompts.

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
