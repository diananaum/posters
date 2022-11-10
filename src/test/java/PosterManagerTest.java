import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldNotAddMovie() {
        PosterManager manager = new PosterManager();

        manager.addMovie(null);
        manager.findAll();

        String[] expected = {null};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie 1");
        manager.findAll();

        String[] expected = {"Movie 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovies() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");
        manager.findAll();

        String[] expected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindLast() {
        PosterManager manager = new PosterManager();

        manager.addMovie(null);
        manager.findLast();

        String[] expected = {null};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfOne() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie 1");
        manager.findLast();

        String[] expected = {"Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");

        manager.findLast();

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimit() {
        PosterManager manager = new PosterManager(6);

        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");
        manager.addMovie("Movie 7");
        manager.addMovie("Movie 8");
        manager.addMovie("Movie 9");
        manager.addMovie("Movie 10");

        manager.findLast();

        String[] expected = {"Movie 10", "Movie 9", "Movie 8", "Movie 7", "Movie 6", "Movie 5"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
