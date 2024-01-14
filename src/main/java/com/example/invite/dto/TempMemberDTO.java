package com.example.invite.dto;

import com.example.invite.domain.MemberStatus;
import com.example.invite.domain.TempMemberEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TempMemberDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Max(5)
    private Integer phoneNumber;
    private String email;
    private String invitationLink;
    private MemberStatus activationStatus;
    public static TempMemberDTO toMemberDTO(TempMemberEntity tempMemberEntity){

        TempMemberDTO tempMemberDTO = new TempMemberDTO();
        tempMemberDTO.setId(tempMemberEntity.getId());
        tempMemberDTO.setName(tempMemberEntity.getName());
        tempMemberDTO.setPhoneNumber(tempMemberEntity.getPhoneNumber());
        tempMemberDTO.setEmail(tempMemberEntity.getEmail());
        tempMemberDTO.setInvitationLink("/temp/" + tempMemberEntity.getGroupId().getInvitationLink() +"/"
                                        + tempMemberEntity.getId());
        tempMemberDTO.setActivationStatus(tempMemberEntity.getMemberStatus());

        return tempMemberDTO;
    }
}
