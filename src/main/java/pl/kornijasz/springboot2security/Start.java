package pl.kornijasz.springboot2security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private PasswordEncoder passwordEncoder;
    private AppUserRepo appUserRepo;

    @Autowired
    public Start(PasswordEncoder passwordEncoder, AppUserRepo appUserRepo) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepo = appUserRepo;

        AppUser appUser = new AppUser();
        appUser.setUsername("Piotr");
        appUser.setPassword(passwordEncoder.encode("Piotr123"));
        appUserRepo.save(appUser);
    }
}
