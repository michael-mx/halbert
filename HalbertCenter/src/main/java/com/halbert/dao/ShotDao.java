package com.halbert.dao;

import com.halbert.model.Shot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ShotDao extends JpaRepository<Shot,Long> {
}
