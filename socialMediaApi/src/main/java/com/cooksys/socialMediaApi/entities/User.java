package com.cooksys.socialMediaApi.entities;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_table")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String passWord;
	
	private Timestamp joined;
	
	private Boolean deleted =  false;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	@ManyToMany
    @JoinTable(
        name = "followers_following",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "following_id")
    )
	private List<User> following;

    @ManyToMany(mappedBy = "following")
    private List<User> followers;
	
	
    @ManyToMany
    @JoinTable(
        name = "user_likes",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "tweet_id")
    )
    private List<Tweet> likedTweets;
    
    @ManyToMany
    @JoinTable(
        name = "user_mentions",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "tweet_id")
    )
    private List<Tweet> mentionedInTweets;
    
    
    
    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets;
    
	@PrePersist
	protected void onCreate() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		this.joined = now;
	}

}
