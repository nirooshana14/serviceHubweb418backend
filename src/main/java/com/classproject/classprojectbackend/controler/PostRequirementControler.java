package com.classproject.classprojectbackend.controler;

import com.classproject.classprojectbackend.entity.Customer;
import com.classproject.classprojectbackend.entity.PostRequirement;
import com.classproject.classprojectbackend.entity.Quotation;
import com.classproject.classprojectbackend.entity.UserType;
import com.classproject.classprojectbackend.service.CustomerService;
import com.classproject.classprojectbackend.service.PostRequirmentService;
import com.classproject.classprojectbackend.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/postrequirement")
public class PostRequirementControler {

    @Autowired(required = true)
    private PostRequirmentService postRequirmentService;

    @Autowired(required = true)
    private SubscribeService subscribeService;

    @PostMapping("/addPostRequirement")
    public ResponseEntity<String> addCustomer(@RequestBody PostRequirement postRequirement) {
        PostRequirement postRequirement1;
        try {
            postRequirement1 = postRequirmentService.savePostRequirement(postRequirement);
            return new ResponseEntity<String>("Post Requirement Details Added Successfully", HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<String>("Post Requirement Details Not Added", HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/getPostRequirements")
    public ResponseEntity<ArrayList<PostRequirement>> getPostRequirements() {

        ArrayList<PostRequirement> postRequirements = null;
        try {
            postRequirements = postRequirmentService.getPostRequirements();

            return new ResponseEntity<ArrayList<PostRequirement>>(postRequirements, HttpStatus.OK);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @PostMapping("/postQuatation")
    public ResponseEntity<String> postQuatation(@RequestBody Quotation quotation) {

        try {
            postRequirmentService.postQuatation(quotation);

            return new ResponseEntity<String>("Quatation Posted Sucessfully", HttpStatus.OK);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @GetMapping("/postQuatation/{subscribeId}")
    public ResponseEntity<String> postQuatation(@PathVariable("subscribeId")int id) {

        try {

            subscribeService.UpdateSubscribeQuotation(id);

            return new ResponseEntity<String>("Quatation Posted Sucessfully", HttpStatus.OK);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @GetMapping("/getQuatation/{serviceConsumerId}")
    public ResponseEntity<ArrayList<Quotation>> updatePackage(@PathVariable("serviceConsumerId") int serviceConsumerId
    ) {

        try {

            ArrayList<Quotation> quotations = postRequirmentService.getQuatations(serviceConsumerId);

            return new ResponseEntity<ArrayList<Quotation>>(quotations, HttpStatus.OK);


        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }


}

