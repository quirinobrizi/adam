/**
 *
 */
package eu.codesketch.adam.ui.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author quirino
 *
 */
@Controller
public class HomeInterface {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
