package kz.dar.academy.backend.feign;

import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.model.PostModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClient();

    @GetMapping("/client/all")
    List<ClientModel> getAllClients();

    @GetMapping("/client")
    ClientModel getClientById(@RequestParam String clientId);
}
