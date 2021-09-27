package org.launchcode.andrewgroupa.data;

import java.util.Optional;
import org.launchcode.andrewgroupa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUsername(String username);

}
