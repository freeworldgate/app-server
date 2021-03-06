package com.union.app.entity.用户;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="T_View_History")
public class InviteViewHistoryEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int viewId;

    private String userId;

    private String inviteId;

}
