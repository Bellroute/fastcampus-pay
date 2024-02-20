package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.domain.Membership.MembershipAddress;
import com.fastcampuspay.membership.domain.Membership.MembershipEmail;
import com.fastcampuspay.membership.domain.Membership.MembershipIsCorp;
import com.fastcampuspay.membership.domain.Membership.MembershipIsValid;
import com.fastcampuspay.membership.domain.Membership.MembershipName;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter

@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(MembershipName membershipName,
        MembershipEmail membershipEmail,
        MembershipAddress membershipAddress, MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp) {

        return membershipRepository.save(
            new MembershipJpaEntity(
                membershipName.getNameValue(),
                membershipEmail.getEmailValue(),
                membershipAddress.getAddressValue(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue())
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipIdValue()));
    }
}
