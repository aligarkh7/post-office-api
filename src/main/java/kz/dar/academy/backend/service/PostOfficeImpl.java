package kz.dar.academy.backend.service;

import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.model.PostModel;
import kz.dar.academy.backend.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeImpl implements PostOffice {

    @Autowired
    ClientFeign clientFeign;

    @Autowired
    PostFeign postFeign;

    @Override
    public PostResponse getPostDetails(String postId) {
        PostModel postModel = postFeign.getPostById(postId);

        ClientModel clientModel1 = clientFeign.getClientById(postModel.getClientId());
        ClientModel clientModel2 = clientFeign.getClientById(postModel.getPostRecipientId());

        ClientResponse client = new ClientResponse(clientModel1.getName(), clientModel1.getSurname(), clientModel1.getEmail());
        ClientResponse receiver = new ClientResponse(clientModel2.getName(), clientModel2.getSurname(), clientModel2.getEmail());

        return new PostResponse(
                postModel.getPostId(),
                client, receiver,
                postModel.getPostItem(),
                postModel.getStatus()
        );
    }
}
