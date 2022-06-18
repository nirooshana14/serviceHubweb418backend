package com.classproject.classprojectbackend.controler;

import com.classproject.classprojectbackend.entity.*;
import com.classproject.classprojectbackend.service.*;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.classproject.classprojectbackend.controler.QuestionControler.saveFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private AgentService agentService;

    @Autowired(required = true)
    private ServiceProviderService serviceProviderService;

    @Autowired(required = true)
    private UserTypeService userTypeService;

    @Autowired(required = true)
    private ServiceConsumerService serviceConsumerService;

    @Autowired(required = true)
    private PackageService packageService;

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/postUsers")
    public Users addUser(@RequestBody Users users) {
        Users users1;
        try {
            users1 = userService.getUserByEmail(users.getEmail());
            System.out.println(users1);

            if (users1 == null) {
                users1 = userService.saveUser(users);
                return users1;
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }


    @PostMapping("/saveAgent")
    public ResponseEntity<String> saveAgent(@RequestBody Agent agent) {
        Agent agent1;
        try {

            agentService.saveAgent(agent);
            return new ResponseEntity<String>("Your details added sucessfully now admin want to accept you", HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/saveServiceProvider")
    public ResponseEntity<String> saveServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        ServiceProvider serviceProvider1;
        try {

            System.out.println(serviceProvider.getUsers().getUserName());
            serviceProviderService.saveServiceProvider(serviceProvider);
            return new ResponseEntity<String>("Your details added sucessfully now admin want to accept you", HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/saveServiceConsumer")
    public ResponseEntity<String> saveServiceConsumer(@RequestBody ServiceConsumer serviceConsumer) {
        try {

            serviceConsumerService.saveServiceConsumer(serviceConsumer);
            return new ResponseEntity<String>("Your details added sucessfully", HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getUserTypes")
    public ResponseEntity<ArrayList<UserType>> getUserTypes() {
        ArrayList<UserType> usersTypes = null;
        try {
            usersTypes = userTypeService.getUserType();

            return new ResponseEntity<ArrayList<UserType>>(usersTypes, HttpStatus.OK);

        } catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/getAgents")
    public ResponseEntity<ArrayList<Agent>> getAgents() {
        ArrayList<Agent> agents = null;
        try {
            agents = agentService.getAgentByResult();

            return new ResponseEntity<ArrayList<Agent>>(agents, HttpStatus.OK);

        } catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/updateAgent/{result},{agentId},{userId}")
    public ResponseEntity<String> updateAgent(@PathVariable("result") String result,
                                              @PathVariable("agentId") int agentId,
                                              @PathVariable("userId") int userId

    ) {

        try {
            boolean a=true;
            int number =0;
            while (a){
                Random rnd = new Random();
                number = rnd.nextInt(9999);

                Agent agent=agentService.getAgentByPromo(String.format("%04d", number));
                if(agent==null){
                    a=false;
                }

            }

            agentService.updatAgentByResult(result, String.format("%04d", number), agentId);

            if (result.equals("Accepted")) {
                Users users = userService.getUserById(userId);
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("springtest981420@gmail.com");
                message.setTo(users.getEmail());
                message.setSubject("Promo code by admin");
                message.setText("Admin accepted your request and Your  Promocode is=" + String.format("%04d", number));
                emailSender.send(message);
            } else {

            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<String>("Sucessfully " + result, HttpStatus.OK);
    }

    @GetMapping("/updateServiceProvider/{result},{serviceProviderId},{userId}")
    public ResponseEntity<String> updateServiceProvider(@PathVariable("result") String result,
                                                        @PathVariable("serviceProviderId") int serviceProviderId,
                                                        @PathVariable("userId") int userId

    ) {

        try {

            serviceProviderService.updateServiceProviderByResult(serviceProviderId, result);
            if (result.equals("Accepted")) {

                Users users = userService.getUserById(userId);
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("springtest981420@gmail.com");
                message.setTo(users.getEmail());
                message.setSubject("Admin Accepeted your account");
                message.setText("Admin accepted");
                emailSender.send(message);
            } else {

            }

            return new ResponseEntity<String>("Sucessfully " + result, HttpStatus.OK);


        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    @GetMapping("/getServiceProviders")
    public ResponseEntity<ArrayList<ServiceProvider>> getServiceProviders() {
        ArrayList<ServiceProvider> serviceProviders = null;
        try {
            serviceProviders = serviceProviderService.getServiceProviderByResult();

            return new ResponseEntity<ArrayList<ServiceProvider>>(serviceProviders, HttpStatus.OK);

        } catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/getBranches")
    public ResponseEntity<ArrayList<Branch>> getBranches() {
        ArrayList<Branch> branches = null;
        try {
            branches = serviceConsumerService.getBranches();

            return new ResponseEntity<ArrayList<Branch>>(branches, HttpStatus.OK);

        } catch (Exception ex) {
            return null;
        }

    }

    @GetMapping("/getServiceProvicer1/{location},{category}")
    public ResponseEntity<ArrayList<ServiceProvider>> getServiceProvider1(@PathVariable("location") int location,
                                                        @PathVariable("category") String category
    ) {

        try {
            ArrayList<ServiceProvider> serviceProviders = null;
            System.out.println(location);

            System.out.println(category);

            if(!category.equals(null)&&(location!=0)){
                serviceProviders=serviceProviderService.getServiceProviderByCategoryAndLocation(location,"%"+category+"%");
            }else if(location == 0){
                serviceProviders=serviceProviderService.getServiceProviderByCategory(category);
            }else{
                serviceProviders=serviceProviderService.getServiceProviderByLocation(location);

            }


            return new ResponseEntity<ArrayList<ServiceProvider>>(serviceProviders, HttpStatus.OK);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.getMessage();
        }
        return null;
    }

    @GetMapping("/getUserTypes1")
    public String getUserTypes1() {
        ArrayList<UserType> usersTypes = null;
        try {
            usersTypes = userTypeService.getUserType();

            return usersTypes.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    @PostMapping("/login1")
    public Users login1(@RequestBody Users users) {
        Users users1;
        try {
            users1 = userService.getUserByEmail(users.getEmail());

            if (users1 == null) {
                return null;
            } else {
//                Random rnd = new Random();
//                int number = rnd.nextInt(9999);
//                SimpleMailMessage message = new SimpleMailMessage();
//                message.setFrom("springtest981420@gmail.com");
//                message.setTo("selvathayaan3@gmail.com");
//                message.setSubject("OTP Number");
//                message.setText(String.format("%04d", number));
//                emailSender.send(message);

//                return new ResponseEntity<String>(String.format("%04d", number), HttpStatus.OK);
                return users1;
            }

        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @PostMapping("/login2")
    public ResponseEntity<String> login2(@RequestBody Users users) {
        Users users1;
        try {
               users1 = userService.getUserByEmail(users.getEmail());
                Random rnd = new Random();
                int number = rnd.nextInt(9999);
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("springtest981420@gmail.com");
                message.setTo(users.getEmail());
                message.setSubject("OTP Number");
                message.setText(String.format("%04d", number));
                emailSender.send(message);

                return new ResponseEntity<String>(String.format("%04d", number), HttpStatus.OK);


        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/updatePackage/{packageName},{price},{description},{packageId}")
    public ResponseEntity<String> updatePackage(@PathVariable("packageName") String packageName,
                                                        @PathVariable("price") String price,
                                                       @PathVariable("description") String description,
                                                        @PathVariable("packageId") int packageId

    ) {

        try {

            packageService.updatePackage(packageName, price,description,packageId);

            return new ResponseEntity<String>("Sucessfully Package Details Updated", HttpStatus.OK);


        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    @GetMapping("/getPackage/{id}")
    public Object getPackages(@PathVariable("id")int id) {
        Object packages = null;
        try {
            packages = packageService.getAPackage(id);
            return packages;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @GetMapping("/getServiceProviserCount")
    public int getServiceProviserCount() {
        int count = 0;
        try {
            count = serviceProviderService.getServiceProviserCount();
            return count;
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }

    }

    @GetMapping("/getServiceConsumerCount")
    public int getServiceConsumerCount() {
        int count = 0;
        try {
            count = serviceConsumerService.getServiceConsumerCount();
            return count;
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }

    }

    @GetMapping("/getAgentCount")
    public int getAgentCount() {
        int count = 0;
        try {
            count = agentService.agentCount();
            return count;
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }

    }

    @GetMapping("/getAgentById/{agentId}")
    public Agent  getAgentById(@PathVariable("agentId")int id) {
        Agent agent = null;
        try {
            agent = agentService.getAgentById(id);
            return agent;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }



    @GetMapping("/getServiceProviderById/{serviceProviderId}")
    public ServiceProvider  getServiceProviderById(@PathVariable("serviceProviderId")int id) {
        ServiceProvider serviceProvider = null;
        try {
            serviceProvider = serviceProviderService.getServiceProviderByUserId(id);
            return serviceProvider;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @PostMapping("/updateUser")
    public String  updateUser(
    @RequestParam("userName") String userName,
    @RequestParam("address") String address,
    @RequestParam("contactNumber") String contactNumber,
    @RequestParam("image") String image,
    @RequestParam("userId") int userId){

        try {
           userService.updateUser(userName,address,contactNumber,image,userId);
           return "User Details updated Successfully";

        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @PostMapping("/saveImge")
    public ResponseEntity<String> saveAttachment(@RequestParam("image") MultipartFile multipartFile) {
        try {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            String uploadDir = "attachments/";

            saveFile(uploadDir, fileName, multipartFile);

            return new ResponseEntity<String>(uploadDir + fileName, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getServiceProviderByUser/{userId}")
    public ServiceProvider  getServiceProviderByUser(@PathVariable("userId")int userId) {
        ServiceProvider serviceProvider = null;
        try {
            serviceProvider = serviceProviderService.getServiceProviderByUser(userId);
            return serviceProvider;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @GetMapping("/getAgentByUser/{userId}")
    public Agent  getAgentByUser(@PathVariable("userId")int userId) {
        Agent agent = null;
        try {
            agent = agentService.getAgentByUser(userId);
            return agent;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @GetMapping("/gerServiceConsumer/{userId}")
    public ServiceConsumer  getServiceConsumerByUser(@PathVariable("userId")int userId) {
        ServiceConsumer serviceConsumer = null;
        try {
            serviceConsumer = serviceConsumerService.getServiceConsumerByUser(userId);
            return serviceConsumer;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

   @GetMapping("/sendEmail")
    public ResponseEntity<String> sendEmail() throws IOException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("springtest981420@gmail.com");
        message.setTo("selvathayaan3@gmail.com");
        message.setSubject("aaaaa");
        message.setText("hi thayaan");
        emailSender.send(message);

        return new ResponseEntity<String>("Thayaan", HttpStatus.OK);
    }

    @GetMapping("/updatePromoCount/{promoCode}")
    public String  getServiceConsumerByUser(@PathVariable("promoCode")String promoCode) {

        try {
            agentService.updatePromoCount(promoCode);
            return "promo code updated successfully";
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }


}
