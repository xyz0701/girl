package com.xyz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@RestController
public class GrilController {
    @Autowired
   GirlRepository girlRepository;

    @GetMapping(value="/GetList")
    public List<Girl> grilList(){
       return girlRepository.findAll();
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Girl grilAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }


    @GetMapping(value="/getId/{id}")
    public Girl grilId(@PathVariable("id") Integer id){
        return girlRepository.findById(id).orElse(null);
    }
    @PutMapping(value="/update/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    @DeleteMapping (value="/delete/{id}")
    public String grirdelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
        return "删除成功";
    }
    @GetMapping(value="/getAge/{age}")
    public List<Girl> grilage(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }
    @RequestMapping(value="/saveTo",method = RequestMethod.POST)
    @Transactional
    public Girl grilSavetwo(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
         girlRepository.save(girl);

        // int a=1/0;
        Girl girl1=new Girl();
        girl1.setAge(22);
        girl1.setCupSize("E");
        girlRepository.save(girl1);

        return null;
    }


}
