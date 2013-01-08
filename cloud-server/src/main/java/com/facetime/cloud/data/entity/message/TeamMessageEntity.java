package com.facetime.cloud.data.entity.message;

import com.facetime.cloud.data.entity.user.TeamEntity;
import com.facetime.cloud.data.entity.user.UserEntity;
import com.facetime.cloud.data.support.EntityConstants;
import com.facetime.cloud.data.support.MessageStatus;
import com.facetime.cloud.data.support.MessageType;
import com.facetime.core.bean.BusinessObject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 团队消息实体
 *
 */
@Entity
public class TeamMessageEntity implements BusinessObject {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EntityConstants.SEQ_MSG)
	@SequenceGenerator(name = EntityConstants.SEQ_MSG, sequenceName = EntityConstants.SEQ_MSG)
	private long id;
	@Column(nullable = false, length = 500)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sendTime;

	@Enumerated(EnumType.STRING)
	private MessageType type;
	@Enumerated(EnumType.STRING)
	private MessageStatus status;

	@ManyToOne
	@JoinColumn
	private UserEntity sender;

	@ManyToOne
	@JoinColumn
	private TeamEntity receiver;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	public UserEntity getSender() {
		return sender;
	}

	public void setSender(UserEntity sender) {
		this.sender = sender;
	}

	public TeamEntity getReceiver() {
		return receiver;
	}

	public void setReceiver(TeamEntity receiver) {
		this.receiver = receiver;
	}

}
