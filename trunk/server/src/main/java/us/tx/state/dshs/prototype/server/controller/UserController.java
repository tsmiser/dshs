package us.tx.state.dshs.prototype.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import us.tx.state.dshs.prototype.server.model.User;
import us.tx.state.dshs.prototype.server.service.UserService;

@Controller
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteUser(@PathVariable Long id) {
        userService.remove(id);
        return HttpStatus.OK;
    }
}
