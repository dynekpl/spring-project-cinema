package pl.kodolamacz.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.spring.dao.repository.UserDao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
//@Transactional
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private UserDao userDao;

  @Before
  public void init() {
    // tutaj inicjujemy start testów (kontekst testu)
  }

  @Test
  public void simpleTest() {
    assertThat(userDao.findAll(), is(not(nullValue())));
  }

  @Test
  public void findUserByEmail() {
    assertThat(userDao.findByEmail("arek@cacko.pl"), is(not(nullValue())));
  }

  @Test
  public void findUserByNotExistingEmail() {
    assertThat(userDao.findByEmail("xxxx"), is(nullValue()));
  }
}