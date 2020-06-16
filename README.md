# spring-jpa-one-to-many-one-to-one

https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate

Unidirectional @OneToMany

@OneToMany with @JoinColumn

```
post.getComments().remove(0);

Hibernate executes two statements instead of one:

update post_comment set post_id = null where post_id = 1 and id = 2
 
delete from post_comment where id=2
```