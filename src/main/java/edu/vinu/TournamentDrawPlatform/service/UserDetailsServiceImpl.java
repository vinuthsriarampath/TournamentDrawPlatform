//package edu.vinu.TournamentDrawPlatform.service;
//
//import edu.vinu.TournamentDrawPlatform.entity.UsersEntity;
//import edu.vinu.TournamentDrawPlatform.model.UserPrinciple;
//import edu.vinu.TournamentDrawPlatform.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository userDetailsRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UsersEntity userEntity = userDetailsRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));
//        return new UserPrinciple(userEntity);
//    }
//}
