package com.rv02.evolvFit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends
        JpaRepository<Comment, Integer> {
    @Query(
            value = "SELECT c.* FROM Comments AS c JOIN parent_child_comment p ON c.id = p.child_comment_id WHERE p.parent_comment_id = ?1",
            nativeQuery = true
    )
    List<Comment> findAllChidren(int id);
}
