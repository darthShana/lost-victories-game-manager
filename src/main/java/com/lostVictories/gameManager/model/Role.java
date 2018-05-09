package com.lostVictories.gameManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="roles")
public class Role extends BaseModel{

    @Id
    private UUID id;
    @Column(name="role")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }



}
