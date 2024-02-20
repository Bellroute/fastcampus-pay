package com.fastcampuspay.membership.application.port.in;

import common.SelfValidating;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;

    @NotNull
    @NotBlank
    private final String address;

    @NotNull
    private final String email;

    @AssertTrue
    private final boolean isValid;

    private final boolean isCorp;

    public RegisterMembershipCommand(String name, String address, String email, boolean isValid,
        boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
