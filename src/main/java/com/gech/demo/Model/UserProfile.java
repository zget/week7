package com.gech.demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String choice;
    private Category category;
    private Language language;
    private Country country;

    @ManyToMany(mappedBy = "choices")
    Set<AppUser> newsUsers;

    public UserProfile() {
        this.newsUsers= new HashSet<>();
    }

    public UserProfile(String choice) {
        this.choice = choice;
        this.newsUsers= new HashSet<>();
    }
}
