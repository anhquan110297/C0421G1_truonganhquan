package email.models.services;

import email.models.bean.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    private List<Email> emailList = new ArrayList<>();

    @Override
    public void saveEmail(Email email) {
        emailList.add(email);
    }
}

