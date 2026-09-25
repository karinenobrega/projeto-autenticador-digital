package project;

import org.junit.jupiter.api.Test;
import project.list.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    @Test
    void emptyListTest(){
        DoublyLinkedList list = new DoublyLinkedList();

        assertNull(list.getTail());
    }

    @Test
    void insertBackATest(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertToBack("A");

        assertEquals("A",list.getTail().getData());
    }

    @Test
    void insertBackBTest(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertToBack("A");
        list.insertToBack("B");

        assertEquals("B",list.getTail().getData());
    }
}

