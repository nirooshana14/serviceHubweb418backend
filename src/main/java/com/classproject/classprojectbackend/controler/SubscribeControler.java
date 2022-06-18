package com.classproject.classprojectbackend.controler;

import com.classproject.classprojectbackend.entity.Customer;
import com.classproject.classprojectbackend.entity.Subscribe;
import com.classproject.classprojectbackend.service.CustomerService;
import com.classproject.classprojectbackend.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/subscribe")
public class SubscribeControler {


    @Autowired(required=true)
    private SubscribeService subscribeService;

    @PostMapping("/addSubscribe")
    public ResponseEntity<String> addSubscribe(@RequestBody Subscribe subscribe){
        Subscribe subscribe1;
        try
          {
              System.out.println(subscribe);
            subscribe1=subscribeService.saveSubscribe(subscribe);

            return new ResponseEntity<String>("Subscribe details Added Successfully", HttpStatus.OK);

        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/getSubscribe/{serviceProviderId}")
    public ResponseEntity<Subscribe> getSubscribe(@PathVariable("serviceProviderId")int serviceProviderId){
        Subscribe subscribe1;
        try
        {

            System.out.println(serviceProviderId);
            subscribe1=subscribeService.getSubscribe(serviceProviderId);
            System.out.println(subscribe1);

            return new ResponseEntity<Subscribe>(subscribe1, HttpStatus.OK);

        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    @PostMapping("/updateSubscribe")
    public ResponseEntity<String> updateSubscribeDetails(

            @RequestParam("status") String status,
            @RequestParam("subscribeId") int subscribeId
    ){
        try
        {
            System.out.println("aalal");
               subscribeService.UpdateSubscribeQuotation(status,subscribeId);

            return new ResponseEntity<String>(status+" successfully", HttpStatus.OK);

        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    }
}
