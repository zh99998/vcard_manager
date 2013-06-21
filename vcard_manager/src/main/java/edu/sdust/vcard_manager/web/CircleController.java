package edu.sdust.vcard_manager.web;
import edu.sdust.vcard_manager.Circle;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;

@RequestMapping("/circles")
@Controller
@RooWebScaffold(path = "circles", formBackingObject = Circle.class)
@RooWebJson(jsonObject = Circle.class)
public class CircleController {
}
