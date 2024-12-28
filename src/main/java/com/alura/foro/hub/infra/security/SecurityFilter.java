package com.alura.foro.hub.infra.security;

import com.alura.foro.hub.domain.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("This is the beginning of the filter");
        String token = request.getHeader("Authorization");

        if (token != null) {
            System.out.println("Verifying token");
            token = token.replace("Bearer ", "");
            System.out.println(token);
            //Is this user logged in?
            String subject = tokenService.getSubject(token);
            if (subject != null) {
                var user = userRepository.findByUsername(subject);
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            System.out.println(subject);
        }
        filterChain.doFilter(request, response);
    }
}
