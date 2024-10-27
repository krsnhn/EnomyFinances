package com.secnanifymone.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secnanifymone.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.roleName IN :roles")
    Set<Role> findBySpecificRoles(@Param("roles") Set<String> roles);

    Role findByRoleName(String roleName);

}
