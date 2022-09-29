import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import ro.atm.entities.User;
import ro.atm.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserRepositoryTest {

    @Test
    public void userSuccesfullyFound(){
        UserRepository userRepository = new UserRepository();
        userRepository.createDatabase();
        User user = userRepository.findUserByNameAndPin("Nicu","1234");
        assertEquals(user.getPin(),"1234" );
        assertEquals(user.getUsername(),"Nicu" );
    }

    @Test
    public void userWithWrongNameReturnsNull(){
        UserRepository userRepository = new UserRepository();
        userRepository.createDatabase();
        User user = userRepository.findUserByNameAndPin("Nicuu","1234");
        assertNull(user);
    }

    @Test
    public void userWithSmallNameReturnsUser(){
        UserRepository userRepository = new UserRepository();
        userRepository.createDatabase();
        User user = userRepository.findUserByNameAndPin("nicu","1234");
        assertEquals(user.getUsername(),"Nicu" );
    }

    @Test
    public void userWithWrongPinReturnsNull(){
        UserRepository userRepository = new UserRepository();
        userRepository.createDatabase();
        User user = userRepository.findUserByNameAndPin("Nicu","1222");
        assertNull(user);
    }

    @Test
    public void userWithWrongPinAndNameReturnsNull(){
        UserRepository userRepository = new UserRepository();
        userRepository.createDatabase();
        User user = userRepository.findUserByNameAndPin("Niceeu","12234");
        assertNull(user);
    }
}
