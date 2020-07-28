package eslam.emad.retrofitmvvm.repository;

import androidx.lifecycle.MutableLiveData;


import java.util.ArrayList;
import java.util.List;

import eslam.emad.retrofitmvvm.data.ApiClient;
import eslam.emad.retrofitmvvm.models.PostModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsRepository {

    private static PostsRepository INSTANCE;
    private MutableLiveData<List<PostModel>> postsData;

    public static PostsRepository getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new PostsRepository();
        }
        return INSTANCE;
    }

    private PostsRepository() {
    }

    public MutableLiveData<List<PostModel>> getPosts(){
        postsData = new MutableLiveData<>();
        ApiClient.getINSTANCE().getPosts()
                .enqueue(new Callback<List<PostModel>>() {
                    @Override
                    public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                        postsData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<PostModel>> call, Throwable t) {

                    }
                });
        return postsData;
    }
}
