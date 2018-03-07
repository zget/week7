package com.gech.demo.Model;

import org.springframework.data.repository.CrudRepository;

public interface AppRoleRepository extends CrudRepository<AppRole, Long> {
    AppRole findAppRoleByRoleName(String role);
}
