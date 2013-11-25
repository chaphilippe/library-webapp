package com.zuhlke.library.user;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.zuhlke.library.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {

    @Mock UserService mockUserService;
    @InjectMocks UserResource userResource = new UserResource(); 
    
    @Test
    public void shouldCreateUser() throws Exception {
        User user = new User().withName("Marvin");
        userResource.createUser(user);
        verify(mockUserService).createUser(user);
    }
    

}

