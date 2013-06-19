// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.sdust.vcard_manager.web;

import edu.sdust.vcard_manager.Card;
import edu.sdust.vcard_manager.Circle;
import edu.sdust.vcard_manager.Info;
import edu.sdust.vcard_manager.User;
import edu.sdust.vcard_manager.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Card, String> ApplicationConversionServiceFactoryBean.getCardToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<edu.sdust.vcard_manager.Card, java.lang.String>() {
            public String convert(Card card) {
                return new StringBuilder().append(card.getCreatedAt()).append(' ').append(card.getUpdatedAt()).toString();
            }
        };
    }
    
    public Converter<Long, Card> ApplicationConversionServiceFactoryBean.getIdToCardConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, edu.sdust.vcard_manager.Card>() {
            public edu.sdust.vcard_manager.Card convert(java.lang.Long id) {
                return Card.findCard(id);
            }
        };
    }
    
    public Converter<String, Card> ApplicationConversionServiceFactoryBean.getStringToCardConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, edu.sdust.vcard_manager.Card>() {
            public edu.sdust.vcard_manager.Card convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Card.class);
            }
        };
    }
    
    public Converter<Circle, String> ApplicationConversionServiceFactoryBean.getCircleToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<edu.sdust.vcard_manager.Circle, java.lang.String>() {
            public String convert(Circle circle) {
                return new StringBuilder().append(circle.getName()).append(' ').append(circle.getCreatedAt()).append(' ').append(circle.getUpdatedAt()).toString();
            }
        };
    }
    
    public Converter<Long, Circle> ApplicationConversionServiceFactoryBean.getIdToCircleConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, edu.sdust.vcard_manager.Circle>() {
            public edu.sdust.vcard_manager.Circle convert(java.lang.Long id) {
                return Circle.findCircle(id);
            }
        };
    }
    
    public Converter<String, Circle> ApplicationConversionServiceFactoryBean.getStringToCircleConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, edu.sdust.vcard_manager.Circle>() {
            public edu.sdust.vcard_manager.Circle convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Circle.class);
            }
        };
    }
    
    public Converter<Info, String> ApplicationConversionServiceFactoryBean.getInfoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<edu.sdust.vcard_manager.Info, java.lang.String>() {
            public String convert(Info info) {
                return new StringBuilder().append(info.getProperty()).append(' ').append(info.getType()).append(' ').append(info.getValue()).toString();
            }
        };
    }
    
    public Converter<Long, Info> ApplicationConversionServiceFactoryBean.getIdToInfoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, edu.sdust.vcard_manager.Info>() {
            public edu.sdust.vcard_manager.Info convert(java.lang.Long id) {
                return Info.findInfo(id);
            }
        };
    }
    
    public Converter<String, Info> ApplicationConversionServiceFactoryBean.getStringToInfoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, edu.sdust.vcard_manager.Info>() {
            public edu.sdust.vcard_manager.Info convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Info.class);
            }
        };
    }
    
    public Converter<User, String> ApplicationConversionServiceFactoryBean.getUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<edu.sdust.vcard_manager.User, java.lang.String>() {
            public String convert(User user) {
                return new StringBuilder().append(user.getName()).append(' ').append(user.getPassword()).toString();
            }
        };
    }
    
    public Converter<Long, User> ApplicationConversionServiceFactoryBean.getIdToUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, edu.sdust.vcard_manager.User>() {
            public edu.sdust.vcard_manager.User convert(java.lang.Long id) {
                return User.findUser(id);
            }
        };
    }
    
    public Converter<String, User> ApplicationConversionServiceFactoryBean.getStringToUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, edu.sdust.vcard_manager.User>() {
            public edu.sdust.vcard_manager.User convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), User.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getCardToStringConverter());
        registry.addConverter(getIdToCardConverter());
        registry.addConverter(getStringToCardConverter());
        registry.addConverter(getCircleToStringConverter());
        registry.addConverter(getIdToCircleConverter());
        registry.addConverter(getStringToCircleConverter());
        registry.addConverter(getInfoToStringConverter());
        registry.addConverter(getIdToInfoConverter());
        registry.addConverter(getStringToInfoConverter());
        registry.addConverter(getUserToStringConverter());
        registry.addConverter(getIdToUserConverter());
        registry.addConverter(getStringToUserConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
