//package edu.vinu.TournamentDrawPlatform.filter;
//
//import edu.vinu.TournamentDrawPlatform.service.JwtService;
//import edu.vinu.TournamentDrawPlatform.service.UserDetailsServiceImpl;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.NonNull;
//import org.springframework.beans.BeansException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//
//import java.io.IOException;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//    private final ApplicationContext context;
//    private final HandlerExceptionResolver handlerExceptionResolver;
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) {
//        String path = request.getServletPath();
//
//        // ✅ Skip JWT check for public endpoints and static file loads
//        if (isPublicPath(path)) {
//            try {
//                filterChain.doFilter(request, response);
//            } catch (IOException | ServletException e) {
//                log.error("JWTFilter Public Path Error: {}", e.getMessage());
//                handlerExceptionResolver.resolveException(request, response, null, e);
//            }
//            return;
//        }
//
//        try {
//            String authHeader = request.getHeader("Authorization");
//            String token = null;
//            String username = null;
//
//            if (authHeader != null && authHeader.startsWith("Bearer")) {
//                token = authHeader.substring(7);
//                username = jwtService.extractUsername(token);
//            }
//
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = context.getBean(UserDetailsServiceImpl.class).loadUserByUsername(username);
//                if (jwtService.validateToken(token, userDetails)) {
//                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authToken);
//                }
//            }
//
//            filterChain.doFilter(request, response);
//        } catch (AuthenticationException | ServletException e) {
//            log.error("JWTFilter Section 2: {}", e.getMessage());
//            handlerExceptionResolver.resolveException(request, response, null, e);
//        } catch (BeansException e) {
//            log.error("JWTFilter Section 3: {}", e.getMessage());
//            handlerExceptionResolver.resolveException(request, response, null, e);
//        } catch (IOException e) {
//            log.error("JWTFilter Section 4: {}", e.getMessage());
//            handlerExceptionResolver.resolveException(request, response, null, e);
//        } catch (RuntimeException e) {
//            log.error("RuntimeException in JWTFilter: {}", e.getMessage());
//            handlerExceptionResolver.resolveException(request, response, null, e);
//        }
//    }
//
//    private boolean isPublicPath(String path) {
//        return path.startsWith("/api/v2/auth/");
//    }
//
//}
