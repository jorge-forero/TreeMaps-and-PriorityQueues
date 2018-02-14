/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
        TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();

        if (allUsersRatings == null || allUsersRatings.isEmpty()) {
            return map;
        }
        PriorityQueue<Integer> moviesRatings;
        String movieName;
        for (UserMovieRating rating : allUsersRatings) {
            if (rating == null) {
                continue;
            }
            if (rating.getMovie() == null || rating.getMovie().isEmpty() || rating.getUserRating() < 0) {
                continue;
            }
            movieName = rating.getMovie().toLowerCase();
            if (map.containsKey(movieName)) {
                moviesRatings = map.get(movieName);
                moviesRatings.add(rating.getUserRating());
                map.put(movieName, moviesRatings);
            } else {
                moviesRatings = new PriorityQueue<>();
                moviesRatings.add(rating.getUserRating());
                map.put(movieName, moviesRatings);
            }
        }
        return map;
    }

}