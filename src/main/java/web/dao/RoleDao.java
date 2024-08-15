package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String roleName);
    Role createRoleIfNotFound(String name, long id);
    List<Role> getAllRoles();  // Добавленный метод
}