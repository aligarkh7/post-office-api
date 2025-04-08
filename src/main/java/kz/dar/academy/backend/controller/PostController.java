package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.model.PostModel;
import kz.dar.academy.backend.model.PostResponse;
import kz.dar.academy.backend.service.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/office")
public class PostController {

    @Autowired
    private PostFeign postFeign;

    @Autowired
    private ClientFeign clientFeign;

    @Autowired
    private PostOffice postOffice;

    @GetMapping("/check")
    public String checkPostOffice() {
        return "post-office-api is working";
    }

    @GetMapping("/post/check")
    public String checkPost(){
        return postFeign.checkPost();
    }

    @GetMapping("/post/all")
    public List<PostModel> getAllPosts(){
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postFeign.getPostById(postId);
    }



    @GetMapping("/client/check")
    public String checkClient(){
        return clientFeign.checkClient();
    }

    @GetMapping("/client/all")
    public List<ClientModel> getAllClients(){
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId){
        return clientFeign.getClientById(clientId);
    }

    @GetMapping("/{postId}")
    public PostResponse getPostDetails(@PathVariable String postId){
        return postOffice.getPostDetails(postId);
    }
}
