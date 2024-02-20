package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController { // controller는 http로의 요청과 첫 상호작용을 하는 외부로부터 내부로 들어오는(inbound) web 형태의 adapter로 볼 수 있음

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    public Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
