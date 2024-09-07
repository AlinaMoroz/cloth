package com.example.mobile_app.database.sets;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set, Long> {
    Page<Set>findByUserId(Long userId, Pageable pageable);

    Page<Set>findByNewsLineId(Long newsLineId, Pageable pageable);

}
