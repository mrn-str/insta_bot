package instagram;

import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.requests.media.MediaCommentRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import lombok.SneakyThrows;

public class InstaService {
    private static final String LOGIN = "";
    private static final String PASSWORD = "";
    private IGClient igClient;

    @SneakyThrows
    private IGClient getClient() {
        if (igClient == null) {
            igClient = IGClient.builder()
                    .username(LOGIN)
                    .password(PASSWORD)
                    .login();
        }
        return igClient;
    }

    @SneakyThrows
    public IGResponse postComment(String postId, String comment) {
        MediaCommentRequest mediaCommentRequest =
                new MediaCommentRequest(postId, comment);
        return getClient()
                .sendRequest(mediaCommentRequest)
                .get();
    }
}
