package com.example.example.service;

import com.example.example.model.TableForExample;
import com.example.example.repository.RepoValue;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ServiceForRestExample {
    @Autowired
    private RepoValue workWithStrings;

    @RequestMapping("/")
    public Any healthCheck(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return null;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public List<String> savePage(@RequestBody String pageContent) {

    String reverseString = new StringBuffer(pageContent).reverse().toString();

    TableForExample obj = new TableForExample();
    TableForExample sendToDb = obj.setValue(reverseString);

    workWithStrings.save(sendToDb);
    List<String> result = workWithStrings.returnStrings();

    return result;
    }
}


