package pl.kodolamacz.spring;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import static org.assertj.core.api.Assertions.assertThat;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
//@Transactional
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserDao userDao;

    private User user;

    @Before
    public void init() {
        user = new User("email@pl", "pass");
        userDao.save(user);
        // tutaj inicjujemy start testów (kontekst testu)
    }


    @Test
    public void simpleFindTest() {
        assertThat(userDao.findAll()).isNotEmpty();
    }

    @Test
    public void findByEmailTest() {
        assertThat(userDao.findByEmail("email@pl")).isNotNull();
        assertThat(userDao.findByEmail("email@pl").getEmail()).isEqualTo("email@pl");
    }

    @Test
    public void findUserByEmail() {
        assertThat(userDao.findByPass("pass")).isNotNull();
    }

    @Test
    public void findUserByNotExistingEmail() {
        assertThat(userDao.findByEmail("xxxx")).isNull();
    }

    @Test
    public void saveTest() {
        long countBefore = userDao.count();
        User user = new User("email@pl2", "pass2");
        userDao.save(user);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();

        long countAfter = userDao.count();

        assertThat(countBefore).isLessThan(countAfter);
        assertThat(countBefore).isEqualTo(countAfter - 1);

    }

    @Test
    public void deleteTest() {

        long countBefore = userDao.count();

        User one = userDao.findOne(user.getId());
        userDao.delete(one);

        // to samo co:
        //userDao.delete(one.getId());

        long countAfter = userDao.count();
        assertThat(countBefore).isGreaterThan(countAfter);

        assertThat(userDao.findOne(user.getId())).isNull();

    }




}

