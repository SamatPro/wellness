package com.sera.wellness.services;

import com.sera.wellness.forms.UserLoginForm;
import com.sera.wellness.forms.UserProfileForm;
import com.sera.wellness.forms.UserRegistrationForm;
import com.sera.wellness.models.*;

import com.sera.wellness.repositories.DialogsRepository;
import com.sera.wellness.repositories.MessagesRepository;
import com.sera.wellness.repositories.UploadedFileRepository;
import com.sera.wellness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.config.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private DialogsRepository dialogsRepository;


    @Override
    public void signUp(UserRegistrationForm form) {
        if(!form.isConsentToTheProcessingOfPersonalData())
            throw new IllegalArgumentException("Согласие обязательно.");
        if(!form.getPassword().equals(form.getRepeatPassword()))
            throw new IllegalArgumentException("Пароли не совпадают.");
        if(userRepository.findByEmail(form.getEmail()).isPresent())
            throw new IllegalArgumentException("Такой пользователь уже зарегистрирован");
        if(!form.getSex().equals("male") &&
                !form.getSex().equals("female")) throw new IllegalArgumentException("Такого пола не существует");
        userRepository.save(User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .consentToReceiveEmails(form.isConsentToReceiveEmails())
                .sex(form.getSex().equals("male")?true:false)
                .hashPassword( new BCryptPasswordEncoder().encode(form.getPassword()))
                .build());
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            return userOptional.get();
        }else {
            return null;
            //throw new SecurityException("User with email <" + email + "> not found");
        }
    }

    @Override
    public void updateUser(User user, UserProfileForm form, String fileName) {
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        if (form.isConsentToReceiveEmails()){
            user.setConsentToReceiveEmails(true);
        }else {
            user.setConsentToReceiveEmails(false);
        }
        user.setConsentToReceiveEmails(form.isConsentToReceiveEmails());
        user.setSex(form.getSex());
        user.setAge(form.getAge());
        user.setGrowth(form.getGrowth());
        user.setWeight(form.getWeight());
        user.setPhotoSrc(fileName);
        user.setPurposeWeight(form.getPurposeWeight());
        updateUser(user);

        if (form.getPassword().length() != 0 && form.getPassword().equals(form.getRepeatPassword())) {
            user.setHashPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        }
        userRepository.update(user);
    }

    @Override
    public Optional<User> getThis(Long id) {
        return userRepository.findOne(id);
    }


    @Override
    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public void addToFriend(User user, Long friendId) {
        if (!user.getFriends().contains(userRepository.findOne(friendId).get())){
            userRepository.addToFriend(user.getId(), friendId);
        }
    }


    @Override
    public List<Message> getMessagesByDialogId(Long id) {
        return messagesRepository.getMessagesByDialogIdOrderByCreationTime(id);
    }

    @Override
    public void saveMessage(Message message) {
        messagesRepository.save(message);
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public Optional<Dialog> getDialog(Long id) {
        return dialogsRepository.findOne(id);
    }

    @Override
    public void savePhoto(String fileDir, MultipartFile photo) {
        try {
            byte[] bytes = photo.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(fileDir)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("Вам не удалось загрузить изображение => " + e.getMessage());
        }
    }
}
