package edu.sdust.vcard_manager;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Info {

    /**
     */
    private String property;

    /**
     */
    private String type;

    /**
     */
    private String value;

    /**
     */
    @ManyToOne
    private Card card;
}
