package us.tx.state.dshs.prototype.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import us.tx.state.dshs.prototype.server.model.DataTable;
import us.tx.state.dshs.prototype.server.model.User;
import us.tx.state.dshs.prototype.server.service.UserService;

import java.util.List;

@Controller

public class UserController extends BaseController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value="/user/get/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @RequestMapping(value="/user", method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteUser(@PathVariable Long id) {
        userService.remove(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public @ResponseBody List<User> getAll() {
        List<User> users = userService.getAll();
        for(User user : users) {
            user.setCreationTime(null);
            user.setPassword(null);
            user.setPasswordHash(null);
            user.setModificationTime(null);
        }
        return users;
    }

    @RequestMapping(value = "/users/datatable", method=RequestMethod.GET)
    public @ResponseBody DataTable getDatatable() {
        List<User> users = userService.getAll();
        for(User user : users) {
            user.setCreationTime(null);
            user.setId(null);
            user.setPassword(null);
            user.setPasswordHash(null);
            user.setModificationTime(null);
        }

        return convertToDataTable(users);
    }
}
