# Debounced-Console-Search-Input
Simulate a search system where a user types input character by character, and the program only performs the "search" (i.e., displays the input) after the user pauses for 500 milliseconds.
How it works:
The user enters text one line at a time.

Each time they enter a line, the debounce timer is reset.

If 500 ms pass without new input, the performSearch() method is called.

This simulates the "debounced" effect like in a web application.....
