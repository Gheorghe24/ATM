import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.atm.entities.Account;
import ro.atm.entities.AccountCurrency;
import ro.atm.entities.User;
import ro.atm.repository.UserRepository;
import ro.atm.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();
    @BeforeEach
    public void setup(){
        userRepository.createDatabase();
    }
    @Test
    public void userSuccesfullyFound(){
        User user = userRepository.findUserByUsernameAndPin("Nicu","1234");
        assertEquals(user.getPin(),"1234" );
        assertEquals(user.getUsername(),"Nicu" );
    }

    @Test
    public void userWithWrongNameReturnsNull(){
        User user = userRepository.findUserByUsernameAndPin("Nicuu","1234");
        assertNull(user);
    }

    @Test
    public void userWithSmallNameReturnsUser(){
        User user = userRepository.findUserByUsernameAndPin("nicu","1234");
        assertEquals(user.getUsername(),"Nicu" );
    }

    @Test
    public void userWithWrongPinReturnsNull(){
        User user = userRepository.findUserByUsernameAndPin("Nicu","1222");
        assertNull(user);
    }

    @Test
    public void userWithWrongPinAndNameReturnsNull(){
        User user = userRepository.findUserByUsernameAndPin("Niceeu","12234");
        assertNull(user);
    }

    @Test
    public void checkUserInDatabase(){
        Account account = new Account(100, AccountCurrency.valueOf("USD"), Utils.getRandomNumber(8));
        List<Account> list = new ArrayList<>(Arrays.asList(account));
        User user = new User("Gheorghe", "01.01.01", "1111", list);
        userRepository.addUserToDatabase(user);

        assertEquals(user,userRepository.findUserByUsernameAndPin("Gheorghe", "1111"));
    }


}
