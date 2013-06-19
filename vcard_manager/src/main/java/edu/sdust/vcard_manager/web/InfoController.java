package edu.sdust.vcard_manager.web;
import edu.sdust.vcard_manager.Info;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/infoes")
@Controller
@RooWebScaffold(path = "infoes", formBackingObject = Info.class)
public class InfoController {
}
