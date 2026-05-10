package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class ToDoControllerTest {
    
    @Test
    public void testCreate() {
        var controller = new ToDoController();
        var todo = new ToDo(1, "t", "d");
        controller.createTodo(1, todo);
        assertEquals(1, controller.count());
        assertEquals(1, controller.todo().size());
        controller.createTodo(todo);
        assertEquals(2, controller.count());
        assertEquals(2, controller.todo().size());
    }

    @Test
    public void testTest() {
        var controller = new ToDoController();
        var result = controller.test();
        assertTrue(result.contains("running"));
    }

    @Test
    public void testPing() {
        var controller = new ToDoController();
        var result = controller.ping();
        assertTrue(result.startsWith("{"));
        assertTrue(result.endsWith("}"));
    }

    @Test
    public void testDelete() {
        var controller = new ToDoController();
        var todo = mock(ToDo.class);
        when(todo.getId()).thenReturn(1);
        controller.createTodo(todo);
        assertEquals(1, controller.count());
        var result = controller.getTodo(1);
        assertEquals(1, result.getId());
        controller.deleteTodo(1);
        assertEquals(0, controller.count());
    }

}
