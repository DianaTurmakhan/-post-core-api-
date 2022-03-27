package kz.dar.academy.postcoreapi;

import kz.dar.academy.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/post")

public class PostController {
    @Autowired
    Environment env;

    @Autowired
     private PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel Postmodel){
        postService.createPost(Postmodel);
        return new ResponseEntity<String>("succesfully created", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkPost(){
        return new ResponseEntity<String>("post-core-api is working at" + env.getProperty("local.server.port"), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("{postID}")
    public String getStatusById(@PathVariable String postID){
        return postService.getPostById(postID);
    }

    @PutMapping("{postID}")
    public ResponseEntity<String> updatePost(@PathVariable String postID, @Valid @RequestBody PostModel Postmodel){
        postService.updatePostById(postID,Postmodel);
        return new ResponseEntity<String>("succesfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{postID}")
    public ResponseEntity<String> deletePostById (@PathVariable String postID){
        postService.deletePostById(postID);
        return new ResponseEntity<String>("succesfully deleted", HttpStatus.OK);
    }

}
