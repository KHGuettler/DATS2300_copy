import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @org.junit.jupiter.api.Test
    void maks() {
        int values[] = {1, 2, 3, 5, 9, 8, 19, 11};
        Tabell.maks(values);
        int maks_index = 6;
        int maks = 19;
        assertEquals(Tabell.maks(values), maks_index);
    }

    @org.junit.jupiter.api.Test
    void permDupes() {
    }

    @org.junit.jupiter.api.Test
    void permUnique() {
    }

    @org.junit.jupiter.api.Test
    void antallMaks() {
    }

    @org.junit.jupiter.api.Test
    void shuffle() {
    }

    @org.junit.jupiter.api.Test
    void bytt() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}