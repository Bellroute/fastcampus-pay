package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.domain.Membership.MembershipId;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public Membership mapToDomainEntity(MembershipJpaEntity membershipJpaEntity) {
        return Membership.generateMember(
            new MembershipId(membershipJpaEntity.getMembershipId() + ""),
            new Membership.MembershipName(membershipJpaEntity.getName()),
            new Membership.MembershipEmail(membershipJpaEntity.getEmail()),
            new Membership.MembershipAddress(membershipJpaEntity.getAddress()),
            new Membership.MembershipIsValid(membershipJpaEntity.isValid()),
            new Membership.MembershipIsCorp(membershipJpaEntity.isCorp())
        );
    }
}
