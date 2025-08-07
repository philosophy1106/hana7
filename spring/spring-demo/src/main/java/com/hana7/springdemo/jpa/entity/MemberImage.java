package com.hana7.springdemo.jpa.entity;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberImage extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String orgName;
	private String saveName;
	private String saveDir;

	//1명의 회원이 여러 개의 사진 가질 수 잇으니까 일대다
	@ManyToOne
	@JoinColumn(name = "member",
		foreignKey = @ForeignKey(
			name = "fk_MemberImage_member",
			foreignKeyDefinition = """
					foreign key (writer)
					   references Member(id)
					    on DELETE cascade on UPDATE cascade
				"""
		)
	)	private Member member;
}