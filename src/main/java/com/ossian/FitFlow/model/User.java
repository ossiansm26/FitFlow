package com.ossian.FitFlow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="myuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastNames", nullable = false)
    private String lastNames;
    @Column(name = "age", nullable = false)
    private Date age;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "enrollamentDate", nullable = false)
    private Date enrollamentDate;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "roll")
    private String rol;
    @Column(name = "speciality")
    private String speciality;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "userCreated_routinesCreated",
            joinColumns = @JoinColumn(name = "routine_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Routine> routinesCreated = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "userAdded_routinesAssociated",
            joinColumns = @JoinColumn(name = "routine_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Routine> routinesAssociated = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "userCreated_communityCreated",
            joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Community> communityCreated = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "userAdded_communityAssociated",
            joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Community> communityAssociated = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "user_achivement",
            joinColumns = @JoinColumn(name = "achivement_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Achivement> achivement = new ArrayList<>();

    @OneToMany(mappedBy="user" )
    private List<Post> post = new ArrayList<>();

    @OneToMany(mappedBy="user" )
    private List<Comments> comment = new ArrayList<>();


}