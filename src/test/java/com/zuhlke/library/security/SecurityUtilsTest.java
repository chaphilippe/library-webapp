package com.zuhlke.library.security;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecurityUtilsTest {

    public SecurityUtils securityUtils = new SecurityUtils();
    
    @Test
    public void shouldHashPassword() throws Exception {
        securityUtils.init();
        String hash = securityUtils.hash("password", "admin@zuhlke.com");
        String adminHash = securityUtils.hash("password", "admin");
        assertEquals("7Le61jX4m+a+1TNd/ltaD7ee+jyqsgYV0Mfd0EYS18RqxBX+9YfVbkXZRd9/VdZAJ7l/SDcQn03NicBe5vnj8A==", hash);
        assertEquals("TmE4d/EGKVXWyTWjUcCw9qoUr2bXprAzNafsV5iLHjdoPk39EAQYVxTMoacu50NlCXx70AJXsHkdN0y3mG8Ycg==", adminHash);
    }
    
}
