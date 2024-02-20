package com.fastcampuspay.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {

}
