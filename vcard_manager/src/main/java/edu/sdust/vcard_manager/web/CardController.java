package edu.sdust.vcard_manager.web;
import edu.sdust.vcard_manager.Card;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cards")
@Controller
@RooWebScaffold(path = "cards", formBackingObject = Card.class)
public class CardController {
}
