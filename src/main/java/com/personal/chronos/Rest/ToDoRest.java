package com.personal.chronos.Rest;

import com.personal.chronos.Entity.ToDo;
import com.personal.chronos.Services.ToDoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoRest {

    @Inject
    ToDoService toDoService;

    @Path("new")
    @POST
    public Response createToDo(ToDo todo) {
        toDoService.createTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response updateToDo(ToDo todo) {
        toDoService.updateToDo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public ToDo getToDo(@PathParam("id") long id) {
        return toDoService.findToDoById(id);
    }

    @Path("list")
    @GET
    public List<ToDo> getToDos() {
        return toDoService.getToDos();
    }
}
