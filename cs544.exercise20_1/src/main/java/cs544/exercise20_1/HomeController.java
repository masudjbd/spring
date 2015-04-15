/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.exercise20_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String home(Model model){
        return "home";
    }
}
