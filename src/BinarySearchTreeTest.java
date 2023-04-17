import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
    public class BinarySearchTreeTest {
        @Test
        public void testInsertAndToString() {
            BinarySearchTree<Album> tree = new BinarySearchTree<>();
            List<String> artists = Arrays.asList("Artist 1", "Artist 2");
            tree.insert(new Album(1, artists, "Title 1", 10));
            tree.insert(new Album(2, artists, "Title 2", 5));
            tree.insert(new Album(3, artists, "Title 3", 15));

            assertEquals("ID: 1 NUM_SONGS: 10 -- [Artist 1, Artist 2], ID: 2 NUM_SONGS: 5 -- [Artist 1, Artist 2], N, N, ID: 3 NUM_SONGS: 15 -- [Artist 1, Artist 2], N, N", tree.toString());
        }

        @Test
        public void testDelete() {
            BinarySearchTree<Album> tree = new BinarySearchTree<>();
            List<String> artists = Arrays.asList("Artist 1", "Artist 2");
            tree.insert(new Album(1, artists, "Title 1", 10));
            tree.insert(new Album(2, artists, "Title 2", 5));
            tree.insert(new Album(3, artists, "Title 3", 15));

            tree.delete(new Album(0, null, null, 15));

            assertEquals("ID: 1 NUM_SONGS: 10 -- [Artist 1, Artist 2], ID: 2 NUM_SONGS: 5 -- [Artist 1, Artist 2], N, N, N", tree.toString());
        }
        @Test
        public void testContains() {
            BinarySearchTree<Album> tree = new BinarySearchTree<>();
            List<String> artists = Arrays.asList("Artist 1", "Artist 2");
            tree.insert(new Album(1, artists, "Title 1", 10));
            tree.insert(new Album(2, artists, "Title 2", 5));
            tree.insert(new Album(3, artists, "Title 3", 15));

            assertTrue(tree.contains(new Album(0, null, null, 10)));
            assertFalse(tree.contains(new Album(0, null, null, 20)));
        }

}