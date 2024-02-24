package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.domain.Membership.MembershipAddress;
import com.fastcampuspay.membership.domain.Membership.MembershipEmail;
import com.fastcampuspay.membership.domain.Membership.MembershipId;
import com.fastcampuspay.membership.domain.Membership.MembershipIsCorp;
import com.fastcampuspay.membership.domain.Membership.MembershipIsValid;
import com.fastcampuspay.membership.domain.Membership.MembershipName;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort,
    ModifyMembershipPort {

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

    @Override
    public MembershipJpaEntity modifyMembership(
        MembershipId membershipId, MembershipName membershipName,
        MembershipEmail membershipEmail, MembershipAddress membershipAddress,
        MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = membershipRepository.getById(
            Long.parseLong(membershipId.getMembershipIdValue()));

        entity.setName(membershipName.getNameValue());
        entity.setEmail(membershipEmail.getEmailValue());
        entity.setAddress(membershipAddress.getAddressValue());
        entity.setValid(membershipIsValid.isValidValue());
        entity.setCorp(membershipIsCorp.isCorpValue());

        return membershipRepository.save(entity);
    }
}
