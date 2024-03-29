package gabriellee.project.rxjavaflatmap.request;

import java.util.List;

import gabriellee.project.rxjavaflatmap.model.Comment;
import gabriellee.project.rxjavaflatmap.model.Post;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestApi {

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Observable<List<Comment>> getComments(
            @Path("id") int id
    );
}