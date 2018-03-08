package com.gech.demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NewsProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String choice;
    @ManyToMany(mappedBy = "choices")
    Set<AppUser> newsUsers;

    public NewsProfile() {
        this.newsUsers= new HashSet<>();
    }

    public NewsProfile(String choice) {
        this.choice = choice;
        this.newsUsers= new HashSet<>();
    }
}
