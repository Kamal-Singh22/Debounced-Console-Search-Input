import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DebouncedSearch {
    private static Timer debounceTimer;
    private static final int DEBOUNCE_DELAY = 500; // milliseconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder queryBuilder = new StringBuilder();

        System.out.println("Start typing your search query (Press ENTER to finish):");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }

            queryBuilder.append(input);

            // Cancel previous debounce if still waiting
            if (debounceTimer != null) {
                debounceTimer.cancel();
            }

            // Start a new debounce timer
            debounceTimer = new Timer();
            debounceTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    performSearch(queryBuilder.toString());
                }
            }, DEBOUNCE_DELAY);
        }

        scanner.close();
    }

    private static void performSearch(String query) {
        System.out.println("[Debounced] Searching for: " + query);
    }
}
