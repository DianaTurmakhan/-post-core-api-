package kz.dar.academy.postcoreapi.service;

import kz.dar.academy.postcoreapi.PostModel;
import java.util.List;

public interface PostService {
    void createPost(PostModel Postmodel);
    List<PostModel> getAllPosts();
    void updatePostById(String postID,PostModel Postmodel);
    String getPostById (String postID);
    void deletePostById(String postID);
}
