package mk.ukim.finki.emt.user.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.address.Address;
import mk.ukim.finki.emt.user.domain.model.User;
import mk.ukim.finki.emt.user.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            userRepository.saveAndFlush(new User("Client 1", new Address("Street 1", "1", "City 1", "Country 1"), "asd@asd.com", "123456789"));
        }
    }
}
