package com.corespecs.polls9ja.controller.v3;

import com.corespecs.polls9ja.domain.User;
import com.corespecs.polls9ja.dto.error.ErrorDetail;
import com.corespecs.polls9ja.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

@RestController("userControllerV3")
@RequestMapping("/v3/")
@Api(value = "users", tags = "Users API")
public class UserController {

    @Inject
    private UserService userService;

    @PreAuthorize( "hasRole(@roles.ADMIN)" )
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new User", notes="The newly created user Id will be sent in the location response header", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code=201, message="User Created Successfully", response=Void.class), @ApiResponse(code=500, message="Error creating User", response= ErrorDetail.class) } )
    public ResponseEntity<Void> createUser(@RequestBody @Valid User user) throws Exception {

        user = userService.saveUser(user);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        responseHeaders.setLocation(newUserUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    @ApiOperation(value = "Retrieves all users", response=User.class, responseContainer="List")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Collection<User> allUsers = userService.fetchAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
