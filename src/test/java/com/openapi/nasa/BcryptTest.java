package com.openapi.nasa;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
    @Test
    public void checkPasswords() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash1 = "$2a$10$4cnbKbq2zROx3zBZ9xMh6uRNHuSvDpWVmwz17PmvogpWxb1uUh18m"; // guest
        String hash2 = "$2a$10$uAu7BPIIZpXC.H1hJp453.Bsr/iJ7pYOP3GkXbA7m04Gc69nMc.n6"; // admin

        String[] passwords = {"admin", "password", "guest", "fun123", "123456", "springstudent", "root", "test", "fun1234"};
        
        for (String p : passwords) {
            if (encoder.matches(p, hash1)) {
                System.out.println("CRACKED GUEST: " + p);
            }
            if (encoder.matches(p, hash2)) {
                System.out.println("CRACKED ADMIN: " + p);
            }
        }
    }
}
