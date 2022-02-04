package com.personal.chronos.Services;

import com.personal.chronos.Entity.ToDo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


import java.util.List;

@Transactional
public class ToDoService {

    @PersistenceContext
    EntityManager entityManager;

    public ToDo createTodo(ToDo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public ToDo updateToDo(ToDo todo) {
        entityManager.merge(todo);
        return todo;
    }

    public ToDo findToDoById(long id) {
        return entityManager.find(ToDo.class, id);
    }

    public List<ToDo> getToDos() {
        return entityManager.createQuery("SELECT t from ToDo t", ToDo.class).getResultList();
    }
}
