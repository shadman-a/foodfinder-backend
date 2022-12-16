package dev.shadmanahmed.foodfinder.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shadmanahmed.foodfinder.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping

public class YelpController {
    @Value("${YELP_API_KEY}")
    private String key;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping( "/yelp")
    public ResponseEntity<?> fetchYelp(@RequestBody String body) {
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(body, new TypeReference<HashMap<String, String>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        String term = map.get("term");
        System.out.println(term);
        String lat = map.get("lat");
        String lng = map.get("long");
        try {
            HttpRequest request = HttpRequest
                    .get("https://api.yelp.com/v3/businesses/search?term=" + term + "&latitude=" + lat + "&longitude=" + lng)
                    .header("Authorization", "Bearer " + key)
                    .connectTimeout(12000);
            String res = request.body();
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/singlePlace")
    public ResponseEntity<?> getYelp(@RequestBody String body) {
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();


        try {
            map = mapper.readValue(body, new TypeReference<HashMap<String, String>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = map.get("id");
        try {
            HttpRequest request = HttpRequest
                    .get("https://api.yelp.com/v3/businesses/" + id)
                    .header("Authorization", "Bearer " + key)
                    .connectTimeout(12000);
            String res = request.body();
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
