package com.fastcampuspay.membership.adapter.in.web;


import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.domain.Membership.MembershipId;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testRegisterMembership() throws Exception {
        RegisterMembershipRequest request =
            new RegisterMembershipRequest("name", "email", "address", false);

        Membership expect = Membership.generateMember(
            new MembershipId("1"),
            new Membership.MembershipName("name"),
            new Membership.MembershipEmail("email"),
            new Membership.MembershipAddress("address"),
            new Membership.MembershipIsValid(true),
            new Membership.MembershipIsCorp(false)
        );

        mockMvc.perform(
                MockMvcRequestBuilders.post("/membership/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(
                MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)));
    }
}