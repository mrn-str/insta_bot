import com.github.instagram4j.instagram4j.responses.IGResponse;
import instagram.InstaService;
import lombok.SneakyThrows;

import java.security.Security;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

        InstaService instaService = new InstaService();
        for (int i = 0; i < 5000; i++) {
            IGResponse response = instaService.postComment(getMediaIdFromCode("CHc4OAYnmLY"), "+");
            System.out.println(response.getError_type());
            System.out.println(response.getMessage());
            System.out.println("comment #" + i);
            Thread.sleep((long) (5000 + Math.random()*10000));
        }
    }

    public static String getMediaIdFromCode(String mediaCode) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
        long id = 0;
        for (int i = 0; i < mediaCode.length(); i++) {
            char c = mediaCode.charAt(i);
            id = id * 64 + alphabet.indexOf(c);
        }
        return id + "";
    }
}
