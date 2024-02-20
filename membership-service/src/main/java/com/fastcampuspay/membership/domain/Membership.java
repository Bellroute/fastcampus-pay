package com.fastcampuspay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE) // 핵심 도메인 클래스는 오염이 되면 안되는 클래스. 값의 변경을 의도적으로 제한시키기 위해 생성자 접근 제한을 PRIVETE로 만들었음
public class Membership {

    @Getter private final String membershipId;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String  address;
    @Getter private final boolean isValid;
    @Getter private final boolean isCorp;

    public static Membership generateMember(
        MembershipId membershipId,
        MembershipName membershipName,
        MembershipEmail membershipEmail,
        MembershipAddress membershipAddress,
        MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp) {

        return new Membership(
            membershipId.membershipIdValue,
            membershipName.nameValue,
            membershipEmail.emailValue,
            membershipAddress.addressValue,
            membershipIsValid.isValidValue,
            membershipIsCorp.isCorpValue);
    }

    // 멤버 변수들은 정해진 public static class들로만 만들어질 수 있음
    @Value
    public static class MembershipId {

        public MembershipId(String value) {
            this.membershipIdValue = value;
        }

        String membershipIdValue;
    }

    @Value
    public static class MembershipName {

        public MembershipName(String value) {
            this.nameValue = value;
        }

        String nameValue;
    }

    @Value
    public static class MembershipEmail {

        public MembershipEmail(String value) {
            this.emailValue = value;
        }

        String emailValue;
    }

    @Value
    public static class MembershipAddress {

        public MembershipAddress(String value) {
            this.addressValue = value;
        }

        String addressValue;
    }

    @Value
    public static class MembershipIsValid {

        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }

        boolean isValidValue;
    }

    @Value
    public static class MembershipIsCorp {

        public MembershipIsCorp(boolean value) {
            this.isCorpValue = value;
        }

        boolean isCorpValue;
    }
}
