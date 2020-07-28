package eslam.emad.retrofitmvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import eslam.emad.retrofitmvvm.models.PostModel;
import eslam.emad.retrofitmvvm.repository.PostsRepository;

public class PostsViewModel extends ViewModel {

    private MutableLiveData<List<PostModel>> postsLiveData;

    public PostsViewModel() {
        postsLiveData = PostsRepository.getINSTANCE().getPosts();
    }

    MutableLiveData<List<PostModel>> getPostsLiveData() {
        return postsLiveData;
    }
}