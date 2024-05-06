package com.ossian.FitFlow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "URLPicture")
    private String URLPicture;

    @JsonIgnore
    @ManyToMany(mappedBy = "communityCreated", cascade = CascadeType.ALL)
    private List<User> userCreated = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "communityAssociated",cascade = CascadeType.ALL)
    private List<User> userAdded = new ArrayList<>();

    @OneToMany(mappedBy="community",cascade = CascadeType.ALL )
    private List<Post> post = new ArrayList<>();




}