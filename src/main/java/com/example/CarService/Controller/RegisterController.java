package com.example.CarService.Controller;

import com.example.CarService.domain.Car;
import com.example.CarService.domain.Vehicle;
import com.example.CarService.service.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//hello
@Controller
public class RegisterController {

    @Autowired
    Registration registration;

    @RequestMapping("/register")
    public String getRegistrationPage(Model carModel){
        Vehicle vehicle=registration.getNewCar();
        carModel.addAttribute("Vehicle",vehicle);
        return "carregister";
    }
  @RequestMapping("/done")
  public String getResponsePage(@ModelAttribute("vehicle") Car car) {
      if (registration.registerCar(car.getRegisterationNumber(), car.getCarName(), car.getCarDetails(), car.getCarWork())) {
          return "success";
      } else {
          return "carregister";
      }
  }
}
