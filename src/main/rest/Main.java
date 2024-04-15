package rest;

import rest.configuration.RestConfig;
import rest.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RestConfig.class);
        Communication communication = applicationContext.getBean("communication",Communication.class);

        String cookie = communication.getCookie();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Cookie",cookie);

        List<User> allUsers = communication.getAllUser();
        System.out.println(allUsers);

        User user = new User(3L,"James","Brown",(byte)31);
        HttpEntity<User> httpEntity = new HttpEntity<>(user,httpHeaders);
        communication.saveUser(httpEntity);

        User user1 = new User(3L,"Thomas","Shelby",(byte)45);
        HttpEntity<User> httpEntity1 = new HttpEntity<>(user1,httpHeaders);
        communication.updateUser(httpEntity1);

        HttpEntity<User> httpEntity2 = new HttpEntity<>(user1,httpHeaders);
        communication.deleteUser(3L,httpEntity2);









    }
}
