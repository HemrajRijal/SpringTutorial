package com.hem.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: hemraj
 * Date:  2/2/18.
 */
@Controller
public class SillyController {
@RequestMapping("showForm")
    public String displayTheForm() {
    return "menu";
    }
}
