package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.RoleDao;
import web.model.User;
import web.model.Role;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @PostConstruct
    public void init() {
        Role adminRole = roleDao.getRoleByName("ADMIN");
        if (adminRole == null) {
            adminRole = new Role(1L, "ADMIN");
            roleDao.save(adminRole);
        }

        Role userRole = roleDao.getRoleByName("USER");
        if (userRole == null) {
            userRole = new Role(2L, "USER");
            roleDao.save(userRole);
        }

        if (userDao.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("roott");  // Устанавливаем имя пользователя
            admin.setPassword("roott");
            admin.setRoles(Set.of(adminRole, userRole));
            admin.setEmail("admin@example.com");  // Добавляем email
            admin.setName("roott");  // Добавляем имя
            admin.setLastname("Adminov");  // Добавляем фамилию
            admin.setAge((byte) 30);  // Добавляем возраст
            userDao.save(admin);
        }
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}