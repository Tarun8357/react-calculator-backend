package com.unoveo.repository;

import com.unoveo.models.ERole;
import com.unoveo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

//@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
