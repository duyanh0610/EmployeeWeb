package com.example.employeemanagement.specification;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static com.example.employeemanagement.entity.common.Constants.OPERATOR.*;

@RequiredArgsConstructor
public class CustomSpecification<T> implements Specification<T> {
    private String field;
    private String operator;
    private String value;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        switch (operator){
            case EQUALS:
                if(field.equalsIgnoreCase("username")){
                    predicate = criteriaBuilder.equal(root.get("username"),value);
                }

                break;
            case CONTAINS:
                if(field.equalsIgnoreCase("username")){
                    predicate = criteriaBuilder.like(root.get("username"),"%"+value+"%");
                }
                break;
            case NOT_EQUALS:
                break;
            case GREATER_THAN_OR_EQUALS:
                break;
            case LESS_THAN_OR_EQUALS:
                break;

        }
        return predicate;
    }
}
