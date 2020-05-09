package ru.sch2.b.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller

public class Controller1 {

    @Autowired

    private ClassAction classAction;

    @GetMapping(path = "/list")
    public @ResponseBody
    Iterable<Organisation> getAllOrganisation1() {
        return classAction.findAll();
    }

    @GetMapping(path = "add")
    public @ResponseBody
    String addNewOrganisation(@RequestParam String adress, @RequestParam String name, @RequestParam String latitude, @RequestParam String longitude, @RequestParam String type) {

        Organisation o = new Organisation();

        o.setAdress(adress);
        o.setLatitude(latitude);
        o.setLongitude(longitude);
        o.setName(name);
        o.setType(type);

        classAction.save(o);
        return "Saved!!!";

    }
}
