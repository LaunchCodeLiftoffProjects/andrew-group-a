package org.launchcode.andrewgroupa.models;

import java.util.Optional;
import org.launchcode.andrewgroupa.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);

    user.orElseThrow(() -> new UsernameNotFoundException(username + "does not exist."));

    return user.map(MyUserDetails::new).get();
  }
}
