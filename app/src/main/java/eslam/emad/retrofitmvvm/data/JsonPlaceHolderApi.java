package eslam.emad.retrofitmvvm.data;

import java.util.List;

import eslam.emad.retrofitmvvm.models.PostModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<PostModel>> getPost();
}
