//package edu.vinu.TournamentDrawPlatform.model;
//
//import edu.vinu.TournamentDrawPlatform.entity.UsersEntity;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//@AllArgsConstructor
//public class UserPrinciple implements UserDetails {
//    private transient UsersEntity userEntity;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(userEntity.getRoles().name()));
//    }
//
//    @Override
//    public String getPassword() {
//        return userEntity.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userEntity.getEmail();
//    }
//}
