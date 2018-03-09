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
//    private Language language;
//    private Country country;

    @ManyToMany(mappedBy = "choices")
    Set<AppUser> newsUsers;

    public UserProfile() {
        this.newsUsers= new HashSet<>();
    }

    public UserProfile(String choice) {

        this.newsUsers= new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<AppUser> getNewsUsers() {
        return newsUsers;
    }

    public void setNewsUsers(Set<AppUser> newsUsers) {
        this.newsUsers = newsUsers;
    }
}
