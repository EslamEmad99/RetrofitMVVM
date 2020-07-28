package eslam.emad.retrofitmvvm.data;

import java.util.List;

import eslam.emad.retrofitmvvm.models.PostModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private static ApiClient INSTANCE;

    private ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }

    public static ApiClient getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts(){
        return jsonPlaceHolderApi.getPost();
    }
}
