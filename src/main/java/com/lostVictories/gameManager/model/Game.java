package com.lostVictories.gameManager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "games")
public class Game extends BaseModel{

    @Id
    private UUID id;
    private String name;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Player> players = new HashSet<>();

    public Game(UUID id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }


    public void addPlayer(User user, String country){
        players.add(new Player(UUID.randomUUID(), user, this, country));
    }
}
