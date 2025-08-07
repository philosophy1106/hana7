package com.hana7.springdemo.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hana7.springdemo.jpa.entity.MemberImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberImageDTO {
	private String orgName;
	private String saveName;
	private String saveDir;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long memberId;

	public MemberImageDTO(MemberImage image) {
		orgName = image.getOrgName();
		saveName = image.getSaveName();
		saveDir = image.getSaveDir();
		memberId = image.getMember().getId();
	}

	public String getLink() {
		return "/members/view/" + saveName + "?savedir=" + saveDir;
	}

	public MemberImage toEntity() {
		return MemberImage.builder()
			.orgName(orgName)
			.saveName(saveName)
			.saveDir(saveDir)
			.build();
	}
}