package com.chinook.store.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "artist2")
public class ArtistModel {

    @Id
    @Column(name = "artistid")
    private Integer artistId;

    @Column
    private String name;

}
