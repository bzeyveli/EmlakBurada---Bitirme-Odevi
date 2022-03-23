package com.patika.emlakburada.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdvertImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advert_id", referencedColumnName = "id")
    private Advert advert;
}
