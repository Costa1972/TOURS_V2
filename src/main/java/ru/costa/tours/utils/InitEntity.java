package ru.costa.tours.utils;

import org.springframework.stereotype.Component;
import ru.costa.tours.models.*;
import ru.costa.tours.repository.PassportRepository;
import ru.costa.tours.repository.PaymentRepository;
import ru.costa.tours.repository.RoleRepository;
import ru.costa.tours.repository.UserRepository;

import java.util.Set;

@Component
public class InitEntity {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PaymentRepository paymentRepository;
    private final PassportRepository passportRepository;


    public InitEntity(UserRepository userRepository,
                      RoleRepository roleRepository,
                      PaymentRepository paymentRepository,
                      PassportRepository passportRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.paymentRepository = paymentRepository;
        this.passportRepository = passportRepository;

        Role admin = roleChecker("ROLE_ADMIN", roleRepository);
        Role user = roleChecker("ROLE_USER", roleRepository);
        Role master = roleChecker("ROLE_MASTER", roleRepository);


        Passport passport_1 = Passport.builder().id(0L).series("4523").number("549835").build();
        Passport passport_2 = Passport.builder().id(0L).series("4632").number("148324").build();
        Passport passport_3 = Passport.builder().id(0L).series("4573").number("936345").build();

        PaymentBasis paymentBasis_1 = PaymentBasis.builder().title("TRAIN").build();
        PaymentBasis paymentBasis_2 = PaymentBasis.builder().title("HOTEL").build();
        PaymentBasis paymentBasis_3 = PaymentBasis.builder().title("MUSICIANS").build();

        Payment payment_1 = Payment.builder().id(0L).amount(10000L).paymentBasis(paymentBasis_1).build();
        Payment payment_2 = Payment.builder().id(0L).amount(15000L).paymentBasis(paymentBasis_2).build();
        Payment payment_3 = Payment.builder().id(0L).amount(30000L).paymentBasis(paymentBasis_3).build();

        Password password_1 = new Password("$2a$16$wKeop0Xl9ZZhIpxN8Cemu.oU.oU2AEw9TWif1vjc5Ld0Buc95YRCq");
        Password password_2 = new Password("$2a$16$82KwrDP0zwUF5K4CJlZNc.0.WCy21hc/kU9i4CkZ32inz0Ku53Z.W");
        Password password_3 = new Password("$2a$16$Hcv.E8BfsCOXPWO4FJrTteAX6RvjgENDnIH7n192CHkQiA9gU1QI6");


        User user_1 = User.builder()
                .id(0L)
                .lastName("Antonov")
                .firstName("Anton")
                .patronymic("Antonovich")
                .phone("+495 342-98-54")
                .emailAsUsername("anton@mail.ru")
                .password(password_1)
                .roles(Set.of(admin))
                .passport(passport_1)
                .payments(Set.of(payment_1))
                .build();
        User user_2 = User.builder()
                .id(0L)
                .lastName("Smirnov")
                .firstName("Oleg")
                .patronymic("Ivanovich")
                .phone("+495 547-98-54")
                .emailAsUsername("oleg@mail.ru")
                .password(password_2)
                .roles(Set.of(user))
                .passport(passport_2)
                .payments(Set.of(payment_2))
                .build();
        User user_3 = User.builder()
                .id(0L)
                .lastName("Viktorov")
                .firstName("Viktor")
                .patronymic("Viktorovich")
                .phone("+495 156-97-63")
                .emailAsUsername("viktor@mail.ru")
                .password(password_3)
                .roles(Set.of(master))
                .passport(passport_3)
                .payments(Set.of(payment_3))
                .build();

        userRepository.save(user_1);
        userRepository.save(user_2);
        userRepository.save(user_3);
    }


    private Role roleChecker(String roleName, RoleRepository roleRepository) {
        return roleRepository.findByName(roleName).orElseGet(() ->
                roleRepository.save(new Role(0L, roleName)));

    }
}
