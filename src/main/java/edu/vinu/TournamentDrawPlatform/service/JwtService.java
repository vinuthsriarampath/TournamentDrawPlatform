//package edu.vinu.TournamentDrawPlatform.service;
//
//import edu.vinu.TournamentDrawPlatform.exceptions.custom.InternalServerErrorException;
//import edu.vinu.TournamentDrawPlatform.model.UserPrinciple;
//import org.springframework.stereotype.Service;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//    private final String secretKey;
//    public JwtService(){
//        try {
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
//            SecretKey sk =keyGenerator.generateKey();
//            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
//        } catch (NoSuchAlgorithmException e) {
//            throw new InternalServerErrorException("Internal Server Error while generating secret key");
//        }
//    }
//    public String generateToken(Authentication authentication) {
//        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("roles", userPrincipal.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .toList());
//
//        return Jwts.builder()
//                .claims(claims)
//                .subject(userPrincipal.getUsername())
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(getKey())
//                .compact();
//    }
//
//    public String generateResetToken(String email){
//        return Jwts.builder()
//                .subject(email)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 minutes expiration
//                .signWith(getKey())
//                .compact();
//    }
//
//    private SecretKey getKey(){
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String extractUsername(String token){
//        return extractClaim(token, Claims::getSubject);
//    }
//    private Date extractExpiration(String token){
//        return extractClaim(token,Claims::getExpiration);
//    }
//    private <T>T extractClaim(String token, Function<Claims,T> claimResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith(getKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    private boolean isTokenExpired(String token){
//        return extractExpiration(token).before(new Date());
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails){
//        final String username= extractUsername(token);
//        if(!username.equals(userDetails.getUsername())){
//            throw new JwtException("Username dose not match with the token subject!");
//        }
//        if (isTokenExpired(token)){
//            throw new JwtException("Token is Expired!");
//        }
//        if (!userDetails.isEnabled()){
//            throw new JwtException("User is Disabled!");
//        }
//        return (true);
//    }
//
//    public boolean validateResetToken(String token){
//        try {
//            if (isTokenExpired(token)) {
//                throw new JwtException("Reset token is expired");
//            }
//            return true;
//        } catch (JwtException e) {
//            throw new JwtException("Invalid reset token: " + e.getMessage());
//        }
//    }
//}
