//package com.musala.spring_microservice.security.filter;
//
//import com.musala.spring_microservice.repository.PermissionsRepository;
//import com.musala.spring_microservice.repository.UserRepository;
//import com.musala.spring_microservice.security.TokenManager;
//import com.musala.spring_microservice.service.UtilService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@Component
//public class AuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenManager tokenManager;
//
//    @Autowired
//    private PermissionsRepository permissionsRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        String token = null;
//        String userEmail = null;
//        try {
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                token = authHeader.substring(7);
//                userEmail = tokenManager.getAuthentication(token);
//            }
//
////        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            if (userEmail != null) {
//                List<String> permissions = permissionsRepository.getUserPermissionsByEmail(userEmail);
//                if (!permissions.isEmpty()) {
//                    List<GrantedAuthority> authList = tokenManager.getAuthorities(permissions);
//
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                            userEmail, request.getHeader("Authorization").replace("Bearer ", ""), authList);
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    filterChain.doFilter(request, response);
//                } else {
//                    log.error("User has no permissions granted");
//                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                    ResponseEntity<Object> responseEntity = new ResponseEntity<>("No Authorization provided", HttpStatus.UNAUTHORIZED);
//                    response.getWriter().write(UtilService.convertObjectToJson(responseEntity));
//                }
//            } else {
//                log.error("No Authorization provided");
//                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                ResponseEntity<Object> responseEntity = new ResponseEntity<>("No Authorization provided", HttpStatus.UNAUTHORIZED);
//                response.getWriter().write(UtilService.convertObjectToJson(responseEntity));
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//            ResponseEntity responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//            response.getWriter().write(UtilService.convertObjectToJson(responseEntity));
//        }
//    }
//}
