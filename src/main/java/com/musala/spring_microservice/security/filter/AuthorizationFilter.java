package com.musala.spring_microservice.security.filter;

import com.musala.spring_microservice.security.TokenManager;
import com.musala.spring_microservice.service.UtilService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenManager tokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        List<GrantedAuthority> permissions = new ArrayList<>();
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                username = tokenManager.getAuthentication(token);

                if(username != null) {
                    List<String> permission = tokenManager.getPermissions(token);
                    permissions = tokenManager.getAuthorities(permission);
                    if(!permissions.isEmpty()) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                username, request.getHeader("Authorization").replace("Bearer ", ""), permissions);

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);

                    }
                } else {
                    handleUnauthorizedError(response, "No Authorization provided");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: "+ e.getMessage());
            handleUnauthorizedError(response, e.getMessage());
        }
    }


    private void handleUnauthorizedError(HttpServletResponse response, String errorMessage) throws IOException {
        System.out.println(errorMessage);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
        response.getWriter().write(UtilService.convertObjectToJson(responseEntity));
    }

}
