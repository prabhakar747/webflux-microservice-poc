/*
 * package com.webflux.poc.web;
 * 
 * import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.webflux.poc.constants.EmployeeConstants;
 * 
 * @Controller public class WelcomeController {
 * 
 * // inject via application.properties
 * 
 * @Value("${welcome.message:test}") private String message = "Hello World";
 * 
 * @RequestMapping("/welcome") public String welcome(Map<String, Object> model)
 * { model.put("message", this.message); return "welcome"; }
 * 
 * 
 * 
 * @RequestMapping("/form") String thymeleafPage(Model model) {
 * 
 * return EmployeeConstants.DISPLAY_FORM_DATA; }
 * 
 * 
 * }
 */