package com.project.mdsspring.repository.specification;

import com.project.mdsspring.dto.user.filter.UserFilterDto;
import com.project.mdsspring.entity.Role;
import com.project.mdsspring.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@NoArgsConstructor
public final class UserSpecifications {
    @SuppressWarnings("unchecked")
    public static Specification<User> findUsers(Collection<UserFilterDto> filters) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new LinkedList<>();
            Fetch<User, Role> roleFetch = root.fetch("roles", JoinType.LEFT);
            Join<User, Role> roleJoin = (Join<User, Role>) roleFetch;

            for (var filter : filters) {
                switch (filter.getUserField()) {
                    case ID -> {
                        Set<Integer> ids = filter.getValues()
                                .stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toSet());
                        predicates.add(criteriaBuilder.in(root.get("id")).value(ids));
                    }
                    case NICKNAME -> predicates.add(criteriaBuilder.in(root.get("nickname")).value(filter.getValues()));
                    case ROLES -> predicates.add(criteriaBuilder.in(root.get("code")).value(filter.getValues()));
                    default -> throw new IllegalArgumentException();
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
