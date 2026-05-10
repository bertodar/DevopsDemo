package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class PathListEntryTest {

    @Test
    public void testSettersAndGetters() {
        PathListEntry<String> entry = new PathListEntry<>();

        // Test Key
        entry.setKey("testKey", "testName");
        assertEquals("testKey", entry.getKey().getKey());
        assertEquals("testName", entry.getKey().getName());

        // Test Name
        entry.setName("testName");
        assertEquals("testName", entry.getName());

        // Test Color
        entry.setColor("testColor");
        assertEquals("testColor", entry.getColor());

        // Test Icon
        entry.setIcon("testIcon");
        assertEquals("testIcon", entry.getIcon());

        // Test URL
        entry.setUrl("testUrl");
        assertEquals("testUrl", entry.getUrl());

        // Test Page
        entry.setPage("testPage");
        assertEquals("testPage", entry.getPage());

        // Test Type
        entry.setType("testType");
        assertEquals("testType", entry.getType());

        // Test Active
        entry.setActive(false);
        assertFalse(entry.isActive());

        // Test Tooltip
        entry.setTooltip("testTooltip");
        assertEquals("testTooltip", entry.getTooltip());

        // Test Details
        List<String> details = Arrays.asList("detail1", "detail2");
        entry.setDetails(details);
        assertEquals(details, entry.getDetails());

        // Test Order
        entry.setOrder(1.23f);
        assertEquals(1.23f, entry.getOrder());

        // Test Form
        entry.setForm("testForm");
        assertEquals("testForm", entry.getForm());
        entry.setForm(null);
        assertNull(entry.getForm());
    }

    @Test
    public void testHashCodeAndEquals() {
        PathListEntry<String> entry1 = new PathListEntry<>();
        PathListEntry<String> entry2 = new PathListEntry<>();

        // Set the same key for both entries
        entry1.setKey("testKey", "testName");
        entry2.setKey("testKey", "testName");

        // Test equals
        assertEquals(entry1, entry2);

        // Test hashCode
        assertEquals(entry1.hashCode(), entry2.hashCode());

        // Modify one entry and test inequality
        entry2.setKey("differentKey", "testName");
        assertNotEquals(entry1, entry2);
        assertNotEquals(entry1.hashCode(), entry2.hashCode());
    }

    @Test
    public void testKeyHashCodeAndEquals() {
        PathListEntry<String>.Key key1 = new PathListEntry<String>().new Key("key1", "name1");
        PathListEntry<String>.Key key2 = new PathListEntry<String>().new Key("key1", "name1");
        PathListEntry<String>.Key key3 = new PathListEntry<String>().new Key("key2", "name2");

        // Test equals
        assertEquals(key1, key2);
        assertNotEquals(key1, key3);

        // Test hashCode
        assertEquals(key1.hashCode(), key2.hashCode());
        assertNotEquals(key1.hashCode(), key3.hashCode());
    }

    @Test
    public void testConstructor() {
        PathListEntry<String> entry = new PathListEntry<>();
        assertTrue(entry.isActive());
        assertNotNull(entry.getDetails());
    }

    @Test
    public void testEqualsAndHashCodeWithNullValues() {
        PathListEntry<String> entry1 = new PathListEntry<>();
        PathListEntry<String> entry2 = new PathListEntry<>();

        // Set null key for both entries
        entry1.setKey(null, null);
        entry2.setKey(null, null);

        // Test equals with null values
        assertEquals(entry1, entry2);

        // Test hashCode with null values
        assertEquals(entry1.hashCode(), entry2.hashCode());

        // Modify one entry and test inequality
        entry2.setKey("testKey", "testName");
        assertNotEquals(entry1, entry2);
        assertNotEquals(entry1.hashCode(), entry2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentValues() {
        PathListEntry<String> entry1 = new PathListEntry<>();
        PathListEntry<String> entry2 = new PathListEntry<>();

        // Set different keys for both entries
        entry1.setKey("key1", "name1");
        entry2.setKey("key2", "name2");

        // Test equals with different values
        assertNotEquals(entry1, entry2);

        // Test hashCode with different values
        assertNotEquals(entry1.hashCode(), entry2.hashCode());
    }
}