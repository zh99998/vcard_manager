package edu.sdust.vcard_manager;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class User {

    /**
     */
    @NotNull
    private String name;

    /**
     */
    @NotNull
    private String password;
}
