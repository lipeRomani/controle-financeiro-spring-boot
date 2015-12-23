package br.com.romani.validators;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    EntityManager em;

    @Autowired
    ApplicationContext applicationContext;

    private String uniqueField;
    private String defaultMessage;
    private String primaryKey;
    private String uniquePropertyValue;
    private Long primaryKeyValue;
    private Class<?> clazz;
    private Class<?> entityClazz;

    @Override
    public void initialize(Unique unique) {
        this.uniqueField = unique.uniqueField();
        this.defaultMessage = unique.message();
        this.primaryKey = unique.primaryKey();
        entityClazz = unique.entity();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(defaultMessage)
                .addPropertyNode(uniqueField).addConstraintViolation();

        getValuesOfClass(object);

        if(isUpdate()){
            return true;
        }

        return isUnique(context);
    }

    private boolean isUnique(ConstraintValidatorContext context) {
        EasyCriteria<?> easyCriteria2 = EasyCriteriaFactory.createQueryCriteria(this.em, entityClazz);
        easyCriteria2.andEquals(uniqueField, uniquePropertyValue);
        List<?> list = easyCriteria2.getResultList();
        return list.size() == 0;
    }

    private boolean isUpdate() {
         if(primaryKeyValue > 0){
            EasyCriteria<?> easyCriteria = EasyCriteriaFactory.createQueryCriteria(this.em, entityClazz);
            easyCriteria.andEquals(this.primaryKey, primaryKeyValue);
            Object result = easyCriteria.getSingleResult();
            String actualValue;
            try {
                actualValue = BeanUtils.getProperty(result, uniqueField);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

            if(actualValue.equals(uniquePropertyValue)){
                return true;
            }

        }
        return false;
    }

    private void getValuesOfClass(Object object) {
        clazz = object.getClass();

        try {
            uniquePropertyValue = BeanUtils.getProperty(object, this.uniqueField);
            String property = BeanUtils.getProperty(object, this.primaryKey);
            if(property == null){
                primaryKeyValue = 0L;
            }else{
                primaryKeyValue = Long.parseLong(property);
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

}