package org.backendDevTest.shared.infraestructure.http;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ControllerError  implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        String status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        String resultResponse;
        if(("404").equals(status)){
            resultResponse = "Page not found, code 404";
        }else if(("505").equals(status)){
            resultResponse = "Internal error, code 505 ";
        }else {
            resultResponse = "Error";
        }
        ;
        return resultResponse;
    }
}
