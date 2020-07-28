package eslam.emad.retrofitmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eslam.emad.retrofitmvvm.R;
import eslam.emad.retrofitmvvm.models.PostModel;

public class MainActivity extends AppCompatActivity {
    PostsViewModel postsViewModel;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.tv);

        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        postsViewModel.getPostsLiveData().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                if (postModels != null) {
                    for (PostModel postModel : postModels) {
                        String content = "";
                        content += "ID : " + postModel.getId() + "\n";
                        content += "userId " + postModel.getUserId() + "\n";
                        content += "Title : " + postModel.getTitle() + "\n";
                        content += "Text : " + postModel.getText() + "\n\n";
                        content += "*************** \n\n";
                        textViewResult.append(content);
                    }
                }
            }
        });
    }
}
