package com.lolmeida.resource;

import com.lolmeida.dto.request.UserRequest;
import com.lolmeida.dto.response.UserResponse;
import com.lolmeida.mapper.UserMapper;
import com.lolmeida.service.UserService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserResourceTest {

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    private UserResource userResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userResource = new UserResource(userService, userMapper);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<UserResponse> expectedResponses = Arrays.asList(new UserResponse(), new UserResponse());
        when(userService.findAll("date, id")).thenReturn(expectedResponses);
        when(userMapper.objToResponse(any())).thenReturn(new UserResponse());

        // Act
        Response response = userResource.getAll();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(userService).findAll("date, id");
        verify(userMapper, times(expectedResponses.size())).objToResponse(any());
    }

    @Test
    public void testSearch() {
        // Arrange
        String field = "name";
        String value = "example";
        List<UserResponse> expectedResponses = Arrays.asList(new UserResponse(), new UserResponse());
        when(userService.search(field, value)).thenReturn(expectedResponses);
        when(userMapper.objToResponse(any())).thenReturn(new UserResponse());

        // Act
        Response response = userResource.search(field, value);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(userService).search(field, value);
        verify(userMapper, times(expectedResponses.size())).objToResponse(any());
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        String id = "123";
        List<UserResponse> expectedResponses = Arrays.asList(new UserResponse(), new UserResponse());
        when(userService.findBy(id)).thenReturn(expectedResponses);
        when(userMapper.objToResponse(any())).thenReturn(new UserResponse());

        // Act
        Response response = userResource.findByCustomer(id);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(userService).findBy(id);
        verify(userMapper, times(expectedResponses.size())).objToResponse(any());
    }

    @Test
    public void testSave() {
        // Arrange
        UserRequest userRequest = new UserRequest();
        when(userMapper.requestToObj(userRequest)).thenReturn(new User());

        // Act
        Response response = userResource.save(userRequest);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(userService).save(any(User.class));
        verify(userMapper).requestToObj(userRequest);
    }
}