package todo;

import com.google.gson.Gson;
import org.eclipse.jetty.server.Authentication;

import java.util.ArrayList;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class TodoApp {

    static ArrayList<Todo> todoList = new ArrayList<Todo>();

    public static void main(String[] args) {
        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        after((req, res) -> {
            res.type("application/json");
        });

        post("/todo", (req, res) -> {
            Todo todo = new Gson().fromJson(req.body(), Todo.class);
            todoList.add(todo);
            return todo.toJson();
        });

        // get without id
        get("/todo", (req, res) -> new Gson().toJson(todoList));

        // get with id
        get("/todo/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            for (Todo t : todoList) {
                if (t.getId().equals(id)) {
                    return t.toJson();
                }
            }
            return null;
        });

        put("/todo/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            Todo nT = new Gson().fromJson(req.body(), Todo.class);
            for (Todo t : todoList) {
                if (t.getId().equals(id)) {
                    todoList.remove(t);
                    todoList.add(nT);
                    return nT.toJson();
                }
            }
            return null;
        });

        delete("/todo/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            Todo todo;
            for (Todo t : todoList) {
                if (t.getId().equals(id)) {
                    todo = t;
                    todoList.remove(t);
                    return todo.toJson();
                }
            }
            return null;
        });

    }
}

