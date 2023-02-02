package com.example.springboothibernateonetomany;

import com.example.springboothibernateonetomany.entity.Comment;
import com.example.springboothibernateonetomany.entity.Post;
import com.example.springboothibernateonetomany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateOneToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateOneToManyApplication.class, args);
	}
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		Post post=new Post("one to many mapping using jpa and hibernate","one to many mappingusing jpa and hibernate");
		Comment comment=new Comment("Very useful");
		Comment comment1=new Comment(	"informative ");
		Comment comment2=new Comment("Great post");
		post.getComments().add(comment);
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		this.postRepository.save(post);
	}
}
