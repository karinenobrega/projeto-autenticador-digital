package project.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    public void testPushEPop() {
        //GIVEN
        MyStack<String> stack = new MyStack<>();

        //WHEN
        stack.push("A");
        stack.push("B");

        //THEN
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testLIFO() {
        //GIVEN - pilha vazia
        MyStack<String> stack = new MyStack<>();

        //WHEN - insere 3 elementos em ordem
        stack.push("primeiro");
        stack.push("segundo");
        stack.push("terceiro");

        //THEN - remove em ordem inversa (Last In First Out)
        assertEquals("terceiro", stack.pop());
        assertEquals("segundo", stack.pop());
        assertEquals("primeiro", stack.pop());
    }

    @Test
    public void testIsEmpty() {
        //GIVEN
        MyStack<String> stack = new MyStack<>();

        //THEN - vazio inicialmente
        assertTrue(stack.isEmpty());

        //WHEN
        stack.push("dado");

        //THEN - não vazio após push
        assertFalse(stack.isEmpty());

        //WHEN
        stack.pop();

        //THEN - vazio novamente após pop
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopEmStackVazia() {
        //GIVEN
        MyStack<String> stack = new MyStack<>();

        //WHEN
        Object resultado = stack.pop();

        //THEN
        assertNull(resultado);
    }
}
