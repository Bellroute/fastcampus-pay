package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership.MembershipId;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(MembershipId membershipId);
}
