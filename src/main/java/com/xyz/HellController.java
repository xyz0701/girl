package com.xyz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HellController {
    @Autowired
    private Posn posn;

//@RequestMapping(value = "/hi",method = RequestMethod.GET)
@GetMapping(value = "/hi")
    public String say(@RequestParam(value = "id",required = false,defaultValue ="0") Integer id){
return "id"+id;
//    return posn.getCupSize();

    }
}
